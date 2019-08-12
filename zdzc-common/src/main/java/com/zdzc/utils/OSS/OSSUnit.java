package com.zdzc.utils.OSS;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description :  oss图片上传
 * author  : 李琳青
 * date   : 2019-08-12 10:53
 * version :1.0.0
 */

@Slf4j
public class OSSUnit {


  /*  *//**
     * 阿里云API的内或外网域名
     *//*
    private static String END_POINT ="oss-cn-hangzhou.aliyuncs.com"; //自己
    *//**
     * 阿里云API的密钥Access Key ID
     *//*
    private static String ACCESS_KEY_ID ="LTAIxEBSvkdYKxr3"; //参数2：
    *//**
     * 阿里云API的密钥Access Key Secret
     *//*
    private static String ACCESS_KEY_SECRET ="HOpjNl70GxnRhbzlhRuoIuyQQlELze"; //参数3:
    *//**
     * 阿里云存储空间名称
     *//*
    private static String bucketName ="linqing13253515512";  //参数4:
    *//**
     *客户端
     *//*
    private static OSSClient ossClient ;

    *//**
     * 路径
     *//*
    //private static String OSS_DOMAIN ="linqing13253515512.oss-cn-hangzhou.aliyuncs.com";  //参数5:
    private static String OSS_DOMAIN ="zdzc";  //参数5:*/



    private static String END_POINT ="http://oss-cn-hangzhou.aliyuncs.com"; //自己
    private static String ACCESS_KEY_ID ="LTAIZHmIxWMQzrid"; //参数2：
    private static String ACCESS_KEY_SECRET ="9yqahbCszp2UI8uZrAK8D5UxZkdl7L"; //参数3:
    private static String bucketName ="zdzc-ddc";  //参数4:
    private static String OSS_DOMAIN ="http://zdzc-ddc.oss-cn-hangzhou.aliyuncs.com";  //参数5:
    private static OSSClient ossClient ;



