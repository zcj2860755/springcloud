package com.zdzc.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 版权所有： 浙大正呈
 * 创建日期:  2018-07-10 11:53
 * 创建作者： 张长江
 * 文件名称： DateUtil.java
 * 版本：     V1.0
 * 功能：     日期操作工具类
 * 修改记录：
 */
public final class DateUtil {

    /** */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    /** */
    public static final String YYYYMMDD = "yyyyMMdd";
    /** */
    public static final String YYYYMMDDHH = "yyyyMMddHH";
    /** */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /** */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /** */
    public static final String YYYY_MM_DD_HH_MM_DASH = "yyyy-MM-dd_HH:mm";
    /** */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /** */
    public static final String YYMMDDHHMMSS = "yyMMddHHmmss";

    /**
     * 根据指定格式转换成日期字符串
     * @param date 日期
     * @param format 表达式
     * @return 格式化后的日期
     */
    public static String formatToString(Date date, String format) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * @param s 日期
     * @param format 表达式
     * @return 日期
     */
    public static Date parseToDate(String s, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取时间差
     * @param starDate 开始日期
     * @param endDate 结束日期
     * @param format 日期格式
     * @return 时间差
     * @throws Exception 异常
     * @author zcj
     * @date Created in 9:56 2018/7/10
     */
    public static String diffTime(String starDate, String endDate,String format) throws Exception {
        DateFormat df = new SimpleDateFormat(format);
        Date authDate = df.parse(starDate);
        Date offlineDate = df.parse(endDate);
        Long diff = offlineDate.getTime() - authDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        long second =  (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)- minutes * (1000 * 60)) / 1000;

        String diffTime="";
        if(days>0){
            diffTime+= days + "天";
        }

        if(hours>0){
            diffTime+= hours + "小时";
        }

        if(minutes>0){
            diffTime+= minutes + "分钟";
        }

        if(second>0){
            diffTime+= second + "秒";
        }
        return diffTime;
    }
}
