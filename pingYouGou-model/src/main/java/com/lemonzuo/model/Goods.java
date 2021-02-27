package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author LemonZuo
 * @create 2019-09-10 22:40
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Goods implements Serializable {
    private Long goodsId;
    private String sellerId;
    private String goodsName;
    private Long defaultItemId;
    private String auditStatus;
    private String isMarketable;
    private Long brandId;
    private String caption;
    private String smallPic;
    private BigDecimal price;
    private Long typeTemplateId;
    private String isEnableSpec;
    private String isDelete;
    private Long itemCatId;
    private Long secondItemCatId;
    private Long thirdItemCatId;
}
