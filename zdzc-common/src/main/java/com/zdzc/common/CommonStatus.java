package com.zdzc.common;

/**
 * @Author: zcj
 * @Description: 记录一些公共的标识
 * @Date: Created in 10:50 2018/12/20
 * @Modified By:
 */
public  class CommonStatus {

    /**
     * session用户信息Key
     */
    public static final String ACCOUNT = "account";

    /**
     * 正常状态
     */
    public static final Integer STATUS_NORMAL=0;

    /**
     * 删除状态
     */
    public static final Integer STATUS_DEL=1;


    /**
     * 默认密码
     */
    public static final String DEFAULTPASSWORD="123456";

    /**
     * 瑞眼同步默认的项目key
     */
    public static final String RYPROJECT="RYPROJECT";



    /**
     * 机动车
     */
    public static final String [] DEVICE_TYPE_MOTOR={"3","4"};

    /**
     * 手持
     */
    public static final String [] DEVICE_TYPE_HAND={"1","2"};

    /**
     * 项目ID串标识
     */
    public static final String PROJECTIDS = "projectIds";

    /**
     * 用户Id
     */
    public static final String USER_ID = "userId";

    /**
     * 用户类型 1-超级管理员，2-项目管理员，3-普通用户
     */
    public static final String USER_TYPE = "userType";

    /**
     * 超级管理员
     */
    public static final String USER_ADMIN = "1";

    /**
     * 项目管理员
     */
    public static final String USER_MANAGER = "2";

    /**
     * 普通用户
     */
    public static final String USER_COMMON = "3";


    public static String getResultMsg(String parm){
        String msg = "该用户" +parm+ "有绑定设备，无法绑定该项目，请解绑设备后重试";
        return msg;
    }

    /**
     * 浙大正呈精度
     */
    public static final Double JD=120.062573;

    /**
     * 浙大正呈纬度
     */
    public static final Double WD=30.319107;
}
