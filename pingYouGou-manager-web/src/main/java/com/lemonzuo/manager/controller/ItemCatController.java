package com.lemonzuo.manager.controller;

import com.lemonzuo.model.ItemCat;
import com.lemonzuo.model.ResponseMessage;
import com.lemonzuo.sellergoods.service.ItemCatService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-09 14:11
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {
    @Reference
    private ItemCatService itemCatService;

    /**
     * 查询分类
     *
     * @param parentId
     * @return
     */
    @GetMapping("/itemCatInfo.do/{parentId}")
    public List<ItemCat> findItemCatByParentId(@PathVariable("parentId") Long parentId) {
        List<ItemCat> itemCats = itemCatService.findItemCatByParentId(parentId);
        return itemCats;
    }

    @PostMapping("/item.do")
    public ResponseMessage addItemCat(@RequestBody ItemCat itemCat, ResponseMessage message) {
        Integer checkResult = itemCatService.checkItemCatExist(itemCat.getName());
        if (checkResult != 0) {
            message.setResponseStatus(false);
            message.setResponseMessageInfo("当前分类已存在");
            return message;
        }
        itemCat = itemCatService.addItemCat(itemCat);
        if (itemCat.getItemCatId() == null) {
            message.setResponseStatus(false);
            message.setResponseMessageInfo("新增失败");
            return message;
        } else {
            message.setResponseMessageInfo("新增成功");
            message.setResponseStatus(true);
            return message;
        }
    }

    @DeleteMapping("/item.do/{itemCatId}")
    public ResponseMessage deleteItemCat(@PathVariable("itemCatId") Long itemCatId, ResponseMessage responseMessage) {
        try {
            itemCatService.deleteItemCatByItemCatId(itemCatId);
            responseMessage.setResponseStatus(true);
            responseMessage.setResponseMessageInfo("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("删除失败");
        } finally {
            return responseMessage;
        }
    }

    @GetMapping("/item.do/{itemCatId}")
    public ItemCat findItemCatByItemCatId(@PathVariable("itemCatId") Long itemCatId) {
        ItemCat itemCat = itemCatService.findItemCatByItemCatId(itemCatId);
        return itemCat;
    }

    /**
     * 修改分类数据
     * @param itemCat
     * @param responseMessage
     * @return
     */
    @PutMapping("/item.do")
    public ResponseMessage modifyItemCat(@RequestBody ItemCat itemCat, ResponseMessage responseMessage) {
        Integer modifyResult = itemCatService.modifyItemCat(itemCat);
        if(modifyResult != 1) {
            // 修改失败
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("修改失败");
            return responseMessage;
        } else {
            responseMessage.setResponseStatus(true);
            responseMessage.setResponseMessageInfo("修改成功");
            return responseMessage;
        }
    }
}
