package cn.hhj.course.service.impl;

import cn.hhj.course.dao.UserMapper;
import cn.hhj.course.entity.User;
import cn.hhj.course.entity.UserExample;
import cn.hhj.course.service.UserService;
import cn.hhj.course.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/17 18:26
 * @Version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfoVo getUserInfoVoByUserId(int id) {
        return userMapper.getUserInfoVoByUserId(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }
}
