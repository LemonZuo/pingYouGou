package com.lemonzuo.shop.security;

import com.lemonzuo.model.Seller;
import com.lemonzuo.sellergoods.service.SellerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-06 16:27
 * <p>
 * 自定义用户认证
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Reference
    private SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String allowStatus = "1";

        // 查询商家账号信息
        Seller countInfo = sellerService.findCountInfo(username);
        if (countInfo != null && allowStatus.equals(allowStatus)) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_SHOP");
            authorities.add(authority);
            User user = new User(countInfo.getSellerId(), countInfo.getPassword(), authorities);
            return user;
        } else {
            return null;
        }
    }
}
