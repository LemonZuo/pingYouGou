package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LemonZuo
 * @create 2019-08-10 20:48
 *
 * 品牌信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brand implements Serializable {
    private Long id;
    private String name;
    private String firstChar;
}
