package cn.hhj.course.service.impl;

import cn.hhj.course.dao.GradeMapper;
import cn.hhj.course.entity.Grade;
import cn.hhj.course.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/22 19:08
 * @Version 1.0
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Grade getGradeByUserIdCourseId(Integer userId, Integer teacherCourseId) {
        Grade grade = new Grade();
        grade.setUser_id(userId);
        grade.setTeachers_course_id(teacherCourseId);
        List<Grade> list = gradeMapper.select(grade);
        if(list.size()==0){
            return null;
        }
        return list.get(0);
    }
}
