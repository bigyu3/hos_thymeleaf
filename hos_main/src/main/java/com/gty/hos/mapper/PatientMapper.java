package com.gty.hos.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gty.hos.pojo.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gty.hos.vo.QueryVo2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import javax.xml.bind.ValidationEvent;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
@Mapper
public interface PatientMapper extends BaseMapper<Patient> {


    //查询病人关联查询医生(分页)

    //查询病人关联查询医生（分页）
//    void selectList1(Page<Patient> page);
    QueryVo2 selectList2(QueryVo2 queryVo2);

    @Select("select *from hos_refactor.patient ")
    List<Patient> testP();

    List<Patient> findAll();
}
