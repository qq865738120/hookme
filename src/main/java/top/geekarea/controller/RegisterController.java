package top.geekarea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注册页面控制类
 * Created by code_xia on 2017/4/9.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping("/")
    public String getRegister() {
        return "/register";
    }
}
