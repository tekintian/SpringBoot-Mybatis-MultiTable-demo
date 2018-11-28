package cn.tekin.api.repository;

import cn.tekin.api.entity.Address;
import org.apache.ibatis.annotations.Select;

public interface AddressRepo {
    @Select("SELECT * FROM my_address WHERE id=#{id}")
    Address findAddressById(Long id);
}
