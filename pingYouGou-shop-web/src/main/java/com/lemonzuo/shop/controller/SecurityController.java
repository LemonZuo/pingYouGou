package com.lemonzuo.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LemonZuo
 * @create 2019-08-30 22:25
 */
@Controller
public class SecurityController {
    @RequestMapping(value = "/securityAuthSuccess")
    public String redirectToIndex() {
        return "redirect:/admin/index.html";
    }

    @RequestMapping(value = "/securityAuthFailure")
    public String securityAuthFailure() {
        return "redirect:/shoplogin.html";
    }
}
