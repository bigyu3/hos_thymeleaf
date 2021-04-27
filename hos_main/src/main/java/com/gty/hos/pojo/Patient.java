package com.gty.hos.pojo;

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
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身份证
     */
    private String idcard;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 住院表id号
     */
    private Integer hospitalizationId;

    /**
     * 药品信息
     */
    private String drugsids;

    /**
     * 是否出院
     */
    private Integer isout;

    /**
     * 预约信息
     */
    private Integer appointmentId;

    /**
     * 登陆id
     */
    private Integer userId;

    //映射医生的名称
//    private String doctorName ;
}
