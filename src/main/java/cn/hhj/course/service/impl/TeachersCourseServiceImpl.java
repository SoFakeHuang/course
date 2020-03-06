package cn.hhj.course.service.impl;

import cn.hhj.course.dao.TeachersCourseMapper;
import cn.hhj.course.entity.TeachersCourse;
import cn.hhj.course.service.TeachersCourseService;
import cn.hhj.course.vo.TeachersCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/21 17:34
 * @Version 1.0
 */
@Service("teachersCourseService")
public class TeachersCourseServiceImpl implements TeachersCourseService {

    @Autowired
    TeachersCourseMapper teachersCourseMapper;

    @Override
    public List<TeachersCourse> selectByOnline() {
        TeachersCourse teachersCourse = new TeachersCourse();
        teachersCourse.setOnline(1);
        return teachersCourseMapper.select(teachersCourse);
    }

    @Override
    public List<TeachersCourseVo> getAllTeacherCourseVo() {
        return teachersCourseMapper.getAllTeacherCourseVo();
    }

    @Override
    public TeachersCourse selectById(int id) {
        TeachersCourse teachersCourse = new TeachersCourse();
        teachersCourse.setId(id);
        List<TeachersCourse> list = teachersCourseMapper.select(teachersCourse);
        if(list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int reduceCourse(int id) {
        return teachersCourseMapper.reduceCourse(id);
    }
}
