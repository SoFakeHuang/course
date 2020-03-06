package cn.hhj.course.controller;

import cn.hhj.course.BaseInfo;
import cn.hhj.course.ResponsResult;
import cn.hhj.course.dao.GradeMapper;
import cn.hhj.course.entity.TeachersCourse;
import cn.hhj.course.entity.User;
import cn.hhj.course.vo.GradeEnterVo;
import cn.hhj.course.vo.GradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/24 21:50
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/grade")
public class GradeController extends BaseController{

    @Autowired
    GradeMapper gradeMapper;


    /**
     * 学生查询自己课程成绩接口
     * 传入学年学期参数
     * @param session
     * @param teachersCourse
     * @return
     */
    @RequestMapping(value = "/getGradeVo")
    @ResponseBody
    public ResponsResult<List<GradeVo>> getGradeVo(HttpSession session,@RequestBody TeachersCourse teachersCourse){
        if(teachersCourse==null || teachersCourse.getYears() == null || teachersCourse.getSemester() == null){
            return failHandler("无传入参数");
        }

        User user = (User)session.getAttribute(BaseInfo.USER);
        List<GradeVo> list = gradeMapper.GradeVoByUserIdYearsSemester(user.getId(),teachersCourse.getYears(),teachersCourse.getSemester());

        return inbound(list,"查询成功");
    }

    /**
     * 获取该课程的所有学生成绩
     * @param teacherscourse
     * @return
     */
    @RequestMapping(value = "/getCourseGrade")
    @ResponseBody
    public ResponsResult<List<GradeVo>> getCourseGrade(@RequestBody TeachersCourse teacherscourse){
        if(teacherscourse == null || teacherscourse.getId() == null){
            return failHandler("参数缺失");
        }

        List<GradeVo> courseGradeList = gradeMapper.getCourseGradeByTeacherCourseId(teacherscourse.getId());
        return inbound(courseGradeList,"查询成功");
    }

    @RequestMapping(value = "/gradeEnter")
    @ResponseBody
    public ResponsResult<List<GradeVo>> gradeEnter(@RequestBody List<GradeEnterVo> list){
        if(list == null || list.size() == 0 ){
            return failHandler("参数缺失");
        }
        System.out.println(list.get(0).getGrade());
        for (GradeEnterVo gradeEnterVo:list
             ) {
            gradeMapper.updateByUserIdCourseId(gradeEnterVo);
        }

        return inbound(null,"更新成功");
    }

}
