package com.lemonzuo.mapper;

import com.lemonzuo.model.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author LemonZuo
 * @create 2019-08-10 20:44
 */
@Repository
public interface BrandMapper {
    /**
     * 带条件查询品牌
     * @param brand 查询条件
     * @return
     */
    List<Brand> findAllBrand(Brand brand);

    /**
     * 新增品牌
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 检测品牌信息是否已存在
     * @param brandName
     * @return
     */
    Brand checkBrand(String brandName);

    /**
     * 修改品牌信息
     * @param brand
     * @return
     */
    void updateBrand(Brand brand);

    /**
     * 根据ID删除品牌
     * @param brandId
     */
    void deleteBrand(Long brandId);

    /**
     * 查询品牌ID、品牌名
     * @return
     */
    List<Map> findIdAndName();
}
