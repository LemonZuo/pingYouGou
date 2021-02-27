package com.lemonzuo.sellergoods.service;

import com.lemonzuo.model.SpecificationOption;

/**
 * @author LemonZuo
 * @create 2019-08-15 14:47
 */
public interface SpecificationOptionService {
    /**
     * 新增规格选项
     * @param specificationOption
     */
    void addSpecificationOption(SpecificationOption specificationOption);

    /**
     * 根据分类ID删除选项信息
     * @param id
     */
    void deleteSpecificationOptionBySpecId(Long id);
}
