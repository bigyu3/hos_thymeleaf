package com.gty.hos.controller.home;

import com.gty.hos.pojo.User;
import com.gty.hos.service.IUserService;
import com.gty.hos.vo.ActiveUser;
import com.gty.hos.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.servlet.http.PushBuilder;

/**
 * @author gty
 * @create2021-01-26 22:57
 */
@Controller
@RequestMapping("/home/user")
public class LoginController {
    @Autowired
    private IUserService userService; //注入service层

    /*
    * 登陆页面
    * */
    @RequestMapping("/login")
    public String loginRegisterPage(){
        return "home/login&register";
    }

    /**
     * 请求登录
     */
    @ResponseBody //响应为字符串 json
    @RequestMapping(value = "/login",method = RequestMethod.POST) //rest login的post请求
    //前端给 一个user 和 一个 session
    public ResponseResult login( @RequestBody User user, HttpSession httpSession){
        //调用checkUser 判断用户是否是数据库中的
        ResponseResult responseResult = userService.checkUser(user, httpSession);
        //返回结果为自定义的 Response 响应格式
        return responseResult;
    }

    /**
     * 注册用户
     */
    @ResponseBody
    @RequestMapping(value ="/register",method = RequestMethod.POST)
    public ResponseResult register(@RequestBody ActiveUser activeUser){
        return userService.registerUser(activeUser);
    }

    /**
     * 安全退出
     */
    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        // 清除sessin
        session.invalidate();
        return "redirect:/home/user/login";
    }
}
