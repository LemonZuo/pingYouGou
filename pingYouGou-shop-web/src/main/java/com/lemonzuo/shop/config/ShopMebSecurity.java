package com.lemonzuo.shop.config;

import com.lemonzuo.shop.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author LemonZuo
 * @create 2019-08-30 18:53
 * <p>
 * 商家管理后台安全认证配置
 */
@EnableWebSecurity
public class ShopMebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;
    /**
     * 配置授权规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 放行与拦截规则
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/error/**").permitAll()
                .antMatchers("/plugins/**").permitAll()
                .antMatchers("/*.html").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/seller/addSeller.do").permitAll()
                .antMatchers("/**").hasRole("SHOP");

        // 开启自动配置登录
        http.formLogin()
                // 配置自定义登录页
                 .loginPage("/shoplogin.html")
                 .loginProcessingUrl("/login")
                // 登录成功跳转页面
                 .successForwardUrl("/securityAuthSuccess")
                // 登录失败跳转页面
                // 表单用户名参数
                .usernameParameter("userName")
                // 表单密码参数
                .passwordParameter("userPass");

        // 记住我
        http.rememberMe()
                .rememberMeParameter("rememberMe");
        // 用户注销
        http.logout().logoutSuccessUrl("/shoplogin.html");

        http
            .csrf().disable().headers()
            .frameOptions().sameOrigin();
    }

    /**
     * 自定义认证规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
}
