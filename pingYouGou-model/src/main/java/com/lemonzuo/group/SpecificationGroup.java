package com.lemonzuo.group;

import com.lemonzuo.model.Specification;
import com.lemonzuo.model.SpecificationOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-08-15 14:54
 *
 * 分类选项组合
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecificationGroup implements Serializable {
    /**
     * 分类信息
     */
    private Specification specification;
    /**
     * 选项集合
     */
    private List<SpecificationOption> specificationOptions;
}
