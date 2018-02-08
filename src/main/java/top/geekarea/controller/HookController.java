package top.geekarea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用页模版控制类
 * Created by code_xia on 2017/4/9.
 */
@Controller
@RequestMapping("/hook")
public class HookController {

    /**
     * 应用页
     * @return
     */
    @GetMapping("")
    public String getHook() {
        return "/hook";
    }
}
