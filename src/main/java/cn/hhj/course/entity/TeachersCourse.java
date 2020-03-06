package cn.hhj.course.entity;

public class TeachersCourse {
    private Integer id;

    private Integer course_id;

    private String years;

    private Integer semester;

    private String classroom;

    private String class_time;

    private Integer students_number;

    private Integer max_number;

    private Integer fulled;

    private Integer online;

    private Integer week;

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years == null ? null : years.trim();
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time == null ? null : class_time.trim();
    }

    public Integer getStudents_number() {
        return students_number;
    }

    public void setStudents_number(Integer students_number) {
        this.students_number = students_number;
    }

    public Integer getMax_number() {
        return max_number;
    }

    public void setMax_number(Integer max_number) {
        this.max_number = max_number;
    }

    public Integer getFull() {
        return fulled;
    }

    public void setFull(Integer fulled) {
        this.fulled = fulled;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }
}