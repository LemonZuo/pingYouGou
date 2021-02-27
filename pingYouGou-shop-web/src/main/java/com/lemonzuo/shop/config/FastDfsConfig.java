package com.lemonzuo.shop.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lemonzuo.common.FastDfsUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @author LemonZuo
 * @create 2019-09-23 10:43
 */
@Configuration
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastDfsConfig {
//    @Bean
//    public FastFileStorageClient getStorageClient() {
//        return new DefaultFastFileStorageClient();
//    }

    @Bean
    public FastDfsUtil getFastDfsUtil() {
        return new FastDfsUtil();
    }
}
