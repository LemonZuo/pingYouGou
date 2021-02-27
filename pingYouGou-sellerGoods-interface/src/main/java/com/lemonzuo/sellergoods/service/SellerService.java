package com.lemonzuo.sellergoods.service;

import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.Seller;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-03 21:39
 */
public interface SellerService {
    /**
     * 新增商家信息
     * @param seller
     * @return
     */
    int addSeller(Seller seller);

    /**
     * 根据商家ID查询商家是否存在
     * @param sellerId
     * @return
     */
    Integer checkIsExist(String sellerId);

    /**
     * 带条件查询商家信息
     * @param seller
     * @return
     */
    PageResult<Seller> findSellerInfo(Seller seller, Integer pageNum, Integer pageSize);

    /**
     * 根据商家ID查询商家详细信息
     * @param sellerId
     * @return
     */
    Seller findSellerDetialInfo(String sellerId);

    /**
     * 更新商家信息
     * @param seller
     * @return
     */
    Integer updateSeller(Seller seller);

    /**
     * 查询商家账号信息
     * @param sellerId
     * @return
     */
    Seller findCountInfo(String sellerId);
}
