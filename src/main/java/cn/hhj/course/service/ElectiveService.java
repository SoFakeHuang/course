package cn.hhj.course.service;

import cn.hhj.course.dao.GradeMapper;
import cn.hhj.course.entity.Course;
import cn.hhj.course.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: SoFakeHuang
 * @Date: 2019/7/5 5:01
 * @Version 1.0
 */
@Service("electiveService")
public class ElectiveService {

    @Autowired
    TeachersCourseService teachersCourseService;

    @Autowired
    GradeMapper gradeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 根据传入的grade信息 插入到grade表中
     * @param grade
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int elective(Grade grade){

        //课程人数减1
        int success = teachersCourseService.reduceCourse(grade.getTeachers_course_id());
        if(success == 1){
            grade.setGrade(0);
            //插入到成绩表中
            return gradeMapper.insert(grade);
        }
        stringRedisTemplate.opsForValue().set(grade.getTeachers_course_id().toString(),"0");
        return 0;
    }

}
