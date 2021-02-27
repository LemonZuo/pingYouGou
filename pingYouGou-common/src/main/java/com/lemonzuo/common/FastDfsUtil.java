package com.lemonzuo.common;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LemonZuo
 * @create 2019-09-23 11:18
 */
public class FastDfsUtil {
    private static final String FAST_DFS_PATH_PREFIX = "https://www.lemonzuo.com/";
    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    public String upload(MultipartFile file) {
        String path = null;
        try {
            String fileExtName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            Set<MetaData> metaDataSet = new HashSet<>();
            FastFile fastFile = new FastFile(file.getInputStream(), file.getSize(), fileExtName, metaDataSet);
            StorePath storePath = storageClient.uploadFile(fastFile);
            path = FAST_DFS_PATH_PREFIX + storePath.getFullPath();
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
