package cn.hhj.course.vo;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/28 22:43
 * @Version 1.0
 */
public class GradeEnterVo {
    private int account;
    private String name;
    private int grade;
    private int teacherCourseId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getTeacherCourseId() {
        return teacherCourseId;
    }

    public void setTeacherCourseId(int teacherCourseId) {
        this.teacherCourseId = teacherCourseId;
    }
}
