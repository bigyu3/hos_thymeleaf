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
public class Hospitalization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 楼层
     */
    private String floor;

    /**
     * 床号
     */
    private String bed;

    /**
     * 房间号
     */
    private String door;

    /**
     * 病名
     */
    private String diseaseName;

    /**
     * 患者id
     */
    private Integer patientId;

    /**
     * 住院日期
     */
    private LocalDate intime;

    /**
     * 出院时间
     */
    private LocalDate outtime;


}
