package com.zdzc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;



public class PlaceUnitUtils {



    /**
     * description : 场所、单位code 生成 0:场所 其它的:单位
     */
    public static String createPlaceCode(int param) {
        String str;
        if(param == 0){ //0.生成场所
            str="zcp";
        }else{
            str="zcc";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMd");
        String date = dateFormat.format(new Date());
        long round = Math.round(Math.random() * 9000 + 1000);
        return (str+date+round);
    }


    public static String createLongAddress(Double lon,Double lat) {

        return "";
    }




}
