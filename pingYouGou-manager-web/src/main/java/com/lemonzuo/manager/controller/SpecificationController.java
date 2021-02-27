package com.lemonzuo.manager.controller;

import com.lemonzuo.group.SpecificationGroup;
import com.lemonzuo.model.Specification;
import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.ResponseMessage;
import com.lemonzuo.model.SpecificationOption;
import com.lemonzuo.sellergoods.service.SpecificationOptionService;
import com.lemonzuo.sellergoods.service.SpecificationService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LemonZuo
 * @create 2019-08-14 19:41
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Reference
    private SpecificationService specificationService;
    @Reference
    private SpecificationOptionService specificationOptionService;

    /**
     * 品牌列表分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findSpecificationPage.do")
    public PageResult<Specification> findSpecificationPage(int pageNum, int pageSize,
                                                           @RequestParam(required = false) String specName) {
        Specification specification = new Specification();
        specification.setSpecName(specName);
        return specificationService.findSpecification(pageNum, pageSize, specification);
    }

    /**
     * 新增分类
     *
     * @return
     */
    @PostMapping("/addSpecification.do")
    public ResponseMessage addSpecification(@RequestBody SpecificationGroup specificationGroup) {
        System.err.println(specificationGroup);
        try {
            // 分类信息
            Specification specification = specificationGroup.getSpecification();
            // 选项信息
            List<SpecificationOption> specificationOptionList = specificationGroup.getSpecificationOptions();
            Specification checkResult = specificationService.checkSpecification(specification);
            if (checkResult != null) {
                return new ResponseMessage(false, "当前分类已存在,请勿重复添加");
            } else {
                // 新增分类
                specification = specificationService.addSpecification(specification);
                // 新增选项
                for (SpecificationOption option : specificationOptionList) {
                    // 获取新插入的分类ID
                    option.setSpecId(specification.getId());
                    specificationOptionService.addSpecificationOption(option);
                }
                return new ResponseMessage(true, "添加分类成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "新增分类失败");
        }
    }

    /**
     * 检测分类可用
     *
     * @param specName
     * @return
     */
    @GetMapping("/checkSpecification.do")
    public ResponseMessage checkSpecification(String specName) {
        Specification buffer = new Specification();
        buffer.setSpecName(specName);
        Specification checkResult = specificationService.checkSpecification(buffer);
        ResponseMessage responseMessage = new ResponseMessage();
        if (checkResult != null) {
            responseMessage.setResponseStatus(true);
            responseMessage.setResponseMessageInfo("当前分类已存在");
        } else {
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("当前分类可用");
        }
        return responseMessage;
    }

    /**
     * 修改分类信息
     *
     * @param specificationGroup
     * @return
     */
    @PostMapping("/updateSpecification.do")
    public ResponseMessage updateSpecification(@RequestBody SpecificationGroup specificationGroup) {
        try {
            // 分类信息
            Specification specification = specificationGroup.getSpecification();
            // 选项信息
            List<SpecificationOption> optionList = specificationGroup.getSpecificationOptions();
            // 删除分类
            specificationService.deleteSpecification(specification.getId());
            // 删除选项
            specificationOptionService.deleteSpecificationOptionBySpecId(specification.getId());
            // 新增分类
            specification = specificationService.addSpecification(specification);
            for (SpecificationOption option : optionList) {
                // 新增的分类ID
                option.setSpecId(specification.getId());
                // 插入选项
                specificationOptionService.addSpecificationOption(option);
            }
            return new ResponseMessage(true, "修改分类信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "修改分类信息失败");
        }
    }

    @GetMapping("/deleteSpecification.do")
    public ResponseMessage deleteSpecification(Long selectIds) {
        try {
            specificationService.deleteSpecification(selectIds);
            specificationOptionService.deleteSpecificationOptionBySpecId(selectIds);
            return new ResponseMessage(true, "删除分类信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "删除分类信息失败");
        }
    }

    @GetMapping("/findAllInfo.do")
    public Specification findAllInfo(Long id) {
        Specification info = specificationService.findAllInfo(id);
        return info;
    }

    @GetMapping("/findSpecificationIdAndName.do")
    public List<Map> findSpecificationIdAndName() {
        return specificationService.findSpecificationIdAndName();
    }
}
