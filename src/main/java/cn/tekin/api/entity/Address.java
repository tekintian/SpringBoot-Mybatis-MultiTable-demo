package cn.tekin.api.entity;

import lombok.Data;

//使用 lombok.Data 注释自动set get方法， 减少代码量
@Data
public class Address {
    private Long id;
    private String province;
    private String city;
}
