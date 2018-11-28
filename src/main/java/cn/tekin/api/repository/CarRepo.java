package cn.tekin.api.repository;

import cn.tekin.api.entity.Car;
import org.apache.ibatis.annotations.Select;

public interface CarRepo {
    @Select("select * from my_car where user_id=#{id}")
    Car findCarsByUserId(Long id);
}
