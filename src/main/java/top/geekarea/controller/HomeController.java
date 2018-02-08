package top.geekarea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  主页模版控制类
 * Created by code_xia on 2017/4/1.
 */
@Controller
public class HomeController {

    /**
     * 主页
     * @return
     */
    @GetMapping(value = "/")
    public String homePage() {
        return "/home";
    }


    /**
     * 测试controller
     * @return
     */
    @GetMapping(value = "/comtest")
    public String comTest() {
        return "/comtest";
    }


}
