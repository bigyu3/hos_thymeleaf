package com.gty.hos.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Seek implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 描述
     */
    private String describes;

    /**
     * 病名
     */
    private String illname;

    /**
     * 药
     */
    private String drugs;

    /**
     * 选项
     */
    private String options;

    /**
     * 天数
     */
    private String days;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 病人id
     */
    private Integer patientId;

    /**
     * 预约id
     */
    private Integer appointmentId;


}
