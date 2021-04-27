package com.gty.hos.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gty.hos.pojo.Doctor;
import com.gty.hos.pojo.User;
import com.gty.hos.service.IDoctorService;
import com.gty.hos.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

/**
 * @author gty
 * @create2021-02-06 14:22
 */
@Controller
@RequestMapping("/admin/doctor")
public class DoctorController {
    //注入医生service层
    @Autowired
    private IDoctorService doctorService;

    @ResponseBody
    @RequestMapping("/all")
    public List findAll() {
        List<Doctor> all = doctorService.findAll();

        return all;
    }

    /*
    * 管理医生页跳转
    * */
    @RequestMapping("/manage")
    public String manage(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                         @RequestParam(required = false,defaultValue = "") String name,
                         @RequestParam(required = false,defaultValue = "") String idcard,
                         Model model) {
        IPage<Doctor> list = doctorService.findList(pageNo, pageSize,name,idcard);
        model.addAttribute("page", list);
        model.addAttribute("name",name);
        model.addAttribute("idcard",idcard);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("path","/admin/doctor/manage");
        return "admin/doctorManage";
    }
    /*
    * 添加按钮跳转到iframe框
    * */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String addForm(Doctor doctor,Model model){
        //点击按钮后弹出一个iframe
        model.addAttribute("doctor",doctor);
        return "admin/doctorForm";
    }
    /*
    * 添加表单实现
    * <form class="layui-form"  onsubmit="return save('/admin/doctor/')">
    * */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult addDoctor(@RequestBody Doctor doctor, Model model){
       return doctorService.insertDoctor(doctor);
    }
    /*
    * 删除 异步
    * */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseResult delDoctor(@PathVariable Integer id){
        return   doctorService.delDoctor(id);
    }
    /*更新
    * 页面跳转 ifream
    * */
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editDoctor(@PathVariable Integer id ,Model model){
        //根据id找到修改医生
        Doctor doctor = doctorService.findDoctorById(id);
        model.addAttribute("doctor",doctor);
        return  "admin/doctorForm";
    }

    /*
    * 更新 异步
    * */
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult updateDoctor(@RequestBody Doctor doctor){
        return doctorService.updateDoctor(doctor);

    }
    /**
     * 根据部门查询医生
     */
    @ResponseBody
    @RequestMapping(value = "/getList/{department}")
    public List<Doctor> getList(@PathVariable String department){
        return doctorService.getListByDepartment(department);
    }
}
