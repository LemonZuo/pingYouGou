package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LemonZuo
 * @create 2019-09-10 22:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GoodsDesc implements Serializable {
    private Long goodsId;
    private String introduction;
    private String specificationItems;
    private String customAttributeItems;
    private String itemImages;
    private String packageList;
    private String saleService;
}
