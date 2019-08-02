package com.zdzc.utils;

import java.net.URLEncoder;
import java.util.Map;

public class MapUtil {

    private static double EARTH_RADIUS = 6378.137;

    /**
     *
     * @param map
     * @return
     */
    public static String Map2UrlString(Map<String,String> map){
        StringBuffer sb = new StringBuffer();
        sb.append("?");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue())).append("&");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：千米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 距离
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        return s;
    }


}
