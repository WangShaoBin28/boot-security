package com.app.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package com.app.entity
 * @ClassName UserEntity
 * @Author shaobin.wang
 * @Date 2019/06/18 18:09
 * @Version 1.0
 * @Description:
 **/
@Data
public class UserEntity implements Serializable {
  private String password;

  private String userName;

    public UserEntity(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
}
