package com.app.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.app.entity.UserInfo;
import com.app.dao.UserInfoMapper;
import com.app.service.UserInfoService;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Author shaobin.wang
 * @Date 2019/06/19 10:11
 * @Version 1.0
 * @Description:
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserInfo queryByUserName(String userName) {
        //根据用户名查询用户
        UserInfo userInfo = userInfoMapper.selectByUserName(userName);
        return userInfo;
    }

}
