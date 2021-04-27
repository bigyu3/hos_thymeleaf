package com.gty.hos.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gty.hos.pojo.User;
import com.gty.hos.service.IUserService;
import com.gty.hos.vo.ResponseResult;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.List;

/**
 * @author gty
 * @create2021-01-31 15:07
 * 管理员用户控制层
 */
@Controller
@RequestMapping("admin/user")
public class AdminController {
    //注入userService层
    @Autowired
    private IUserService userService;

    /*
     * 管理员管理页面跳转
     * 导航栏点击管理员页面后跳转
     * */
    @RequestMapping("/manage")
    public String manage(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                         @RequestParam(required = false, defaultValue = "") String username,
                         Model model
    ) {
        //分页
        //给前端了4个属性
        // page 查询的所有分页数据  pageNo 1 pageSize 5 一页五条数据 path 路径
        IPage<User> page = userService.findList(pageNo, pageSize, username);
        //重点 这里使用mp的分页 返回的page 里面 包含了current（当前页）,pages（总页数），total（总记录数），records（记录，就是查询到的List集合）
        //前端要拿records
        model.addAttribute("page", page);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("username", username);
        model.addAttribute("path", "/admin/user/manage");

        return "admin/adminManage";
    }
    /*
     * 新增 点击添加
     * */
    @RequestMapping("/")
    public String addForm(User user,Model model){
        //这里跳转到 admin/adminForm 来添加
        //返回前端的model里面带了 请求的user
        model.addAttribute("admin",user);
        return "admin/adminForm";
    }
    /*
    * 异步插入记录 添加
    * */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseResult insert(@RequestBody User user){
        return userService.insertUser(user);
    }
    /*
    * 异步更新记录 修改 put
    * */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody User user){
        return  userService.updateUser(user);
    }
    /*
    * 异步删除记录  delete
    * */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    /*
    * 编辑 点击点出iframe 编辑窗口
    * */
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editForm(@PathVariable Integer id,Model model){
        User one = userService.findOne(id);
        //根据id查找到用户 编辑
        model.addAttribute("admin",one);
        return "admin/adminForm";
    }


}
