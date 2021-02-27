package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-08-14 19:16
 *
 * 分类信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Specification implements Serializable {
    private Long id;
    private String specName;
    private List<SpecificationOption> options;
}
