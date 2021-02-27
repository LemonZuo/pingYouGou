package com.lemonzuo.sellergoods.service;

import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.Specification;

import java.util.List;
import java.util.Map;

/**
 * @author LemonZuo
 * @create 2019-08-14 19:37
 */
public interface SpecificationService {
    /**
     * 查询分类
     * @param specification
     * @return
     */
    PageResult<Specification> findSpecification(int pageNum, int pageSize, Specification specification);

    /**
     * 查询分类是否存在
     * @param specification
     * @return
     */
    Specification checkSpecification(Specification specification);
    /**
     * 新增分类
     * @param specification
     * @return
     */
    Specification addSpecification(Specification specification);

    /**
     * 更新分类
     * @param specification
     */
    void updateSpecification(Specification specification);

    /**
     * 删除分类
     * @param id
     */
    void deleteSpecification(Long id);

    /**
     * 查询一条分类的所有信息
     * @param id
     * @return
     */
    Specification findAllInfo(Long id);

    /**
     * 返回JSON分类ID和分类名
     * @return
     */
    List<Map> findSpecificationIdAndName();
}
