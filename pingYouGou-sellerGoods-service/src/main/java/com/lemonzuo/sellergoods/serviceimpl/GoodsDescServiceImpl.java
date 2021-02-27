package com.lemonzuo.sellergoods.serviceimpl;

import com.lemonzuo.mapper.GoodsDescMapper;
import com.lemonzuo.model.GoodsDesc;
import com.lemonzuo.sellergoods.service.GoodsDescService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LemonZuo
 * @create 2019-09-11 15:19
 */
@Service
public class GoodsDescServiceImpl implements GoodsDescService {
    @Autowired
    private GoodsDescMapper goodsDescMapper;
    /**
     * 新增GoodsDesc
     *
     * @param goodsDesc
     * @return
     */
    @Override
    public GoodsDesc addGoodsDesc(GoodsDesc goodsDesc) {
        goodsDescMapper.addGoodsDesc(goodsDesc);
        return goodsDesc;
    }
}
