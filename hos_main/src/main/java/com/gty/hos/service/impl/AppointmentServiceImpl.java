package com.gty.hos.service.impl;

import com.gty.hos.pojo.Appointment;
import com.gty.hos.mapper.AppointmentMapper;
import com.gty.hos.service.IAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements IAppointmentService {

}
