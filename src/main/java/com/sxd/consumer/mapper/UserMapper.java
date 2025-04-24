package com.sxd.consumer.mapper;

import com.sxd.consumer.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    
    Optional<User> findByPhone(String phone);

    int save(User user);
}
