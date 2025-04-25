package com.sxd.login.mapper;

import com.sxd.login.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    Optional<User> findByPhone(String phone);

    int save(User user);
}
