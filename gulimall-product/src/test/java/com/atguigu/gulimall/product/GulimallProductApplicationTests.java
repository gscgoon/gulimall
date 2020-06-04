package com.atguigu.gulimall.product;


import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;
//    @Test
//    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setDescript("111");
//        brandService.save(brandEntity);
//        System.out.println("success");
//    }
    @Test
    public void testOss() throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//        String accessKeyId = "LTAI4FzNqW8iZ214ks2P7LiU";
//        String accessKeySecret = "MO8JCklkeF0ewgxlylHWdVDOvot0dn";
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        // 上传文件流。
//        InputStream inputStream = new FileInputStream("D:\\timg.jpg");
//        ossClient.putObject("gulixueyuan-super", "timg.jpg", inputStream);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//        System.out.println("已完成上传......");
    }



}
