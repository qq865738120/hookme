package top.geekarea.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.geekarea.common.ComResult;
import top.geekarea.entity.Result;
import top.geekarea.DAO.repository.UserRepository;
import top.geekarea.services.UserService;
import top.geekarea.utils.HttpServletUtil;
import top.geekarea.utils.MailUtil;
import top.geekarea.utils.ResultUtil;
import top.geekarea.utils.UUIDUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  主页其余控制器类
 * Created by code_xia on 2017/4/6.
 */
@RestController
public class HomeRestController {

    @Autowired
    UserRepository userRepository;

    /**
     *  登陆url
     */
    @PostMapping(value = "/loginpost")
    public Result loginPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JSONObject jsonObject = HttpServletUtil.getRequestPayload2JSON(httpServletRequest);
        ComResult comResult = new UserService().verifyUser(jsonObject, httpServletResponse, userRepository);
        return ResultUtil.success((JSONObject)JSONObject.parse("{\"code\":\""+comResult.getCode()+"\",\"msg\":\""+comResult.getMsg()+"\"}"));
    }
}
