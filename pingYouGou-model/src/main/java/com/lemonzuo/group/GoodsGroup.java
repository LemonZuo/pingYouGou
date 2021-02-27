package com.lemonzuo.group;

import com.lemonzuo.model.Goods;
import com.lemonzuo.model.GoodsDesc;
import com.lemonzuo.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-10 23:04
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsGroup implements Serializable {
    private Goods goods;
    private GoodsDesc goodsDesc;
    private List<Item> itemList;
}
