package com.sxd.login.model.entity;

import lombok.Data;

/**
 * 测试全量/增量同步及索引性能的表实体
 */
@Data
public class User {

    private Long id;

    private String phone;

    private String password;

}
