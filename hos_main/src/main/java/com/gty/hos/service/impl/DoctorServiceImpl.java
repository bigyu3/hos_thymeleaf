package com.gty.hos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gty.hos.common.Global;
import com.gty.hos.pojo.Doctor;
import com.gty.hos.mapper.DoctorMapper;
import com.gty.hos.service.IDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gty.hos.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.print.Doc;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

    //注入mapper 医生
    @Autowired
    private DoctorMapper doctorMapper;

    //注入ResponseResult 这里ioc容器里拿 是prototype 多例模式 默认为singleton
    @Autowired
    private ResponseResult responseResult;
    @Override
    public IPage<Doctor> findList(Integer pageNo, Integer pageSize,String name,String idcard) {
        Page<Doctor> page = new Page<>(pageNo, pageSize);
        //条件查询
        QueryWrapper<Doctor> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)){
            wrapper.lambda().like(Doctor::getName,name);
        }
        if(!StringUtils.isEmpty(idcard)){
            wrapper.lambda().eq(Doctor::getIdcard,idcard);
        }
        if(pageNo>0 && pageSize>0){
            IPage<Doctor> doctorIPage = doctorMapper.selectPage(page, wrapper);
            return doctorIPage;
        }
       return null;
    }

    @Override
    public List<Doctor> findAll() {

        return doctorMapper.selectList(null);
    }

    @Override
    public ResponseResult insertDoctor(Doctor doctor) {
        int insert = doctorMapper.insert(doctor);
        //判断
        if(insert>0){//插入成功
            responseResult.setCode(Global.SAVE_CODE_SUCCESS);
            responseResult.setMessage(Global.SAVE_MSG_SUCCESS);
        }else {//插入失败
            responseResult.setCode(Global.SAVE_CODE_ERROR);
            responseResult.setMessage(Global.SAVE_MSG_ERROR);
        }
        return responseResult;
    }

    @Override
    public ResponseResult updateDoctor(Doctor doctor) {
        int i = doctorMapper.updateById(doctor);
        //判断
        if(i>0){//更新成功
            responseResult.setCode(Global.SAVE_CODE_SUCCESS);
            responseResult.setMessage(Global.SAVE_MSG_SUCCESS);
        }else {//更新失败
            responseResult.setCode(Global.SAVE_CODE_ERROR);
            responseResult.setMessage(Global.SAVE_MSG_ERROR);
        }
        return responseResult;
    }

    @Override
    public Doctor findDoctorById(Integer id) {
        return  doctorMapper.selectById(id);
    }

    @Override
    public ResponseResult delDoctor(Integer id) {
        int i = doctorMapper.deleteById(id);
        if(i>0){
            responseResult.setCode(Global.DEL_CODE_SUCCESS);
            responseResult.setMessage(Global.DEL_MSG_SUCCESS);
        }else {
            responseResult.setCode(Global.DEL_CODE_ERROR);
            responseResult.setMessage(Global.DEL_MSG_ERROR);
        }
        return responseResult;
    }

    @Override
    public List<Doctor> getListByDepartment(String department) {

        QueryWrapper<Doctor> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(department)){
            wrapper.lambda().eq(Doctor::getDepartment,department);
            return   doctorMapper.selectList(wrapper);
        }

        return null;
    }
}
