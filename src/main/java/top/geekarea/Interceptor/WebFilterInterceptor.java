package top.geekarea.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.geekarea.entity.User;
import top.geekarea.DAO.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by code_xia on 2017/3/28.
 */
public class WebFilterInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(WebFilterInterceptor.class) ;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        获取post请求的数据
//        HttpServletUtil httpServletUtil = new HttpServletUtil();
//        String data = httpServletUtil.getRequestPayload(httpServletRequest);
//        System.out.println(data);
//        JSONObject jsonObject =  (JSONObject) JSON.parse(data);
//        System.out.println(jsonObject.get("userName"));
        Cookie[] cookies = httpServletRequest.getCookies();
        User user = null;
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("userName")) { //找到存放用户名的cookie
                    user = userRepository.findByUserName(c.getValue());
                }
                if (c.getName().equals("password")) { //找到存放密码的cookie
                    if (user != null){
                        if (c.getValue().equals(user.getPassword())) { //密码匹配成功
                            logger.info("【身份验证成功】："+user.toString());
                            return true;
                        }
                    }
                }
            }
        }
        logger.info("【身份验证失败】：跳转到登陆页面");
        httpServletResponse.sendRedirect("/"); //跳转到登陆页面
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        HttpSession session = httpServletRequest.getSession();
//        if (session.getAttribute("username")=="user" && session.getAttribute("password")=="123456"){
//            httpServletResponse.sendRedirect("/hello");
//        }
//        System.out.println(session.getAttribute("username"));
            //httpServletResponse.sendRedirect("/login");
        System.out.println("开始渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("结束");
    }
}
