package top.geekarea.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.geekarea.DAO.UserDao;
import top.geekarea.DAO.UserDaoImp;
import top.geekarea.common.ComResult;
import top.geekarea.config.MyMailConfiguration;
import top.geekarea.entity.Result;
import top.geekarea.DAO.repository.UserRepository;
import top.geekarea.entity.User;
import top.geekarea.services.FormVerifyService;
import top.geekarea.services.UserService;
import top.geekarea.services.VerifyResult;
import top.geekarea.utils.HttpServletUtil;
import top.geekarea.utils.MailUtil;
import top.geekarea.utils.ResultUtil;
import top.geekarea.utils.UUIDUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册页面其余控制器类
 * Created by code_xia on 2017/4/16.
 */
@RestController
@RequestMapping("/register")
public class RegisterRestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MyMailConfiguration myMailConfiguration;

    /**
     * 提交注册信息接口
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    @PostMapping("/finished")
    public Result formFinished(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JSONObject jsonObject = HttpServletUtil.getRequestPayload2JSON(httpServletRequest);
        ComResult comResult = new UserService().register(jsonObject, userRepository, myMailConfiguration);
        return ResultUtil.success((JSONObject) JSONObject.parse("{\"result\":\""+comResult.isResult()+"\",\"msg\":\""+comResult.getMsg()+"\"}"));
    }

    @GetMapping(value = "/active/{code}")
    public void activeUser(@PathVariable String code) {
        System.out.println("test:   "+code);
    }

}
