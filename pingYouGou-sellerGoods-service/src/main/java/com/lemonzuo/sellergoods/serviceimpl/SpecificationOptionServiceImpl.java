package com.lemonzuo.sellergoods.serviceimpl;

import com.lemonzuo.mapper.SpecificationOptionMapper;
import com.lemonzuo.model.SpecificationOption;
import com.lemonzuo.sellergoods.service.SpecificationOptionService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-08-15 14:48
 *
 * 规格选项服务实现
 */
@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {
    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;
    /**
     * 新增单一规格选项
     *
     * @param specificationOption
     */
    @Override
    public void addSpecificationOption(SpecificationOption specificationOption) {
        specificationOptionMapper.addSpecificationOption(specificationOption);
    }

    /**
     * 新增规格选项
     *
     * @param specificationOptionList
     */
    public void addSpecificationOption(List<SpecificationOption> specificationOptionList) {
        for (SpecificationOption option : specificationOptionList) {
            specificationOptionMapper.addSpecificationOption(option);
        }
    }

    /**
     * 根据分类ID删除选项信息
     *
     * @param id
     */
    @Override
    public void deleteSpecificationOptionBySpecId(Long id) {
        specificationOptionMapper.deleteSpecificationOptionBySpecId(id);
    }
}
