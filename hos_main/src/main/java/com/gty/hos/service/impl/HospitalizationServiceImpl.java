package com.gty.hos.service.impl;

import com.gty.hos.pojo.Hospitalization;
import com.gty.hos.mapper.HospitalizationMapper;
import com.gty.hos.service.IHospitalizationService;
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
public class HospitalizationServiceImpl extends ServiceImpl<HospitalizationMapper, Hospitalization> implements IHospitalizationService {

}
