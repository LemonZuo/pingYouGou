package com.lemonzuo.sellergoods.service;

import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.TypeTemplate;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-01 17:11
 */
public interface TypeTemplateService {
    /**
     * 查询全部模板信息
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageResult<TypeTemplate> findAllTypeTemplateInfo(int pageNum, int pageSize);

    /**
     * 新增模板
     * @param typeTemplate
     */
    TypeTemplate addTypeTemplate(TypeTemplate typeTemplate);

    /**
     *查询ID和分类名
     * @return
     */
    List<TypeTemplate> findIdAndName();

    /**
     * 根据ID查询模板信息
     * @param id
     * @return
     */
    TypeTemplate findAllTypeTemplateInfoById(Long id);

    /**
     * 根据id删除模板
     * @param id
     * @return
     */
    int deleteTemplateById(Long id);
}
