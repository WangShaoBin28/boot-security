package com.app.service;

import com.app.entity.UserEntity;
import com.app.entity.UserInfo;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Author shaobin.wang
 * @Date 2019/06/19 10:11
 * @Version 1.0
 * @Description:
 **/
public interface UserInfoService {


    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserInfo record);

    UserInfo queryByUserName(String userName);
}
