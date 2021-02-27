package com.lemonzuo.mapper;

import com.lemonzuo.model.ItemCat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-09 14:03
 */
@Repository
public interface ItemCatMapper {
    /**
     * 根据上级ID查询分类
     * @param parentId
     * @return
     */
    List<ItemCat> findItemCatByParentId(Long parentId);

    /**
     * 新增
     * @param itemCat
     * @return
     */
    Integer addItemCat(ItemCat itemCat);

    /**
     * 是否存在
     * @param name
     * @return
     */
    Integer checkItemCatExist(String name);

    /**
     * 删除
     * @param itemCatId
     * @return
     */
    Integer deleteItemCatByItemCatId(Long itemCatId);

    /**
     * 根据父类ID删除分类
     * @param parentId
     * @return
     */
    Integer deleteItemCatByParentId(Long parentId);

    /**
     * 根据分类ID查询分类信息
     * @param itemCatId
     * @return
     */
    ItemCat findItemCatByItemCatId(Long itemCatId);

    /**
     * 修改分类信息
     * @param itemCat
     * @return
     */
    Integer modifyItemCat(ItemCat itemCat);
}
