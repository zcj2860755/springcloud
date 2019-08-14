package com.zdzc.common;

import java.util.UUID;

/**
 * 功能：生成access_token
 */
public class KeyUtil {

    /**accesstoken固定前缀*/
    private static final String PREFIX = "ZDZC_";

    /**组件code固定前缀*/
    private static final String COMPONENTPREFIX = "_";

    /**
     * 生成access_token
     * @param appId 平台id
     * @return access_token
     */
    public static String generateAccessToken(String appId){
        String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "");//uuid 是去掉中划线然后大写的32位
        String accessToken = PREFIX + appId + "_" + uuid;//生成access_token
        return accessToken;
    }

    /**
     * 生成小写的验证码
     * @return uid
     */
    public static String generateLowerUUID(){
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

    /**
     * 生成大写的验证码
     * @return uid
     */
    public static String generateUpperUUID(){
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    /**
     * 生成组件code
     * @return 组件code
     */
    public static String generateKey() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return COMPONENTPREFIX + uuid;
    }

    /**
     * 生成第三方应用对应的appId
     * @return 应用id
     */
    public static String generateAppId(){
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
    }

    /**
     * 生成第三方应用对应的appKey
     * @return 应用key
     */
    public static String generateAppKey(){
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 12);
    }

    /**
     * 测试方法
     * @param args 参数
     */
    public static void main(String[] args) {
        System.out.println("appId= " + generateAppId());
        System.out.println("appKey= " + generateAppKey());
        System.out.println("appKey= " + generateAccessToken("873bbedd7dc94afbbb05a27c9dd823d8"));

    }
}

