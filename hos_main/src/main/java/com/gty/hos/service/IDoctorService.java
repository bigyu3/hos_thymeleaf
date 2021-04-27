package com.gty.hos.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gty.hos.pojo.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gty.hos.vo.ResponseResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
public interface IDoctorService extends IService<Doctor> {
    //查医生集合 分页
  IPage<Doctor> findList(Integer pageNo,Integer pageSize,String name,String idcard);
    //查询所有
    List<Doctor> findAll();
    /**
     * 保存 添加
     */
    ResponseResult insertDoctor(Doctor doctor);

    /**
     * 更新记录
     */
    ResponseResult updateDoctor(Doctor doctor);
    /**
     * 根据主键id查询医生
     */
    Doctor findDoctorById(Integer id);
    /**
     * 删除医生
     */
    ResponseResult delDoctor(Integer id);
    /**
     * 根据部门id获取医生
     */
    List<Doctor> getListByDepartment(String department);
    /**
     * 根据userID查询医生
     */
}
