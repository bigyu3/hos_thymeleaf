package com.gty.hos.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
public class Medicalhistory implements Serializable {

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
     * 病史名称
     */
    private String name;

    /**
     * 患病时间
     */
    private LocalDate time;

    /**
     * 住院信息
     */
    private Integer hospitalizationId;

    /**
     * 确诊医生
     */
    private Integer doctorId;


}
