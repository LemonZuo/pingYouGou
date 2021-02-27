package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LemonZuo
 * @create 2019-09-09 13:59
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemCat implements Serializable {
    private Long itemCatId;
    private Long parentId;
    private String name;
    private Long typeId;
}
