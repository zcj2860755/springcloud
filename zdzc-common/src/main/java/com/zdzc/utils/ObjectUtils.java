package com.zdzc.utils;

public class ObjectUtils {

    /**
     * @param obj
     * @return  true-为空  false-不为空
     */
    public static Boolean isEmpty(Object obj){
        Boolean status = false;
        if(obj == null){
            return true;
        }
        if(obj instanceof String){
            if("".equals(obj.toString().trim())){
                status = true;
            }
        }
        return status;
    }
}
