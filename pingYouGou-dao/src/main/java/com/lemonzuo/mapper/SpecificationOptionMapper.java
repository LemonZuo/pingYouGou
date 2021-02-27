package com.lemonzuo.mapper;

import com.lemonzuo.model.SpecificationOption;
import org.springframework.stereotype.Repository;

/**
 * @author LemonZuo
 * @create 2019-08-15 14:36
 */
@Repository
public interface SpecificationOptionMapper {
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
