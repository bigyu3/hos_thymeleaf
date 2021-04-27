package com.gty.hos.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gty
 * @create2021-01-31 16:08
 * 跳转管理员首页
 */
@Controller
@RequestMapping("admin")
public class IndexController {
  @RequestMapping("/index")
  public String index(){
      return "admin/index";
  }

}
