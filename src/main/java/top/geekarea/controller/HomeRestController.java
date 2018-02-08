package top.geekarea.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.geekarea.common.ComResult;
import top.geekarea.common.HTTPResult;
import top.geekarea.DAO.repository.UserRepository;
import top.geekarea.config.AESConfiguration;
import top.geekarea.services.UserService;
import top.geekarea.utils.HttpServletUtil;
import top.geekarea.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  主页数据接口控制类
 * Created by code_xia on 2017/4/6.
 */
@RestController
public class HomeRestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AESConfiguration aesConfiguration;

    /**
     *  登陆url
     */
    @PostMapping(value = "/loginpost")
    public HTTPResult loginPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JSONObject jsonObject = HttpServletUtil.getRequestPayload2JSON(httpServletRequest);
        UserService userService = new UserService();
        ComResult comResult = userService.verifyUser(jsonObject, httpServletResponse, userRepository, aesConfiguration);
        return ResultUtil.success((JSONObject)JSONObject.parse("{\"code\":\""+comResult.getCode()+"\",\"msg\":\""+comResult.getMsg()+"\"}"));
    }
}
