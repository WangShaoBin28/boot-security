package com.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @Package com.app.controller
 * @ClassName TestEndpoints
 * @Author shaobin.wang
 * @Date 2019/06/18 16:59
 * @Version 1.0
 * @Description:
 **/
@Controller
@Slf4j
public class TestEndpoints {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        //for debug
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
        return "order id : " + id;
    }


    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Model model,HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getAttributeNames();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("我的数据为{}",  authentication.getDetails());

        model.addAttribute("user", authentication.getDetails());
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
