package cn.tekin.api.entity;

import lombok.Data;

import java.util.List;

/**
 *
 * 使用lombok.Data 注释自动set get方法， 减少代码量
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String sex;
    private String age;
    //地址有省市，所以需要用一个集合来接收，如果地址值放回一个字段，则可以使用String来接收
    private List<Address> address;
    //用户拥有的车，和用户是一对多的关系
    private List<Car> cars;


}
