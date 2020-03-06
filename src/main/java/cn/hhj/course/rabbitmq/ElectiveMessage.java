package cn.hhj.course.rabbitmq;

/**
 * @Author: SoFakeHuang
 * @Date: 2019/7/5 3:31
 * @Version 1.0
 */
public class ElectiveMessage {

    private String userName;

    private String courseName;

    private Integer userId;

    private Integer courseId;

    @Override
    public String toString() {
        return "ElectiveMessage{" +
                "userName='" + userName +
                ", courseName='" + courseName +
                ", userId=" + userId +
                ", courseId=" + courseId +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
