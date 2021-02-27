package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LemonZuo
 * @create 2019-09-01 16:55
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TypeTemplate implements Serializable {
    private Long id;
    private String name;
    private String specIds;
    private String brandIds;
    private String customAttributeItems;
}
