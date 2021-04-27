package com.gty.hos.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gty.hos.pojo.Patient;
import com.gty.hos.service.IPatientService;
import com.gty.hos.vo.QueryVo;
import com.gty.hos.vo.QueryVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gty
 * @create2021-02-18 11:47
 */
@Controller
@RequestMapping("/admin/patient")
public class PatientController {
    //注入医生service层
    @Autowired
    private IPatientService patientService;

    /*
     * 管理病人页跳转
     * */
    @RequestMapping("/manage")
    public String manage(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                         @RequestParam(required = false, defaultValue = "") String name,
                         @RequestParam(required = false, defaultValue = "") String idcard,
                         Model model) {
//        IPage<Patient> list = patientService.findList(pageNo, pageSize, name, idcard);

//        QueryVo2 list2 = patientService.findList2(new QueryVo2());
//        model.addAttribute("page",list2);
//        model.addAttribute("pageNo",pageNo);
//        model.addAttribute("name",name);
//        model.addAttribute("idcard",idcard);
//        model.addAttribute("path","/admin/patient/manage");
        return "admin/patientManage";
    }


    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return patientService.testp() + "";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public String findall() {
        patientService.findAll();
        return "ok";
    }

    /*
     * 管理病人页跳转
     * */
//    @RequestMapping("/manage")
//    public String manage(QueryVo queryVo, Model model) {
//        IPage<Patient> list = patientService.findList(queryVo);
//        model.addAttribute("page", list);
//        model.addAttribute("name",queryVo.getPatientName());
//        model.addAttribute("idcard",queryVo.getIdcard());
//        model.addAttribute("pageNo",queryVo.getPageNo());
//        model.addAttribute("path","/admin/patient/manage");
//        return "admin/patientManage";
//
//    }
}
