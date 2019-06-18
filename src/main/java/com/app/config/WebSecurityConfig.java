package com.app.config;

import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Package com.app.config
 * @ClassName WebSecurityConfig
 * @Author shaobin.wang
 * @Date 2019/06/18 17:32
 * @Version 1.0
 * @Description:
 **/
@Configuration
@EnableWebSecurity // 注解开启Spring Security的功能
//WebSecurityConfigurerAdapter:重写它的方法来设置一些web的安全西街
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()  //定义哪些url需要保护，哪些url不需要保护
                .antMatchers("/", "/message/").permitAll()    //定义不需要认证就可以访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")  //定义当需要用户登录时候，转到的登录页面
                .permitAll()
                .and()
                .logout()
                .permitAll();
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(systemUserService());
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
        //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
    }


    /**
     * 从数据库中读取用户信息
     */
    @Bean
    public UserDetailsService systemUserService() {
        return new UserService();
    }

}