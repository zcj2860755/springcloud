package com.zdzc.utils.OSS;

/**
 * 工具类
 */
public class CommonUtil {

    public CommonUtil() {

    }


/*生成字母大小写+数字的随机数*/
    public static  String randomcode (int num){
        //用字符数组的方式随机
        String randomcode = "";
        String model = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] m = model.toCharArray();
        for (int j=0;j<num ;j++ )
        {
            char c = m[(int)(Math.random()*62)];
            randomcode+=c;
        }
        return randomcode;
    }

}
