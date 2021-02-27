package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LemonZuo
 * @create 2019-08-15 14:32
 * <p>
 * 规格选项
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecificationOption implements Serializable {
    private Long optionId;
    private String optionName;
    /**
     * 分类Id
     */
    private Long specId;
    private Integer orders;

}
