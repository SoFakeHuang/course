package cn.hhj.course.dao;

import cn.hhj.course.entity.Course;
import cn.hhj.course.entity.CourseExample;
import cn.hhj.course.vo.CourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    List<CourseVo> selectCourseVoByUserId(@Param("userId") int id);

    List<Course> select(Course record);
}