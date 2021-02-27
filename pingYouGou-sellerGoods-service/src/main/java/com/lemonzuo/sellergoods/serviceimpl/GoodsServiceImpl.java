package com.lemonzuo.sellergoods.serviceimpl;

import com.lemonzuo.mapper.GoodsMapper;
import com.lemonzuo.model.Goods;
import com.lemonzuo.sellergoods.service.GoodsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LemonZuo
 * @create 2019-09-11 15:17
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    /**
     * 新增Goods
     *
     * @param goods
     * @return
     */
    @Override
    public Goods addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
        return goods;
    }
}
