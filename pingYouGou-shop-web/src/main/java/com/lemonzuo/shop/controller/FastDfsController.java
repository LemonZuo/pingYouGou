package com.lemonzuo.shop.controller;

import com.lemonzuo.common.FastDfsUtil;
import com.lemonzuo.model.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author LemonZuo
 * @create 2019-09-23 14:23
 */
@RestController
@RequestMapping("/goodsFile")
public class FastDfsController {
    @Autowired
    private FastDfsUtil fastDfsUtil;

    @PostMapping("/file.do")
    public ResponseMessage uploadFile(MultipartFile file, ResponseMessage message) {
        try {
            String fileUrl = fastDfsUtil.upload(file);
            message.setResponseStatus(true);
            message.setResponseMessageInfo(fileUrl);
            System.out.println(fileUrl);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            message.setResponseStatus(false);
            message.setResponseMessageInfo("上传失败");
            return message;
        }
    }
}
