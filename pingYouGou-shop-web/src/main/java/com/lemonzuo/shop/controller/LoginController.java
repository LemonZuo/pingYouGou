package com.lemonzuo.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2019-08-31 11:26
 * <p>
 * 登录Controller
 */
@RestController
@RequestMapping("/admin")
public class LoginController {
    /**
     * 获取当前登录用户名
     *
     * @param map
     * @return
     */
    @GetMapping("/showLoginName.do")
    public String showLoginName(ModelMap map) {
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        return loginName;
    }
}
