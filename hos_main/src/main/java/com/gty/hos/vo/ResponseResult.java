package com.gty.hos.vo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author gty
 * @create2021-01-24 20:24
 */

@Scope("prototype")//设置为多例
@Component
@Data
public class ResponseResult {
    private String code;
    private String message;
    private String data;

    public ResponseResult(){

    }

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
