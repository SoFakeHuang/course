package cn.hhj.course.service;

import cn.hhj.course.entity.Grade;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/22 19:05
 * @Version 1.0
 */
public interface GradeService {
    /**
     * 查看用户是否已选该课程
     * 通过用户id和课程id
      */
    Grade getGradeByUserIdCourseId(Integer userId, Integer teacherCourseId);
}
