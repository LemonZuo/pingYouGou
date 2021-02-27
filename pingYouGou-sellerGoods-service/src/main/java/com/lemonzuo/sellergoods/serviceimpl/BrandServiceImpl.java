package com.lemonzuo.sellergoods.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lemonzuo.mapper.BrandMapper;
import com.lemonzuo.model.Brand;
import com.lemonzuo.model.PageResult;
import com.lemonzuo.sellergoods.service.BrandService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author LemonZuo
 * @create 2019-08-10 21:34
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    /**
     * 查询全部品牌信息
     *
     * @return
     */
    @Override
    public List<Brand> findAllBrand(Brand brand) {
        return brandMapper.findAllBrand(brand);
    }

    /**
     * 品牌分页
     *
     * @param pageNum  当前页数
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public PageResult<Brand> findBrandPage(int pageNum, int pageSize, Brand brand) {
        PageHelper.startPage(pageNum, pageSize);
        List<Brand> brandList = brandMapper.findAllBrand(brand);
        Page<Brand> page = (Page<Brand>) brandList;
        return new PageResult<Brand>(page.getTotal(), page.getResult());
    }

    /**
     * 新增品牌
     *
     * @param brand
     */
    @Override
    public void addBrand(Brand brand) {
        brandMapper.addBrand(brand);
    }

    /**
     * 检测品牌信息是否已存在
     *
     * @param brandName
     * @return
     */
    @Override
    public Brand checkBrand(String brandName) {
        return brandMapper.checkBrand(brandName);
    }

    /**
     * 修改品牌信息
     *
     * @param brand
     * @return
     */
    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
    }

    /**
     * 根据ID删除品牌
     *
     * @param brandId
     */
    @Override
    public void deleteBrand(Long[] brandId) {
        for (Long id : brandId) {
            brandMapper.deleteBrand(id);
        }
    }

    /**
     * 查询品牌ID、品牌名
     *
     * @return
     */
    @Override
    public List<Map> findIdAndName() {
        return brandMapper.findIdAndName();
    }
}
