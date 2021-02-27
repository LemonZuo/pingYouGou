package com.lemonzuo.sellergoods.service;

import com.lemonzuo.model.Goods;

/**
 * @author LemonZuo
 * @create 2019-09-11 15:16
 */
public interface GoodsService {
    /**
     * 新增Goods
     * @param goods
     * @return
     */
    Goods addGoods(Goods goods);
}
