package cn.hhj.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/14 21:32
 * @Version 1.0
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }
}
