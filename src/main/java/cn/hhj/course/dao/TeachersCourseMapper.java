package cn.hhj.course.dao;

import cn.hhj.course.entity.Course;
import cn.hhj.course.entity.TeachersCourse;
import cn.hhj.course.entity.TeachersCourseExample;
import cn.hhj.course.vo.TeachersCourseVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeachersCourseMapper {
    int insert(TeachersCourse record);

    int insertSelective(TeachersCourse record);

    List<TeachersCourse> selectByExample(TeachersCourseExample example);

    int updataById(TeachersCourse record);

    /**
     * 根据传入的teacherCourse设置的属性来查询
     * 例如设置了id的就根据id为条件查询
     * */
    List<TeachersCourse> select(TeachersCourse teachersCourse);

    /**
     * 查询所有课程
     * @return
     */
    List<TeachersCourseVo> getAllTeacherCourseVo();

    /**
     * 获取用户个人课表,根据传入的学年和学期
     * @return
     */
    List<TeachersCourseVo> getTeacherCourseVoByUserIdYearSemester(@Param("userId") int userId,@Param("years") String years,@Param("semester")int semester);

    /**
     * 获取教师个人课表,根据传入的学年和学期
     * @return
     */
    List<TeachersCourseVo> getCourseVoByUserIdYearSemester(@Param("userId") int userId,@Param("years") String years,@Param("semester")int semester);

    /**
     * 对课程可选人数进行减1
     * @param id
     * @return
     */
    @Update("Update teachers_course Set students_number = students_number-1 Where id = #{id} And students_number > 0")
    int reduceCourse(@Param("id") int id);

    /**
     * 通过学号，学年，学期，课程名查询学生成绩
     * @param teachersCourseVo
     * @return
     */
    List<TeachersCourseVo> getCourseGradeByAccountYearSemesterCourseName(TeachersCourseVo teachersCourseVo);
}