package cn.hhj.course.dao;

import cn.hhj.course.entity.Grade;
import cn.hhj.course.entity.GradeExample;
import cn.hhj.course.vo.GradeEnterVo;
import cn.hhj.course.vo.GradeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {
    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    int update(Grade grade);

    /**
     * 根据传入的grade的对应值查询
     * @param grade
     * @return
     */
    List<Grade> select(Grade grade);

    /**
     * 通过用户id和学年，学期查询成绩
     * @param userId
     * @param years
     * @param semester
     * @return
     */
    List<GradeVo> GradeVoByUserIdYearsSemester(@Param("userId") int userId,@Param("years") String years,@Param("semester")int semester);

    /**
     * 通过teacherCourse的id查询该课程下所有学生的成绩
     * @param id
     * @return
     */
    List<GradeVo> getCourseGradeByTeacherCourseId(@Param("id") int id);

    /**
     * 根据用户id和课程号更新成绩
     * @param gradeEnterVo
     * @return
     */
    int updateByUserIdCourseId(GradeEnterVo gradeEnterVo);
}