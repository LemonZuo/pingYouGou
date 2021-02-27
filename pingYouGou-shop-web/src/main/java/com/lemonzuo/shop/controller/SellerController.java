package com.lemonzuo.shop.controller;

import com.lemonzuo.model.ResponseMessage;
import com.lemonzuo.model.Seller;
import com.lemonzuo.sellergoods.service.SellerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2019-09-03 17:04
 */
@RestController
@RequestMapping("/seller")
public class SellerController {
    @Reference
    private SellerService sellerService;

    /**
     * 商家申请入驻
     * @param responseMessage
     * @param seller
     * @return
     */
    @PostMapping("/addSeller.do")
    public ResponseMessage addSeller(ResponseMessage responseMessage, @RequestBody Seller seller) {
        // 1、检测是否存在该商家
        Integer checkIsExist = sellerService.checkIsExist(seller.getSellerId());
        if (ObjectUtils.isEmpty(checkIsExist)) {
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("商家已存在");
            return responseMessage;
        }
        // 新增商家
        seller.setStatus("0");
        // 密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(seller.getPassword());
        seller.setPassword(password);
        int addRes = sellerService.addSeller(seller);
        if(addRes != 1) {
            // 新增失败
            responseMessage.setResponseMessageInfo("申请入驻失败");
            responseMessage.setResponseStatus(false);
            return responseMessage;
        } else {
            // 新增成功
            responseMessage.setResponseStatus(true);
            responseMessage.setResponseMessageInfo("申请入驻成功,请耐心等待");
            return responseMessage;
        }
    }
}
