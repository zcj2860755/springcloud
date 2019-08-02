package com.zdzc.utils;

/**
 * @Author: zcj
 * @Description:
 * @Date: Created in 9:12 2018/12/25
 * @Modified By:
 */
public class ArrayUtil {
    public static  String replace(String parm){
        return parm.replace("\"","").replace("[","").replace("]","");
    }
}
