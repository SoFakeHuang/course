package cn.hhj.course.entity;

public class Grade {
    private Integer id;

    private Integer grade;

    private Integer user_id;

    private Integer teachers_course_id;

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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTeachers_course_id() {
        return teachers_course_id;
    }

    public void setTeachers_course_id(Integer teachers_course_id) {
        this.teachers_course_id = teachers_course_id;
    }
}