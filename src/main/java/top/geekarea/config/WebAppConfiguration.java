package top.geekarea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.geekarea.Interceptor.LoginInterceptor;
import top.geekarea.Interceptor.SafetyControlInterceptor;

/**
 * Created by code_xia on 2017/3/28.
 */
@Configuration
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }
    @Bean
    public HandlerInterceptor getSafetyControlInterceptor(){
        return new SafetyControlInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration interceptorRegistration = null;

        /*
        登陆验证拦截器配置
         */
        interceptorRegistration = registry.addInterceptor(getLoginInterceptor());
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/error");
        interceptorRegistration.excludePathPatterns("/");
        interceptorRegistration.excludePathPatterns("/comtest");
        interceptorRegistration.excludePathPatterns("/loginpost");
        interceptorRegistration.excludePathPatterns("/register/**");

        /*
        重复提交拦截器配置
         */
        interceptorRegistration = registry.addInterceptor(getSafetyControlInterceptor());
        interceptorRegistration.addPathPatterns("/register/finished");
        interceptorRegistration.addPathPatterns("/loginpost");
        super.addInterceptors(registry);
    }
}
