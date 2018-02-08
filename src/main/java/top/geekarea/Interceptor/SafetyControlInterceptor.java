package top.geekarea.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.geekarea.common.ComResult;
import top.geekarea.services.SafetyControlService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全控制拦截器
 * Created by code_xia on 2017/5/4.
 */
public class SafetyControlInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(SafetyControlInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        SafetyControlService safetyControlService = new SafetyControlService();
        ComResult comResult = safetyControlService.repeatCommit(httpServletRequest, httpServletResponse, httpServletRequest.getMethod());
            if (comResult.isResult()) { //通过安全控制验证
                return true;
            } else {
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.addHeader("msg", comResult.getMsg());
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
