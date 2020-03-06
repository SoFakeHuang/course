package cn.hhj.course.entity;

public class Classes {
    private Integer id;

    private String name;

    private Integer students_number;

    private Integer department_id;

    private Integer head_teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStudents_number() {
        return students_number;
    }

    public void setStudents_number(Integer students_number) {
        this.students_number = students_number;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getHead_teacher() {
        return head_teacher;
    }

    public void setHead_teacher(Integer head_teacher) {
        this.head_teacher = head_teacher;
    }
}