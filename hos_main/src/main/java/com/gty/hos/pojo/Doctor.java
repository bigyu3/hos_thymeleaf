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
public class Doctor implements Serializable {

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
     * 部门
     */
    private String department;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 登陆
     */
    private Integer userId;

    /**
     * 介绍
     */
    private String text;

    /**
     * 专家
     */
    private Integer expert;


}
