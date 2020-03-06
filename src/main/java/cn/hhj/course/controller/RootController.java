package cn.hhj.course.controller;

import cn.hhj.course.BaseInfo;
import cn.hhj.course.dao.CourseMapper;
import cn.hhj.course.dao.GradeMapper;
import cn.hhj.course.dao.GradeModificationReviewMapper;
import cn.hhj.course.dao.UserMapper;
import cn.hhj.course.entity.GradeModificationReview;
import cn.hhj.course.entity.User;
import cn.hhj.course.vo.CourseVo;
import cn.hhj.course.vo.GradeReviewVo;
import cn.hhj.course.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/24 21:29
 * @Version 1.0
 */
@Controller
public class RootController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private GradeModificationReviewMapper gradeModificationReviewMapper;

    /**
     * 跳转到查询成绩页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/ToGrade")
    public String ToGrade(Model model, HttpSession session){

        return "grade";
    }

    /**
     * 跳转至用户信息页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/ToInfo")
    public String ToInfo(Model model,HttpSession session){
        User user = (User) session.getAttribute(BaseInfo.USER);

        UserInfoVo userInfoVo = userMapper.getUserInfoVoByUserId(user.getId());

        model.addAttribute("userInfo",userInfoVo);

        switch (userInfoVo.getType()){
            case 1: return "info_teacher";
            case 2: return "info";
            default: return "error";
        }
    }

    @RequestMapping(value = "/ToCourseApplication")
    public String ToCourseApplication(Model model, HttpSession session){
        User user = (User) session.getAttribute(BaseInfo.USER);
        List<CourseVo> courseVoList = courseMapper.selectCourseVoByUserId(user.getId());
        model.addAttribute("courseVoList",courseVoList);
        return "courseApplication";
    }

    /**
     * 跳转到教师课程信息
     * @return
     */
    @RequestMapping(value = "/ToTeacherCourseInfo")
    public String toTeacherCourseInfo(){
        return "teacherCourseInfo";
    }

    /**
     * 跳转到教师成绩录入
     * @return
     */
    @RequestMapping(value = "/ToGradeEnter")
    public String toGradeEnter(){
        return "gradeEnter";
    }

    /**
     * 跳转到教师成绩录入
     * @return
     */
    @RequestMapping(value = "/ToGradeModificationReview")
    public String toGradeModificationReview(){
        return "gradeModificationReview";
    }

    /**
     * 跳转到成绩修改审批
     * @return
     */
    @RequestMapping(value = "/ToGradeReview")
    public String toGradeReview(Model model){
        List<GradeReviewVo> gradeReviewVoList = gradeModificationReviewMapper.selectGradeReviewVoList();

        model.addAttribute("gradeReviewVoList",gradeReviewVoList);
        return "gradeReview";
    }


}
