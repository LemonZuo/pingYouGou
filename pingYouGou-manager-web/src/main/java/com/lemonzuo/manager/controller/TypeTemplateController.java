package com.lemonzuo.manager.controller;

import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.ResponseMessage;
import com.lemonzuo.model.TypeTemplate;
import com.lemonzuo.sellergoods.service.TypeTemplateService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-01 17:19
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 模板列表分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/typeTemplateInfo.do")
    public PageResult<TypeTemplate> findAllTypeTemplateInfo(int pageNum, int pageSize) {
        return typeTemplateService.findAllTypeTemplateInfo(pageNum, pageSize);
    }

    @GetMapping("/findIdAndName.do")
    public List<TypeTemplate> findIdAndName() {
        return typeTemplateService.findIdAndName();
    }
    /**
     * 新增模板
     *
     * @param typeTemplate
     * @return
     */
    @PostMapping("/addTypeTemplate.do")
    public ResponseMessage addTypeTemplate(@RequestBody TypeTemplate typeTemplate) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 执行新增模板
        typeTemplate = typeTemplateService.addTypeTemplate(typeTemplate);
        if (ObjectUtils.isEmpty(typeTemplate.getId())) {
            // 插入失败
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("插入失败");
        } else {
            // 插入成功
            responseMessage.setResponseStatus(true);
            responseMessage.setResponseMessageInfo("新增模板成功");
        }
        return responseMessage;
    }

    /**
     * 根据ID查询模板信息
     *
     * @param id
     * @return
     */
    @GetMapping("/findAllTypeTemplateInfoById.do")
    public TypeTemplate findAllTypeTemplateInfoById(Long id) {
        TypeTemplate typeTemplate = typeTemplateService.findAllTypeTemplateInfoById(id);
        return typeTemplate;
    }

    /**
     * 根据id删除模板
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteTemplateById.do")
    public ResponseMessage deleteTemplateById(Long id, ResponseMessage responseMessage) {
        int res = typeTemplateService.deleteTemplateById(id);
        if (res == 1) {
            responseMessage.setResponseStatus(true);
            responseMessage.setResponseMessageInfo("模板删除成功");
        } else {
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("模板删除失败");
        }
        return responseMessage;
    }

    @PostMapping("/modifyTypeTemplate.do")
    public ResponseMessage modifyTemplate(@RequestBody TypeTemplate typeTemplate, ResponseMessage responseMessage) {
        // 1、检测模板是否存在
        if (ObjectUtils.isEmpty(typeTemplate.getId())) {
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("参数不完整");
            return responseMessage;
        }
        TypeTemplate checkResult = typeTemplateService.findAllTypeTemplateInfoById(typeTemplate.getId());
        if (ObjectUtils.isEmpty(checkResult)) {
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("模板不存在");
            return responseMessage;
        }
        // 删除模板
        int delResult = typeTemplateService.deleteTemplateById(typeTemplate.getId());
        if (delResult == 0) {
            // 删除失败
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("模板删除失败");
            return responseMessage;
        }
        // 添加模板
        typeTemplate.setId(null);
        typeTemplate = typeTemplateService.addTypeTemplate(typeTemplate);
        if (ObjectUtils.isEmpty(typeTemplate.getId())) {
            // 插入失败
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("修改模板失败");
            return responseMessage;
        } else {
            responseMessage.setResponseStatus(true);
            responseMessage.setResponseMessageInfo("修改模板成功");
        }
        return responseMessage;
    }

}
