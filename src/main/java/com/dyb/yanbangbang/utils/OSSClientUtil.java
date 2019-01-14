package com.dyb.yanbangbang.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * 阿里云 OSS文件类
 *
 * @author YuanDuDu
 */
public class OSSClientUtil {
    // Endpoint
    private static final String ENDPOINT = "http://oss-cn-shanghai.aliyuncs.com";
    //    private String endpoint = "https://cdn.yanbangbang.com/";
    private static final String ACCESS_KEY_ID = "LTAIPFBZyiPg56hd";
    private static final String ACCESS_KEY_SECRET = "hjiWM0H3LF2Ck9hpcjIMg0rzCejQo9";

    private static final String BUCKET_NAME="yanbangbang-data";


    // Endpoint
//    private static final String ENDPOINT = "oss-cn-hangzhou.aliyuncs.com";
//    //    private String endpoint = "https://cdn.yanbangbang.com/";
//    private static final String ACCESS_KEY_ID = "LTAIIO9ibdk5lT8L";
//    private static final String ACCESS_KEY_SECRET = "rjQebf54TTkGjr0mxZQaJ3CwJlztYg";
//
//    private static final String BUCKET_NAME="qyf-data";

    /**
     * 本地文件上传
     */
    public static String upload(String localUrl,String objectName){
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(BUCKET_NAME, objectName, new File(localUrl));

        // 获取URL
        String url = getUrl(objectName);
        System.out.println("++++++++++++++++++URL: "+ url);

        // 关闭OSSClient。
        ossClient.shutdown();

        return url;
    }


    /**
     * 删除图片 警告：在没有调用其他方法的情况下，请调用closeClient方法
     *
     * @param url URL全路径
     */
    public void deleteImg(String url,String folder) {
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        if (url == null || "".equals(url)) {
            return;
        }
        String[] paths = url.split("[.]");
        /**
         * 文件夹是否存在
         */
        if (!ossClient.doesObjectExist(BUCKET_NAME, folder)) {
            ossClient.putObject(BUCKET_NAME, folder, new ByteArrayInputStream(new byte[0]));
        }
        String[] name = paths[paths.length - 2].split("[/]");
        /**
         * 对象是否存在
         */
        if (ossClient
                .doesObjectExist(BUCKET_NAME, folder + name[name.length - 1] + "." + paths[paths.length - 1])) {
            /**
             * 删除存在对象
             */
            ossClient
                    .deleteObject(BUCKET_NAME, folder + name[name.length - 1] + "." + paths[paths.length - 1]);
        }
        ossClient.shutdown();
    }


    /**
     * 上传文件流
     */
    public static String uploadFile(String objectName, InputStream inputStream) throws FileNotFoundException {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 上传文件流。
        ossClient.putObject(BUCKET_NAME,objectName,inputStream);
        // 关闭OSSClient。
        // 获取URL
        String url = getUrl(objectName);
        System.out.println("++++++++++++++++++URL: "+ url);
        // 关闭OSSClient。
        ossClient.shutdown();
        return url;
    }

    /**
     * 获得url链接
     * @param key
     * @return
     */
    private static String getUrl(String key) {
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(BUCKET_NAME, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    /**
     * 创建存储空间
     * @param bucketName
     */
    public static void createBucket(String bucketName){
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        List<Bucket> buckets = ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(" - " + bucket.getName());
        }

        // 创建存储空间。
//        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }


    public static void del(String objectName){
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        // 删除文件。
        ossClient.deleteObject(BUCKET_NAME, objectName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}