package com.lemonzuo.mapper;

import com.lemonzuo.model.Goods;
import org.springframework.stereotype.Repository;

/**
 * @author LemonZuo
 * @create 2019-09-11 9:12
 */
@Repository
public interface GoodsMapper {
    /**
     * 新增Goods
     * @param goods
     * @return
     */
    Integer addGoods(Goods goods);
}
