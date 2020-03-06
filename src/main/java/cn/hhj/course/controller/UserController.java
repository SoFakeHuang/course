package cn.hhj.course.controller;

import cn.hhj.course.BaseInfo;
import cn.hhj.course.dao.AnnouncementMapper;
import cn.hhj.course.entity.*;
import cn.hhj.course.service.UserService;
import cn.hhj.course.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/17 18:02
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private AnnouncementMapper announcementMapper;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){

        if(user.getAccount() == null || user.getPassword() == null) {
            System.out.println(1);
            return "login";
        }

        //设置账号和密码为检索条件
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(user.getAccount()).andPasswordEqualTo(user.getPassword());

        List<User> list = userService.selectByExample(userExample);
        if(list.size()!= 0){
            User u = list.get(0);
            //账号密码正确，将用户信息存入session，用于后续用户相关操作
            session.setAttribute(BaseInfo.USER, u);
            //读取公告，放入model
            List<Announcement> announcementList = announcementMapper.selectAll();
            model.addAttribute("announcementList",announcementList);
            //读取用户信息，放入model
            UserInfoVo userInfoVo = userService.getUserInfoVoByUserId(u.getId());
            model.addAttribute("userInfoVo",userInfoVo);

            switch (u.getType()){
                case 0:return "index_admin";

                case 1:return "index_teacher";

                case 2:return "index";

                default:return "error";
            }
        }
        return "login";
    }

    @RequestMapping(value = "/ToIndex")
    public String ToIndex(Model model,HttpSession session){
        User u = (User) session.getAttribute(BaseInfo.USER);
        List<Announcement> announcementList = announcementMapper.selectAll();
        model.addAttribute("announcementList",announcementList);
        //读取用户信息，放入model
        UserInfoVo userInfoVo = userService.getUserInfoVoByUserId(u.getId());
        model.addAttribute("userInfoVo",userInfoVo);

        switch (u.getType()){
            case 0: return "index_admin";
            case 1: return "index_teacher";
            case 2: return "index";
            default: return "error";
        }

    }



}
