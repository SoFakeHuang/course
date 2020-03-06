package cn.hhj.course;

import cn.hhj.course.dao.TeachersCourseMapper;
import cn.hhj.course.entity.TeachersCourse;
import cn.hhj.course.vo.TeachersCourseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/20 18:32
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Repository
public class TeahcersCourseTest {

    @Autowired
    TeachersCourseMapper teachersCourseMapper;

    @Test
    public void select(){
        TeachersCourse teachersCourse = new TeachersCourse();
        teachersCourse.setMax_number(120);

        List<TeachersCourse> list = teachersCourseMapper.select(teachersCourse);

        System.out.println(list.get(0).getClassroom());
    }

    @Test
    public void getTeacherCourseVo(){

        List<TeachersCourseVo> list = teachersCourseMapper.getAllTeacherCourseVo();

        System.out.println(list.get(0).getOnline());
    }

    @Test
    public void reduce(){
        teachersCourseMapper.reduceCourse(2);
    }

}
