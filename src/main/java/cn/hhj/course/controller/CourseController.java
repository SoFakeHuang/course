package cn.hhj.course.controller;

import cn.hhj.course.BaseInfo;
import cn.hhj.course.ResponsResult;
import cn.hhj.course.dao.CourseMapper;
import cn.hhj.course.entity.Course;
import cn.hhj.course.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/27 14:25
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/teacherCourse")
public class CourseController extends BaseController{

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 教师提交课程申请接口
     * 所需参数课程名称，课程类型，课程申请理由
     * @param course
     * @return
     */
    @RequestMapping(value = "/application")
    @ResponseBody
    public ResponsResult application(@RequestBody Course course, HttpSession session){

        if(course == null){
            return failHandler("参数缺失");
        }

        //判断是否已有课程
        Course c = new Course();
        c.setName(course.getName());
        List<Course> list = courseMapper.select(c);
        if(list.size()!= 0){
            return failHandler("已有该课程");
        }

        User user = (User)session.getAttribute(BaseInfo.USER);

        course.setUser_id(user.getId());
        course.setStatus(0);
        courseMapper.insertSelective(course);
        return inbound(null,"提交成功");
    }

}
