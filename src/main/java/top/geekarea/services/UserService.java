package top.geekarea.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.geekarea.DAO.DaoResult;
import top.geekarea.DAO.UserDaoImp;
import top.geekarea.common.ComResult;
import top.geekarea.config.AESConfiguration;
import top.geekarea.config.MyMailConfiguration;
import top.geekarea.entity.User;
import top.geekarea.enums.*;
import top.geekarea.DAO.repository.UserRepository;
import top.geekarea.services.result.UserResult;
import top.geekarea.utils.AESUtil;
import top.geekarea.utils.MailUtil;
import top.geekarea.utils.UUIDUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  用户业务类
 * Created by code_xia on 2017/4/7.
 */
public class UserService {

    /**
     * 验证用户身份
     * @param jsonObject
     * @param httpServletResponse
     * @param userRepository
     * @return
     * @throws IOException
     */
    public UserResult verifyUser(JSONObject jsonObject,
                                 HttpServletResponse httpServletResponse,
                                 UserRepository userRepository,
                                 AESConfiguration aesConfiguration) throws IOException {

        if (jsonObject.getString("userName").equals("")) { //用户名为空
            return new UserResult(UserResultEnum.USER_NAME_NULL);
        }
        if (jsonObject.getString("password").equals("")){ //密码为空
            return new UserResult(UserResultEnum.PASSWORD_NULL);
        }
        User user = userRepository.findByUserNameOrEmail(jsonObject.getString("userName"),
                jsonObject.getString("userName")); //通过userName或者email查找用户
        if (user != null){
            if (user.getPassword().equals(AESUtil.encrypt(jsonObject.getString("password"),
                    aesConfiguration.getSecretKey()))){ //如果user对象中的password与请求中的password相同
                Cookie userNameCookie = new Cookie("userName", user.getUserName());
                userNameCookie.setPath("/");
                userNameCookie.setMaxAge(600000);
                httpServletResponse.addCookie(userNameCookie);
                Cookie passwordCookie = new Cookie("password", user.getPassword());
                passwordCookie.setPath("/");
                passwordCookie.setMaxAge(600000);
                httpServletResponse.addCookie(passwordCookie);
                Cookie emailCookie = new Cookie("email", user.getEmail());
                emailCookie.setPath("/");
                emailCookie.setMaxAge(600000);
                httpServletResponse.addCookie(emailCookie);
                Cookie iconCookie = new Cookie("icon", user.getIcon());
                iconCookie.setPath("/");
                iconCookie.setMaxAge(600000);
                httpServletResponse.addCookie(iconCookie);
                Cookie ageCookie = new Cookie("age", user.getAge().toString());
                ageCookie.setPath("/");
                ageCookie.setMaxAge(600000);
                httpServletResponse.addCookie(ageCookie);
                Cookie nickameCookie = new Cookie("nickname", user.getNickName());
                nickameCookie.setPath("/");
                httpServletResponse.addCookie(nickameCookie);
                nickameCookie.setMaxAge(600000);
                return new UserResult(UserResultEnum.LOGIN_SUCCESS);
            }else {
                return new UserResult(UserResultEnum.USER_NAME_OF_PASSWORD_ERROE);
            }
        }else { //用户不存在
            return new UserResult(UserResultEnum.USER_EXIST);
        }
    }

    /**
     * 注册用户
     * @param jsonObject
     * @param userRepository
     * @return
     */
    public ComResult register(JSONObject jsonObject, UserRepository userRepository, MyMailConfiguration myMailConfiguration,
                              AESConfiguration aesConfiguration) throws Exception {
        ComResult verifyResult = new FormVerifyService().registerFormVerify(jsonObject);
        if (verifyResult.isResult()) { //通过表单验证
            User user = JSON.parseObject(jsonObject.toJSONString(), User.class);
            user.setPassword(AESUtil.encrypt(jsonObject.getString("password1"), aesConfiguration.getSecretKey())); //密码加密
            user.setNickName(user.getUserName());
            if (new FormVerifyFactory().getVerifyByClass(FormVerifyEnum.EMAIL).form((String)jsonObject.get("userName")).isResult()) {
                user.setEmail(user.getUserName());
            }
            user.setBirthday(new Date());
            user.setCreateDate(new Date());
            DaoResult daoResult = new UserDaoImp().save(user, userRepository); //用户数据写入数据库
            if (daoResult.isResult()) { //用户信息成功写入数据库
                if (new FormVerifyFactory().getVerifyByClass(FormVerifyEnum.EMAIL).form((String)jsonObject.get("userName")).isResult()) {
//                    MailUtil.sendMail(user.getUserName(), UUIDUtil.createCode(), myMailConfiguration); //发送验证邮件
                }
            }
            return daoResult;
        } else { //没有通过表单验证
            return verifyResult;
        }
    }
}
