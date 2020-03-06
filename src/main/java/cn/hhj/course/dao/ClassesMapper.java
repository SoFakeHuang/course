package cn.hhj.course.dao;

import cn.hhj.course.entity.Classes;
import cn.hhj.course.entity.ClassesExample;
import java.util.List;

public interface ClassesMapper {
    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExample(ClassesExample example);
}