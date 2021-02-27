package com.lemonzuo.sellergoods.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lemonzuo.mapper.SellerMapper;
import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.Seller;
import com.lemonzuo.sellergoods.service.SellerService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-03 21:40
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerMapper sellerMapper;

    /**
     * 新增商家信息
     *
     * @param seller
     * @return
     */
    @Override
    public int addSeller(Seller seller) {
        return sellerMapper.addSeller(seller);
    }

    /**
     * 根据商家ID查询商家是否存在
     *
     * @param sellerId
     * @return
     */
    @Override
    public Integer checkIsExist(String sellerId) {
        return sellerMapper.checkIsExist(sellerId);
    }

    /**
     * 带条件查询商家信息
     *
     * @param seller
     * @return
     */
    @Override
    public PageResult<Seller> findSellerInfo(Seller seller, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Seller> sellerInfo = sellerMapper.findSellerInfo(seller);
        Page<Seller> page = (Page<Seller>) sellerInfo;
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    /**
     * 根据商家ID查询商家详细信息
     *
     * @param sellerId
     * @return
     */
    @Override
    public Seller findSellerDetialInfo(String sellerId) {
        return sellerMapper.findSellerDetialInfo(sellerId);
    }

    /**
     * 更新商家信息
     *
     * @param seller
     * @return
     */
    @Override
    public Integer updateSeller(Seller seller) {
        return sellerMapper.updateSeller(seller);
    }

    /**
     * 查询商家账号信息
     *
     * @param sellerId
     * @return
     */
    @Override
    public Seller findCountInfo(String sellerId) {
        return sellerMapper.findCountInfo(sellerId);
    }
}
