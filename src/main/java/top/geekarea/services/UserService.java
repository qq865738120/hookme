package top.geekarea.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.geekarea.DAO.DaoResult;
import top.geekarea.DAO.UserDao;
import top.geekarea.DAO.UserDaoImp;
import top.geekarea.common.ComResult;
import top.geekarea.entity.User;
import top.geekarea.enums.*;
import top.geekarea.DAO.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
                                 UserRepository userRepository) throws IOException {

        if (jsonObject.getString("userName").equals("")) { //用户名为空
            return new UserResult(UserResultEnum.USER_NAME_NULL);
//            return (JSONObject)JSONObject.parse("{\"code\":\"1\",\"msg\":\"用户名不能为空\"}");
        }
        if (jsonObject.getString("password").equals("")){ //密码为空
            return new UserResult(UserResultEnum.PASSWORD_NULL);
//            return (JSONObject)JSONObject.parse("{\"code\":\"2\",\"msg\":\"密码不能为空\"}");
        }
        User user = userRepository.findByUserNameOrEmail(jsonObject.getString("userName"),jsonObject.getString("userName")); //通过userName或者email查找用户
        if (user != null){
            if (user.getPassword().equals(jsonObject.getString("password"))){ //如果user对象中的password与请求中的password相同
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
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
                Cookie sexCookie = new Cookie("sex", user.getSex());
                sexCookie.setPath("/");
                sexCookie.setMaxAge(600000);
                httpServletResponse.addCookie(sexCookie);
                Cookie ageCookie = new Cookie("age", user.getAge().toString());
                ageCookie.setPath("/");
                ageCookie.setMaxAge(600000);
                httpServletResponse.addCookie(ageCookie);
                Cookie birthdayCookie = new Cookie("birthday", format.format(user.getBirthday()));
                birthdayCookie.setPath("/");
                birthdayCookie.setMaxAge(600000);
                httpServletResponse.addCookie(birthdayCookie);
                Cookie createDataCookie = new Cookie("createData", format.format(user.getCreateDate()));
                createDataCookie.setPath("/");
                createDataCookie.setMaxAge(600000);
                httpServletResponse.addCookie(createDataCookie);
                Cookie nickameCookie = new Cookie("nickname", user.getNickName());
                nickameCookie.setPath("/");
                httpServletResponse.addCookie(nickameCookie);
                nickameCookie.setMaxAge(600000);
                Cookie rankCookie = new Cookie("rank", user.getRank().toString());
                rankCookie.setPath("/");
                rankCookie.setMaxAge(600000);
                httpServletResponse.addCookie(rankCookie);
                Cookie tagCookie = new Cookie("tag", user.getTag().toString());
                tagCookie.setPath("/");
                tagCookie.setMaxAge(600000);
                httpServletResponse.addCookie(tagCookie);
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
    public ComResult register(JSONObject jsonObject, UserRepository userRepository) {
        ComResult verifyResult = new FormVerifyService().registerFormVerify(jsonObject);
        if (verifyResult.isResult()) { //通过表单验证
            User user = JSON.parseObject(jsonObject.toJSONString(), User.class);
            user.setPassword(jsonObject.getString("password1"));
            user.setNickName(user.getUserName());
            if (new FormVerifyFactory().getVerifyByClass(FormVerifyEnum.EMAIL).form((String)jsonObject.get("userName")).isResult()) {
                user.setEmail(user.getUserName());
            }
            DaoResult daoResult = new UserDaoImp().save(user, userRepository);
            return daoResult;
        } else { //没有通过表单验证
            return verifyResult;
        }
    }
}
