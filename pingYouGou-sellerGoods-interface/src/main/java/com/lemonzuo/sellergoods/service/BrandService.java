package com.lemonzuo.sellergoods.service;

import com.lemonzuo.model.Brand;
import com.lemonzuo.model.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @author LemonZuo
 * @create 2019-08-10 20:47
 * <p>
 * 品牌服务接口
 */
public interface BrandService {
    /**
     * 带条件查询品牌
     * @param brand 查询条件
     * @return
     */
    List<Brand> findAllBrand(Brand brand);

    /**
     * 品牌分页
     *
     * @param pageNum  当前页数
     * @param pageSize 每页记录数
     * @param brand 品牌
     * @return
     */
    PageResult<Brand> findBrandPage(int pageNum, int pageSize, Brand brand);

    /**
     * 新增品牌
     *
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 检测品牌信息是否已存在
     *
     * @param brandName
     * @return
     */
    Brand checkBrand(String brandName);

    /**
     * 修改品牌信息
     *
     * @param brand
     * @return
     */
    void updateBrand(Brand brand);

    /**
     * 根据ID删除品牌
     *
     * @param brandId
     */
    void deleteBrand(Long[] brandId);

    /**
     * 查询品牌ID、品牌名
     * @return
     */
    List<Map> findIdAndName();
}
