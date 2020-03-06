package cn.hhj.course.entity;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/3/3 0:47
 * @Version 1.0
 */
public class GradeModificationReview {
    private Integer id;
    private Integer grade;
    private String account;
    private Integer teacherCourseId;
    private Integer status;
    private String introduce;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getTeacherCourseId() {
        return teacherCourseId;
    }

    public void setTeacherCourseId(Integer teacherCourseId) {
        this.teacherCourseId = teacherCourseId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