    static {
        //IArcSysConfigService iArcSysConfigService = SpringContextUtils.getBean(IArcSysConfigService.class);

       /* END_POINT = iArcSysConfigService.getSysConfigValue("oss_endpoint");
        ACCESS_KEY_ID = iArcSysConfigService.getSysConfigValue("oss_accesskeyid");
        ACCESS_KEY_SECRET = iArcSysConfigService.getSysConfigValue("oss_accesskeysecret");
        bucketName = iArcSysConfigService.getSysConfigValue("oss_bucketname");
        OSS_DOMAIN = iArcSysConfigService.getSysConfigValue("oss_domain");*/
        CredentialsProvider provider = new DefaultCredentialProvider(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ClientConfiguration config = new ClientConfiguration();
        config.setConnectionRequestTimeout(50 * 1000);
        config.setMaxErrorRetry(0);
        ////允许打开的最大HTTP连接数。默认为1024
        config.setMaxConnections(1024);
        ////Socket层传输数据的超时时间（单位：毫秒）。默认为50000毫秒
        config.setSocketTimeout(100 * 1000);
        config.setIdleConnectionTime(3 * 1000);
        ossClient = new OSSClient(END_POINT, provider, config);
    }
    /**
     * @return String 图片url访问地址
     */
    public static String uploadObject2OSS(InputStream instream, String fileDir, String fileName, long fileSize) {
        String resultStr = null;
        try {
            //存储文件父文件夹
            String filedir = "llq/";
            filedir = filedir + fileDir + "/";
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(instream.available());
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(getContentType(fileName));
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            //上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, metadata);
            //解析结果
            resultStr = putResult.getETag();
            if (!resultStr.isEmpty() && resultStr != null) {
                resultStr = OSS_DOMAIN + "/" + filedir + fileName;
            }
            return resultStr;
        } catch (OSSException oe) {
            oe.printStackTrace();
            log.info("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.info("Error Message: " + oe.getErrorCode());
            log.info("Error Code:       " + oe.getErrorCode());
            log.info("Request ID:      " + oe.getRequestId());
            log.info("Host ID:           " + oe.getHostId());
            return resultStr;
        } catch (ClientException ce) {
            ce.printStackTrace();
            log.info("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.info("Error Message: " + ce.getMessage());
            return resultStr;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
            return resultStr;
        } finally {
            if (instream != null) {
                try {
                    instream.close();
                } catch (IOException e) {
                    log.info("关闭输入流失败");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 新建Bucket  --Bucket权限:私有
     *
     * @param bucketName bucket名称
     * @return true 新建Bucket成功
     */
    public final boolean createBucket(OSSClient client, String bucketName) {
        Bucket bucket = client.createBucket(bucketName);
        return bucketName.equals(bucket.getName());
    }

    /**
     * 删除Bucket
     *
     * @param bucketName bucket名称
     */
    public final void deleteBucket(OSSClient client, String bucketName) {
        client.deleteBucket(bucketName);
        log.info("删除" + bucketName + "Bucket成功");
    }

    /**
     * 根据key获取OSS服务器上的文件输入流
     *
     * @param client     OSS客户端
     * @param bucketName bucket名称
     * @param diskName   文件路径
     * @param key        Bucket下的文件的路径名+文件名
     */
    public final InputStream getOSS2InputStream(OSSClient client, String bucketName, String diskName, String key) {
        OSSObject ossObj = client.getObject(bucketName, diskName + key);
        return ossObj.getObjectContent();
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param client     OSS客户端
     * @param bucketName bucket名称
     * @param diskName   文件路径
     * @param key        Bucket下的文件的路径名+文件名
     */
    public void deleteFile(OSSClient client, String bucketName, String diskName, String key) {
        client.deleteObject(bucketName, diskName + key);
        log.info("删除" + bucketName + "下的文件" + diskName + key + "成功");
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if ("bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if ("gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if ("jpeg".equalsIgnoreCase(fileExtension) || "jpg".equalsIgnoreCase(fileExtension) || "png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if ("html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if ("txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if ("vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if ("ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if ("doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if ("xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if ("pdf".equalsIgnoreCase(fileExtension)){
            return "application/pdf";
        }
        return "text/html";

    }

    /**
     * 获得图片路径
     *
     * @param
     */
    public String getImgUrl(String fileName) {
        String filedir = "";
        if (fileName != null && fileName.length() > 0) {
            return getUrl(filedir + fileName);
        }
        return null;

    }

    /**
     * 获得url链接
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }


    //MultipartFile imageFile = image.getFile();


    /**
     * @author: llq
     */
    public static StringBuffer getImgUrl(MultipartFile img, String imgName, String fileDir) throws IOException {

        StringBuffer imgUrl = new StringBuffer();
            InputStream imgIo = img.getInputStream();
            String imgFileName2 = imgName + "_"+ System.currentTimeMillis()+".png";
        System.out.println("kkk："+imgFileName2);
            String url = OSSUnit.uploadObject2OSS(imgIo, fileDir, imgFileName2, img.getSize());
        System.out.println("url："+url);
            imgUrl.append(url);
        return imgUrl;
    }



    /**
     * @author: zhoujiong
     * @description: 多张图片上传OSS,路径用;拼接
     * @date: 2018/11/8 18:45
     * @param: [imgs, name, fileDir, imgUrl]
     * @return: java.lang.StringBuffer
     */
    public static StringBuffer getDBImgUrl(MultipartFile[] imgs, String imgName, String fileDir) throws IOException {

        StringBuffer imgUrl = new StringBuffer();
        for (MultipartFile img : imgs) {
            InputStream imgIo = img.getInputStream();
            String imgFileName2 = imgName + "_"+ System.currentTimeMillis()+".png";
            String url = OSSUnit.uploadObject2OSS(imgIo, fileDir, imgFileName2, img.getSize());
            imgUrl.append(url+";");
        }
        return imgUrl;
    }

    /**
     * @author: zhoujiong
     * @description: 将;拼接的img长链接拆分
     * @date: 2018/11/10 11:24
     * @param: [imgs]
     * @return: java.util.List<java.lang.String>
     */
    public static List<String> getImgList(String imgs){
        List<String> imgList = new ArrayList<>();

        if(!StringUtils.isEmpty(imgs)) {
            String[] imgArray = imgs.split(";");
            for (String s : imgArray) {
                imgList.add(s);
            }
        }
        return imgList;

    }



    /**
     * @author: zr
     * @description: 多张图片上传OSS,路径用;拼接  路径上追加图片大小及宽高
     * @date: 2019/1/11
     * @param: [imgs, , fileDir]
     * @return: java.lang.StringBuffer
     */
    public static StringBuffer WidthgetDBImgUrl(MultipartFile[] imgs,  String fileDir) throws IOException {
        String randomcode=CommonUtil.randomcode(15);
        String prefix=".jpg";
        StringBuffer imgUrl = new StringBuffer();
        for (MultipartFile img : imgs) {
            try {
                String fileName = img.getOriginalFilename();
                prefix=fileName.substring(fileName.lastIndexOf("."));
                BufferedImage bufferedImage =ImageIO.read(img.getInputStream()); // 通过文件获取图片流
                if (bufferedImage == null) {
                    // 判断上传的文件不是图片，获取图片流失败
                }else{
                    Long total=img.getSize();
                    Integer width = bufferedImage.getWidth(); // 通过图片流获取图片宽度
                    Integer height = bufferedImage.getHeight(); // 通过图片流获取图片高度
                    randomcode+="_"+total+"_"+width+"x"+height;
                }
            } catch (Exception e) {
                // 省略异常操作
            }
            InputStream imgIo = img.getInputStream();
            String imgFileName2 = System.currentTimeMillis()+randomcode+prefix;
            String url = OSSUnit.uploadObject2OSS(imgIo, fileDir, imgFileName2, img.getSize());
            imgUrl.append(url+";");
        }
        return imgUrl;
    }

    //刘会
    public static StringBuffer getDBImgUrlWithWH(MultipartFile[] imgs, String imgName, String fileDir)  throws IOException{

        StringBuffer imgUrl = new StringBuffer();
        for (MultipartFile img : imgs) {
            InputStream imgIo = img.getInputStream();
            String imgFileName2 = imgName + "_"+ System.currentTimeMillis()+"_"+img.getOriginalFilename();
            String url = OSSUnit.uploadObject2OSS(imgIo, fileDir, imgFileName2, img.getSize());
            imgUrl.append(url+";");
        }
        return imgUrl;
    }
}
