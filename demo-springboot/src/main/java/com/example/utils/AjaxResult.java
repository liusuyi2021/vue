package com.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AjaxResult
 * @Description:
 * @Author 刘苏义
 * @Date 2024/1/12 22:17
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult {
    Integer code;
    String msg;
    Object data;

    public static AjaxResult Success(Object data){
        return new AjaxResult(200,"success",data);
    }
    public static AjaxResult Success()
    {
        return new AjaxResult(200,"success","");
    }
    public static AjaxResult Error(Object data)
    {
        return new AjaxResult(500,"error",data);
    }
}
