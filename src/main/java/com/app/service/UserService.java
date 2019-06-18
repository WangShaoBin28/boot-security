package com.app.service;

import com.app.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;

/**
 * @Package com.app
 * @ClassName UserService
 * @Author shaobin.wang
 * @Date 2019/06/18 18:05
 * @Version 1.0
 * @Description:
 **/
@Slf4j
public class UserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名从数据库查询对应记录
        UserDetails userDetails = null;
        UserEntity userEntity = UserService.queryByUserName(s);
        if (userEntity == null) {
            throw new UsernameNotFoundException("username is not exists");
        }

        userDetails = Optional.ofNullable(userEntity).map(x -> new User(userEntity.getUserName(), userEntity.getPassword(), new HashSet<SimpleGrantedAuthority>())).orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
        System.out.println("username is : " + userEntity.getUserName() + ", password is :" + userEntity.getPassword());

        return userDetails;
    }


    private static UserEntity queryByUserName(String s) {
        if (s.equals("root")) {
            return new UserEntity("123456", "root");
        }

        return null;
    }

}
