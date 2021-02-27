package com.lemonzuo.sellergoods.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lemonzuo.mapper.TypeTemplateMapper;
import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.TypeTemplate;
import com.lemonzuo.sellergoods.service.TypeTemplateService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-01 17:13
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    /**
     * 查询全部模板信息
     *
     * @return
     */
    @Override
    public PageResult<TypeTemplate> findAllTypeTemplateInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TypeTemplate> typeTemplateList = typeTemplateMapper.findAllTypeTemplateInfo();
        Page<TypeTemplate> page = (Page<TypeTemplate>) typeTemplateList;
        return new PageResult<TypeTemplate>(page.getTotal(), page.getResult());
    }

    /**
     * 新增模板
     *
     * @param typeTemplate
     */
    @Override
    public TypeTemplate addTypeTemplate(TypeTemplate typeTemplate) {
        typeTemplateMapper.addTypeTemplate(typeTemplate);
        return typeTemplate;
    }

    /**
     * 根据ID查询模板信息
     *
     * @param id
     * @return
     */
    @Override
    public TypeTemplate findAllTypeTemplateInfoById(Long id) {
        return typeTemplateMapper.findAllTypeTemplateInfoById(id);
    }

    /**
     * 根据id删除模板
     *
     * @param id
     * @return
     */
    @Override
    public int deleteTemplateById(Long id) {
        return typeTemplateMapper.deleteTemplateById(id);
    }

    /**
     * 查询ID和分类名
     *
     * @return
     */
    @Override
    public List<TypeTemplate> findIdAndName() {

        return typeTemplateMapper.findIdAndName();
    }
}
