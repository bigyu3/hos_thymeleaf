package com.gty.hos.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gty.hos.pojo.Patient;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gty.hos.vo.QueryVo;
import com.gty.hos.vo.QueryVo2;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
public interface IPatientService extends IService<Patient> {
        //查询病人关联查询医生(分页)
    //查询病人集合 分页
     IPage<Patient> findList(Integer pageNo,Integer pageSize,String name,String idcard);

    //查询病人集合 分页
//    IPage<Patient> findList(QueryVo queryVo);

    //
    QueryVo2 findList2(QueryVo2 queryVo2);

    //
    List<Patient> testp();

    void findAll();
}
