package com.lemonzuo.manager.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author LemonZuo
 * @create 2019-08-30 18:53
 * <p>
 * 商家管理后台安全认证配置
 */
@EnableWebSecurity
public class ManagerMebSecurity extends WebSecurityConfigurerAdapter {
    /**
     * 配置授权规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/error/**").permitAll()
                .antMatchers("/plugins/**").permitAll()
                .antMatchers("/*.html").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").hasRole("ADMIN");
        // 开启自动配置登录
        http.formLogin()
                // 配置自定义登录页
                 .loginPage("/login.html")
                 .loginProcessingUrl("/login")
                // 登录成功跳转页面
                 .successForwardUrl("/securityAuthSuccess")
                // 登录失败跳转页面
                // 表单用户名参数
                .usernameParameter("userName")
                // 表单密码参数
                .passwordParameter("userPass");
        // 用户注销
        http.logout().logoutSuccessUrl("/login.html");

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
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("admin"))
                .roles("ADMIN");
    }
}
