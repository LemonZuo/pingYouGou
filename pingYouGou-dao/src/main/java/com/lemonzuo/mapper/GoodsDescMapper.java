package com.lemonzuo.mapper;

import com.lemonzuo.model.GoodsDesc;
import org.springframework.stereotype.Repository;

/**
 * @author LemonZuo
 * @create 2019-09-11 9:25
 */
@Repository
public interface GoodsDescMapper {
    /**
     * 新增GoodsDesc
     * @param goodsDesc
     * @return
     */
    Integer addGoodsDesc(GoodsDesc goodsDesc);
}
