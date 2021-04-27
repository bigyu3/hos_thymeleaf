package com.gty.hos.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author gty
 * @create2021-02-19 9:57
 */
@Data
public class QueryVo2 {
    private Integer id;
    private String name;
    private Integer age;
    private String idcard;
    private Integer gender;
    private String address;
    private Integer hospitalization_id;
    private String drugsids;
    private Integer isout;
    private Integer appointment_id;
    private Integer user_id;
    private String doctorName;
}
