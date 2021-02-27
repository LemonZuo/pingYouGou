package com.lemonzuo.sellergoods.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lemonzuo.mapper.SpecificationMapper;
import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.Specification;
import com.lemonzuo.sellergoods.service.SpecificationService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author LemonZuo
 * @create 2019-08-14 19:38
 */
@Service
public class SpecificationImpl implements SpecificationService {
    @Autowired
    private SpecificationMapper specificationMapper;
    /**
     * 查询分类
     *
     * @param specification
     * @return
     */
    @Override
    public PageResult<Specification> findSpecification(int pageNum, int pageSize, Specification specification) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Specification> page = (Page<Specification>) specificationMapper.findSpecification(specification);
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    /**
     * 查询分类是否存在
     *
     * @param specification
     * @return
     */
    @Override
    public Specification checkSpecification(Specification specification) {
        return specificationMapper.checkSpecification(specification);
    }

    /**
     * 新增分类
     *
     * @param specification
     */
    @Override
    public Specification addSpecification(Specification specification) {
        specificationMapper.addSpecification(specification);
        // 解决Dubbo 远程调用无法获取到自增ID
        return specification;
    }

    /**
     * 更新分类
     *
     * @param specification
     */
    @Override
    public void updateSpecification(Specification specification) {
        specificationMapper.updateSpecification(specification);
    }

    /**
     * 删除分类
     *
     * @param id
     */
    @Override
    public void deleteSpecification(Long id) {
            specificationMapper.deleteSpecification(id);
    }

    /**
     * 查询一条分类的所有信息
     *
     * @param id
     * @return
     */
    @Override
    public Specification findAllInfo(Long id) {
        return specificationMapper.findAllInfo(id);
    }

    /**
     * 返回JSON分类ID和分类名
     *
     * @return
     */
    @Override
    public List<Map> findSpecificationIdAndName() {
        return specificationMapper.findSpecificationIdAndName();
    }
}
