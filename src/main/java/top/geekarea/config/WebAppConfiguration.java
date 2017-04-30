package top.geekarea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.geekarea.Interceptor.WebFilterInterceptor;

/**
 * Created by code_xia on 2017/3/28.
 */
@Configuration
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor getWebFilterInterceptor(){
        return new WebFilterInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(getWebFilterInterceptor());
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/error");
        interceptorRegistration.excludePathPatterns("/");
        interceptorRegistration.excludePathPatterns("/comtest");
        interceptorRegistration.excludePathPatterns("/loginpost");
        interceptorRegistration.excludePathPatterns("/register/**");
        super.addInterceptors(registry);
    }
}
