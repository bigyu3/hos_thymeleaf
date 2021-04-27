package com.gty.hos.config;

import com.gty.hos.interceptor.LoginInterceptor;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sun.rmi.runtime.Log;

/**
 * @author gty
 * @create2021-01-26 23:10
 */
@Configuration //配置类注解
public class WebConfig implements WebMvcConfigurer { // 实现springmvc配置接口
    @Autowired
    private LoginInterceptor loginInterceptor;//注入登陆拦截器

    //默认跳转路径  !!!! 需要在百度一下这里不是理解很清楚 https://blog.csdn.net/zhangpower1993/article/details/89016503
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //这里把请求/ 重定向到index页面
        registry.addRedirectViewController("/","/home/index");
    }
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //这里拦截了 admin patient doctor 的页面访问权 如果拦截器没有true
        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/**","patient/**","/doctor/**");
        /**

         - /**： 匹配所有路径
         - /admin/**：匹配 /admin/ 下的所有路径
         - /secure/*：只匹配 /secure/user，不匹配 /secure/user/info

         */
    }
}
