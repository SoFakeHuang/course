package cn.hhj.course.service;

import cn.hhj.course.entity.TeachersCourse;
import cn.hhj.course.vo.TeachersCourseVo;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/20 18:41
 * @Version 1.0
 */
public interface TeachersCourseService {
    /**
    *查询所有上线的课程
    * */
    List<TeachersCourse> selectByOnline();

    /**
     * 查询所有课程，以VO形式
     * @return
     */
    List<TeachersCourseVo> getAllTeacherCourseVo();

    /**
     * 通过课程号查询
     * @return
     */
    TeachersCourse selectById(int teacherCourseId);

    /**
     * 根据课程id进行剩余位置减1
     * @param id
     * @return
     */
    int reduceCourse(int id);
}
