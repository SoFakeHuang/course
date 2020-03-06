package cn.hhj.course.service;

import cn.hhj.course.entity.User;
import cn.hhj.course.entity.UserExample;
import cn.hhj.course.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/17 18:23
 * @Version 1.0
 */
public interface UserService {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    UserInfoVo getUserInfoVoByUserId(int id);

}
