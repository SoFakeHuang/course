package cn.hhj.course.config;

import cn.hhj.course.interceptor.MethodTimerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/2/21 23:40
 * @Version 1.0
 */
@Configuration
public class MethodTimerConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //需要拦截的路径，/**表示需要拦截所有请求
        String[]addPathPatterns={"/**"};
        //不需要拦截的路径
        String [] excludePathPaterns={
                //登录路径
                "/course/login",
                //html静态资源
                "/**/*.html",
                //js静态资源
                "/**/*.js",
                //css静态资源
                "/**/*.css",
                //静态资源
                "/Static/**"
        };
        //注册一个方法拦截器
        registry.addInterceptor(new MethodTimerInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPaterns);
        //注册一个权限拦截器  如果有多个拦截器 ，只需要添加以下一行代码
        //registry.addInterceptor(new LoginInterceptor())
        // .addPathPatterns(addPathPatterns)
        // .excludePathPatterns(excludePathPatterns);
    }

}
