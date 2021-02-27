package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LemonZuo
 * @create 2019-09-10 22:56
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item implements Serializable {
    private Long itemId;
    private String title;
    private String sellPoint;
    private BigDecimal price;
    private Integer stockCount;
    private Integer num;
    private String barcode;
    private String image;
    private Long categoryId;
    private String status;
    private Date createTime;
    private Date updateTime;
    private String itemSn;
    private BigDecimal  costPrice;
    private BigDecimal marketPrice;
    private String isDefault;
    private Long goodsId;
    private String sellerId;
    private String cartThumbnail;
    private String category;
    private String brand;
    private String spec;
    private String seller;
}
