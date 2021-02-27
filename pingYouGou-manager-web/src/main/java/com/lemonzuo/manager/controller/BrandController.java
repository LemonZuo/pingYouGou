package com.lemonzuo.manager.controller;

import com.lemonzuo.model.Brand;
import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.ResponseMessage;
import com.lemonzuo.sellergoods.service.BrandService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LemonZuo
 * @create 2019-08-10 21:45
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
   @Reference
    private BrandService brandService;

    /**
     * 查询品牌信息
     *
     * @return
     */

    @GetMapping("/findAllBrand.do")
    public List<Brand> findAllBrand() {
        return brandService.findAllBrand(null);
    }

    /**
     * 品牌列表分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findBrandPage.do")
    public PageResult<Brand> findBrandPage(int pageNum, int pageSize,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String firstChar) {

        Brand brand = new Brand();
        brand.setName(name);
        brand.setFirstChar(firstChar);
        PageResult<Brand> brandPage = brandService.findBrandPage(pageNum, pageSize, brand);
        return brandPage;
    }
    /**
     * 新增品牌
     *
     * @return
     */
    @PostMapping("/addBrand.do")
    public ResponseMessage addBrand(@RequestBody Brand brand) {
        try {
            Brand checkResult = brandService.checkBrand(brand.getName());
            if (checkResult != null) {
                return new ResponseMessage(false, "当前品牌已存在,请勿重复添加");
            } else {
                brandService.addBrand(brand);
                return new ResponseMessage(true, "添加品牌成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "新增品牌失败");
        }
    }

    /**
     * 检测品牌可用
     *
     * @param brandName
     * @return
     */
    @GetMapping("/checkBrand.do")
    public ResponseMessage checkBrand(String brandName) {
        Brand brand = brandService.checkBrand(brandName);
        ResponseMessage responseMessage = new ResponseMessage();
        if (brand != null) {
            responseMessage.setResponseStatus(true);
            responseMessage.setResponseMessageInfo("当前品牌已存在");
        } else {
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("当前品牌可用");
        }
        return responseMessage;
    }

    /**
     * 修改品牌信息
     * @param brand
     * @return
     */
    @PostMapping("/updateBrand.do")
    public ResponseMessage updateBrand(@RequestBody Brand brand) {
        try {
            brandService.updateBrand(brand);
            return new ResponseMessage(true, "修改品牌信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "修改品牌信息失败");
        }
    }

    @GetMapping("/deleteBrand.do")
    public ResponseMessage deleteBrand(Long[] selectIds) {
        try {
            brandService.deleteBrand(selectIds);
            return new ResponseMessage(true, "删除品牌信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "删除品牌信息失败");
        }
    }

    /**
     * 返回JSON格式的品牌ID和品牌名
     * @return
     */
    @GetMapping("/findIdAndName.do")
    public List<Map> findIdAndName() {
        return  brandService.findIdAndName();
    }
}
