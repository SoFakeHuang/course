package cn.hhj.course.dao;

import cn.hhj.course.entity.Department;
import cn.hhj.course.entity.DepartmentExample;
import java.util.List;

public interface DepartmentMapper {
    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);
}