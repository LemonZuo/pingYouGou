package com.lemonzuo.shop.controller;

import com.lemonzuo.group.GoodsGroup;
import com.lemonzuo.model.Goods;
import com.lemonzuo.model.GoodsDesc;
import com.lemonzuo.model.ResponseMessage;
import com.lemonzuo.sellergoods.service.GoodsDescService;
import com.lemonzuo.sellergoods.service.GoodsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author LemonZuo
 * @create 2019-09-18 9:56
 */
@RestController
@RequestMapping("/shopGoods")
public class GoodsController {
    @Reference
    private GoodsService goodsService;
    @Reference
    private GoodsDescService goodsDescService;

    /**
     * 新增商品信息
     *
     * @param goodsGroup
     * @param responseMessage
     * @return
     */
    @PostMapping("/goods.do")
    public ResponseMessage addGoods(@RequestBody GoodsGroup goodsGroup, ResponseMessage responseMessage) {
        try {
            // 获取登录商家Id
            String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
            // 商品基本信息
            Goods goods = goodsGroup.getGoods();
            goods.setSellerId(sellerId);
            goods = goodsService.addGoods(goods);
            // 商品描述信息
            GoodsDesc goodsDesc = goodsGroup.getGoodsDesc();
            // 新增的商品ID
            goodsDesc.setGoodsId(goods.getGoodsId());
            goodsDescService.addGoodsDesc(goodsDesc);
            responseMessage.setResponseMessageInfo("新增成功");
            responseMessage.setResponseStatus(true);
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage.setResponseMessageInfo("新增失败");
            responseMessage.setResponseStatus(false);
            return responseMessage;
        }
    }
}
