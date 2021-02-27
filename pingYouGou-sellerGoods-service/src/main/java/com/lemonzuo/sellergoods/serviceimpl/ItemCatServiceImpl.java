package com.lemonzuo.sellergoods.serviceimpl;

import com.lemonzuo.mapper.ItemCatMapper;
import com.lemonzuo.model.ItemCat;
import com.lemonzuo.sellergoods.service.ItemCatService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-09 14:10
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;
    /**
     * 根据上级ID查询分类
     *
     * @param parentId
     * @return
     */
    @Override
    public List<ItemCat> findItemCatByParentId(Long parentId) {
        return itemCatMapper.findItemCatByParentId(parentId);
    }

    /**
     * 新增
     *
     * @param itemCat
     * @return
     */
    @Override
    public ItemCat addItemCat(ItemCat itemCat) {
        itemCatMapper.addItemCat(itemCat);
        return itemCat;
    }

    /**
     * 是否存在
     *
     * @param name
     * @return
     */
    @Override
    public Integer checkItemCatExist(String name) {
        return itemCatMapper.checkItemCatExist(name);
    }

    /**
     * 删除
     *
     * @param itemCatId
     * @return
     */
    @Override
    public Integer deleteItemCatByItemCatId(Long itemCatId) {
        // 查询子分类ID
        List<ItemCat> itemCats = itemCatMapper.findItemCatByParentId(itemCatId);
        if(itemCats.size() == 0) {
            // 不存在子分类
            itemCatMapper.deleteItemCatByItemCatId(itemCatId);
        } else {
            // 存在子分类
            // 1、删除子分类
            for (ItemCat itemCat : itemCats) {
                deleteItemCatByItemCatId(itemCat.getItemCatId());
            }
            // 2、删除自身
            itemCatMapper.deleteItemCatByItemCatId(itemCatId);
        }
        return itemCatMapper.deleteItemCatByItemCatId(itemCatId);
    }

    /**
     * 根据分类ID查询分类信息
     *
     * @param itemCatId
     * @return
     */
    @Override
    public ItemCat findItemCatByItemCatId(Long itemCatId) {
        return itemCatMapper.findItemCatByItemCatId(itemCatId);
    }

    /**
     * 修改分类信息
     *
     * @param itemCat
     * @return
     */
    @Override
    public Integer modifyItemCat(ItemCat itemCat) {
        return itemCatMapper.modifyItemCat(itemCat);
    }
}
