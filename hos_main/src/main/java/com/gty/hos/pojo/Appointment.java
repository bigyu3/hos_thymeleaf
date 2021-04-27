package com.gty.hos.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 患者id
     */
    private Integer patientId;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 预约时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate time;

    /**
     * 门诊费用
     */
    private BigDecimal expenses;

    /**
     * 就诊状态
     */
    private String status;


}
