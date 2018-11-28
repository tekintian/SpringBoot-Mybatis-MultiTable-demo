package cn.tekin.api.repository;

import cn.tekin.api.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserRepo {

    /**
     * @Result(property = "address",column = "address_id"
     * property表示的是实体类中定义的属性的名称， column 表示的是数据库表查询后的返回字段 as 后面的字段
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM `my_user` WHERE id=#{id}")
    @Results({
            @Result(property = "address",column = "address_id", one = @One(select = "cn.tekin.api.repository.AddressRepo.findAddressById"))
    })
    User findUserWithAddress(Long id);


    /**
     *
     * @param id
     * @return
     */
    @Select("select * from `my_user` where id=#{id}")
    @Results({
            @Result(property = "cars", column = "id",many = @Many(select = "cn.tekin.api.repository.CarRepo.findCarsByUserId"))
    })
    User findUserWithCars(Long id);

    /**
     * 获取所有用户信息
     * @return
     */
    @Select("select * from my_user")
    @Results({
            @Result(property = "address", column = "address_id", one = @One(select = "cn.tekin.api.repository" +
                    ".AddressRepo.findAddressById")),
            @Result(property = "cars", column = "id",many = @Many(select = "cn.tekin.api.repository.CarRepo.findCarsByUserId"))
    })
    List<User> findAll();
}
