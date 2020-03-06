package cn.hhj.course.controller;

import cn.hhj.course.BaseInfo;
import cn.hhj.course.ResponsResult;
import cn.hhj.course.dao.GradeMapper;
import cn.hhj.course.dao.TeachersCourseMapper;
import cn.hhj.course.entity.Grade;
import cn.hhj.course.entity.GradeExample;
import cn.hhj.course.entity.TeachersCourse;
import cn.hhj.course.entity.User;
import cn.hhj.course.rabbitmq.ElectiveMessage;
import cn.hhj.course.rabbitmq.MQSender;
import cn.hhj.course.service.GradeService;
import cn.hhj.course.service.TeachersCourseService;
import cn.hhj.course.vo.TeachersCourseVo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/21 21:22
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/course")
public class TeachersCourseController extends BaseController implements InitializingBean {

    @Autowired
    private TeachersCourseService teachersCourseService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private TeachersCourseMapper teachersCourseMapper;

    @Autowired
    private MQSender sender;

    /**
     * 用于记录选课是否以满，减少访问量
     */
    private Map<Integer, Boolean> localOverMap = new HashMap<>();

    /**
     * 系统数据初始化，讲选课信息放入redis
     * */
    @Override
    public void afterPropertiesSet() throws Exception {
        List<TeachersCourse> list = teachersCourseService.selectByOnline();
        if(list == null){
            return;
        }
        for (TeachersCourse c: list) {
            if(c.getFull() == 1){
                continue;
            }
            stringRedisTemplate.opsForValue().set(c.getId().toString(),c.getStudents_number().toString());
            localOverMap.put(c.getId(),false);
        }
    }

    /**
     * 数据重置接口
     * 重置redis课程缓存和内存标记
     * @return
     */
    @RequestMapping(value = "/reset")
    @ResponseBody
    public ResponsResult<Integer> reset(){
        List<TeachersCourse> list = teachersCourseService.selectByOnline();
        for (TeachersCourse c: list) {
            if(c.getFull() == 1){
                continue;
            }
            stringRedisTemplate.opsForValue().set(c.getId().toString(),c.getStudents_number().toString());
            localOverMap.put(c.getId(),false);
        }
        return inbound(null,"redis和内存标记重置成功");
    }

    /**
     * 基于redis的秒杀抢课接口
     * @param session
     * @param teachersCourseId
     * @return
     */
    @RequestMapping(value = "/elCourse")
    @ResponseBody
    public ResponsResult<Integer> elCourse(HttpSession session,@RequestBody Integer teachersCourseId){
        User user = (User)session.getAttribute(BaseInfo.USER);

        //读取内存标记，若课程以满则返回失败
        Boolean over = localOverMap.get(teachersCourseId);
        if(over == null ){
            return failHandler("课程id查找不到");
        }else if(over){
            return failHandler("课程以满");
        }

        //预减redis中的库存
        int count = stringRedisTemplate.opsForValue().increment(teachersCourseId.toString(),-1L).intValue();
        if(count < 0){
            localOverMap.put(teachersCourseId,true);
            return failHandler("redis库存已经为0");
        }

        //判断用户是否已经选取该课程
        Grade grade = gradeService.getGradeByUserIdCourseId(user.getId(),teachersCourseId);
        if(grade != null){
            return failHandler("用户以选取该课程");
        }

        //入队
        ElectiveMessage electiveMessage = new ElectiveMessage();
        electiveMessage.setUserId(user.getId());
        electiveMessage.setCourseId(teachersCourseId);
        sender.sendElectiveMessage(electiveMessage);

        //排队中
        return inbound(null,"选课成功");

    }

    /**
     * 查询用户课表，通过用户id，学年和学期
     * @param session
     * @return
     */
    @RequestMapping(value = "/getTeacherCourseVoByUser")
    @ResponseBody
    public ResponsResult<List<TeachersCourseVo>> getCourseByUser(HttpSession session,@RequestBody TeachersCourse teachersCourse){
        if(teachersCourse==null || teachersCourse.getYears() == null || teachersCourse.getSemester() == null){
            return failHandler("无传入参数");
        }

        User user = (User) session.getAttribute(BaseInfo.USER);

        List<TeachersCourseVo> list = teachersCourseMapper.getTeacherCourseVoByUserIdYearSemester(user.getId(),teachersCourse.getYears(),teachersCourse.getSemester());

        return inbound(list,"查询成功");
    }

    /**
     * 查询教师课表，通过用户id，学年和学期
     * @param session
     * @return
     */
    @RequestMapping(value = "/getCourseVoByUser")
    @ResponseBody
    public ResponsResult<List<TeachersCourseVo>> getTeacherCourseByUser(HttpSession session,@RequestBody TeachersCourse teachersCourse){
        if(teachersCourse==null || teachersCourse.getYears() == null || teachersCourse.getSemester() == null){
            return failHandler("无传入参数");
        }

        User user = (User) session.getAttribute(BaseInfo.USER);

        List<TeachersCourseVo> list = teachersCourseMapper.getCourseVoByUserIdYearSemester(user.getId(),teachersCourse.getYears(),teachersCourse.getSemester());
        return inbound(list,"查询成功");
    }

    /**
     * 查询学生成绩，通过课程号，学号，学年，学期
     * @param session
     * @param teachersCourse
     * @return
     */
    @RequestMapping(value = "/getCourseGradeByAccountYearSemesterCourseName")
    @ResponseBody
    public ResponsResult<List<TeachersCourseVo>> getCourseGradeByAccountYearSemesterCourseName(HttpSession session,@RequestBody TeachersCourseVo teachersCourse){
        if(teachersCourse==null){
            return failHandler("无传入参数");
        }

        User user = (User) session.getAttribute(BaseInfo.USER);
        teachersCourse.setUserId(user.getId());
        List<TeachersCourseVo> teachersCourseVo = teachersCourseMapper.getCourseGradeByAccountYearSemesterCourseName(teachersCourse);
        return inbound(teachersCourseVo,"查询成功");
    }



    /**
     * 跳转到选课页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/ToCourseList")
    public String ToCourseList(Model model){
        List<TeachersCourseVo> teachersCourseVo = teachersCourseService.getAllTeacherCourseVo();
        model.addAttribute("teachersCourseVoList",teachersCourseVo);
        return "course";
    }


}
