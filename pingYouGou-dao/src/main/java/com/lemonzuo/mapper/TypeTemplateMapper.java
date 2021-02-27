package com.lemonzuo.mapper;

import com.lemonzuo.model.TypeTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-01 17:00
 */
@Repository
public interface TypeTemplateMapper {
    /**
     * 查询全部模板信息
     * @return
     */
    List<TypeTemplate> findAllTypeTemplateInfo();

    /**
     *查询ID和分类名
     * @return
     */
    List<TypeTemplate> findIdAndName();

    /**
     * 新增模板
     * @param typeTemplate
     */
    void addTypeTemplate(TypeTemplate typeTemplate);

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
