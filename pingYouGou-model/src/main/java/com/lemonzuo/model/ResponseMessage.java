package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LemonZuo
 * @create 2019-08-11 16:18
 *
 * 响应消息类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseMessage implements Serializable {
    /**
     * 响应消息状态
     */
    private boolean responseStatus;
    /**
     * 具体响应消息
     */
    private String responseMessageInfo;
}
