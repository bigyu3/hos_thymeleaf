package com.gty.hos.interceptor;

import com.gty.hos.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author gty
 * @create2021-01-26 23:03
 * 自定义登陆拦截器
 * 实现跳转首页
 */
@Component   //注入到ioc容器
public class LoginInterceptor  implements HandlerInterceptor { //实现springmvc拦截器接口

/*重写 父类 处理之前的方法
* */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拿到session
        HttpSession session = request.getSession();
        // 得到session中user的属性 强转为user
        User user = (User) session.getAttribute("user");
        //如果没有user 就 重定向到登陆页
        if(user == null){
            response.sendRedirect(request.getContextPath()+"/home/user/login");
            return false; //这里返回 false

            /*拦截器 preHandle 内 true和false含义?
            有权限应返回 true 放行,执行 controller
            没有权限返回 false,拒绝后续执行*/
        }
       return  true;
    }
}
