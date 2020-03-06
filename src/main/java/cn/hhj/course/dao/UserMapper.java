package cn.hhj.course.dao;

import cn.hhj.course.entity.User;
import cn.hhj.course.entity.UserExample;
import cn.hhj.course.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    UserInfoVo getUserInfoVoByUserId(@Param("id") int id);

    User selectByAccount(@Param("account") String account);
}