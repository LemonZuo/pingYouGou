package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-08-11 14:23
 * 分页结果类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResult<T> implements Serializable {
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 当前页记录
     */
    private List<T> rows;
}
