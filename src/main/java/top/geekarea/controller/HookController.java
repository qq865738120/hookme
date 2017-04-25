package top.geekarea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用页面控制类
 * Created by code_xia on 2017/4/9.
 */
@Controller
@RequestMapping("/hook")
public class HookController {

    @GetMapping("")
    public String getHook() {
        return "/hook";
    }
}
