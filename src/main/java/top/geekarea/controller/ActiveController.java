package top.geekarea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 激活控制类
 * Created by code_xia on 2017/4/21.
 */
@Controller
@RequestMapping("/active")
public class ActiveController {

    @GetMapping("/")
    public String activePage() {
        return "/active";
    }
}
