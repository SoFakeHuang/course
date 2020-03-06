package cn.hhj.course;

import cn.hhj.course.dao.GradeMapper;
import cn.hhj.course.entity.Grade;
import cn.hhj.course.vo.GradeVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/22 17:40
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Repository
public class GradeTest {

    @Autowired
    GradeMapper gradeMapper;

    @Test
    public void select(){
        Grade grade = new Grade();
        grade.setUser_id(3);
        grade.setTeachers_course_id(3);
        List<Grade> list = gradeMapper.select(grade);

    }

    @Test
    public void GradeVo(){
        int userId = 1;
        String years = "2019-2020";
        int semester = 1;
        List<GradeVo> list = gradeMapper.GradeVoByUserIdYearsSemester(userId,years,semester);
        System.out.println(list.get(0).getCourseName());

    }

}
