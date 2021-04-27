package com.gty.hos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gty.hos.pojo.Doctor;
import com.gty.hos.pojo.Patient;
import com.gty.hos.mapper.PatientMapper;
import com.gty.hos.service.IPatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gty.hos.vo.QueryVo;
import com.gty.hos.vo.QueryVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
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
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {

    //注入Mapper
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public IPage<Patient> findList(Integer pageNo, Integer pageSize, String name, String idcard) {
        Page<Patient> page = new Page<>(pageNo,pageSize);
        return  patientMapper.selectPage(page,null);
    }

    @Override
    public QueryVo2 findList2(QueryVo2 queryVo2) {
        QueryVo2 queryVo21 = patientMapper.selectList2(queryVo2);

        return queryVo21;
    }

    @Override
    public List<Patient> testp() {
      return   patientMapper.testP();
    }

    @Override
    public void findAll() {
        patientMapper.findAll();

    }


//    @Override
//    public IPage<Patient> findList(QueryVo queryVo) {
//        Page<Patient> page = new Page<>(queryVo.getPageNo(), queryVo.getPageSize());
////        if (!StringUtils.isEmpty(queryVo.getPatientName())){
////
////        }
////        if(!StringUtils.isEmpty(queryVo.getPatientId())){
////        }
//        patientMapper.selectList1(page);
//        return page;
//
//    }
}
