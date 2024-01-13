package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName School
 * @Description:
 * @Author 刘苏义
 * @Date 2024/1/13 21:21
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private  Long id;
    private  String name;
    private  Long parentId;
    @JsonProperty(value = "isParent")
    private boolean isParent;
}
