package top.geekarea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by code_xia on 2017/3/29.
 */
@Controller
public class TestView {

    @GetMapping("/hello")
    public String hello(){
        return "/hello";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

//    @PostMapping("/loginPost")
//    public String loginPost(){
//        return "/hello";
//    }
}
