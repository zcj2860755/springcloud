package com.zdzc.enums;

public enum ExceptionEnum {
    //--------------- 公共异常 -------------------------
    SYSTEM_ERROR(9999,"系统异常"),
    SYSTEM_ADD_ERROR(1001,"添加失败"),
    SYSTEM_UPDATE_ERROR(1002,"修改失败"),
    SYSTEM_DELETE_ERROR(1003,"删除失败"),
    SYSTEM_BEGINTIME_NULL(1004,"开始时间不能为空"),
    SYSTEM_ENDTIME_NULL(1005,"结束时间不能为空"),
    SYSTEM_TIMECHANGE_NULL(1006,"时间转换失败"),
    SYSTEM_USER_NOTLOGIN(1007,"用户未登陆"),
    SYSTEM_CONNECTIONTIMEOUT(1008,"查询超时，请重新查询"),
    SYSTEM_USER_TOKEN(1009,"用户未登录，请登录！"),

    //--------------- 用户自定义自定义异常 -------------------------
    SYSTEM_ADD_ERROR_RESON(1001001,"该用户账号已存在"),
    SYSTEM_LOGIN_ERROR_RESON(1001002,"用户名或密码不正确"),
    SYSTEM_LOGIN_ERROR_RESON2(1001003,"该用户账号没有登录权限"),
    SYSTEM_LOGIN_ERROR_DJ(1001004,"该用户已被冻结，不能登陆"),
    SYSTEM_DELETE_ERROR_RESON(1003001,"该用户账号下绑定了设备，若要删除，请先解绑"),
    SYSTEM_update_STATUS_RESON(1003002,"该用户账号下绑定了设备，若要冻结，请先解绑"),
    SYSTEM_UPDATE_ERROR_RESON(1002001,"请输入正确的旧密码"),

    //--------------- 设备相关信息错误  10000+ -----------------
    DEVICE_CODE_NULL(10001,"设备编号不能为空"),
    DEVICE_MODEL_NULL(10002,"设备型号不能为空"),
    DEVICE_TYPE_NULL(10003,"设备类型不能为空"),
    DEVICE_CREATE_NOTEXIST(10004,"创建用户不存在"),
    DEVICE_HAS_EXIST(10005,"设备已存在"),
    DEVICE_CREATE_NULL(10006,"创建人不能为空"),
    DEVICE_LOCATIONURL_NULL(10007,"设备位置通信地址不能为空"),
    DEVICE_FILTERTRAILS_NULL(10008,"是否过滤经纬度为0不能为空"),
    DEVICE_TIMESTYLE_NULL(10009,"开始时间和结束时间必须在同一天的0点到24点"),
    DEVICE_AMAPWEBKEY_NULL(10010,"高德WebKey未配置"),
    DEVICE_AMAPWEBURL_NULL(10011,"高德WebUrl未配置"),
    DEVICE_CODE_ISNOTEXIT(10012,"该设备不存在"),
    DEVICE_DATA_ISNOTEXIT(10013,"未找到符合条件的数据"),

    //--------------- 系统配置相关错误 20000+ -----------------
    SYSTEM_PARAMSID_NULL(20001,"参数Id不能为空"),
    SYSTEM_PARAMSNAME_NULL(20002,"参数名称不能为空"),
    SYSTEM_PARAMSKEY_NULL(20003,"参数KEY不能为空"),
    SYSTEM_PARAMSVALUE_NULL(20004,"参数值不能为空"),
    SYSTEM_PARAMSNOTEXITS_NULL(20005,"该参数不存在"),
    SYSTEM_ISENABLE_NULL(20006,"是否启用不能为空"),
    SYSTEM_SORT_NULL(20007,"排序字段不能为空"),
    SYSTEM_DICID_NULL(20008,"字典类别Id不能为空"),
    SYSTEM_DICNOTEXIST_NULL(20009,"字典类别不存在"),
    SYSTEM_DICSUBEXIST_NULL(20010,"字典类别分配字典，请先删除下级字典"),
    SYSTEM_PARAMSIDS_NULL(20011,"参数Ids不能为空"),
    SYSTEM_PARAMSKEY_EXIST(20012,"参数编码已存在"),
    SYSTEM_DICKEY_EXIST(20013,"字典编码已存在"),

    //--------------- 权限相关错误 30000+ --------------------
    POWER_CHILD_EXIST(30001,"删除失败，存在子节点"),
    POWER_USER_EXIST(30002,"删除失败，存在用户"),
    POWER_NAME_NULL(30003,"权限名称不能为空"),
    POWER_SIGN_NULL(30004,"权限标识不能为空"),
    POWER_PARENTID_NULL(30005,"权限上级Id不能为空"),
    POWER_TYPE_NULL(30006,"权限类型不能为空"),
    POWER_ID_NULL(30007,"权限Id不能为空"),


    //--------------- 用户角色相关错误 40000+ --------------------
    USER_ROLE_NAMEEXIST(40002,"新增失败，该角色已存在"),
    USER_ROLE_DISTRIBUTION(40001,"删除失败，该角色已被分配"),
    USER_ROLE_NOPOWER(40002,"未分配权限"),
    USER_ID_NULL(40003,"用户Id不能为空"),
    USER_ACCOUNT_NULL(40004,"用户账号不能为空"),
    USER_REALNAME_NULL(40005,"用户名不能为空"),
    USER_ROLEID_NULL(40006,"角色不能为空"),
    USER_UPDATE_NEEDLOGIN(40007,"您的用户信息已更改，请重新登录！"),
    USER_NOT_ASCRIPTION(40008,"登陆失败，该用户没有归属"),
    USER_STATUS_NULL(40009,"用户状态不能为空"),
    USER_OLDPASSWORD_NULL(40010,"旧密码不能为空"),
    USER_NEWPASSWORD_NULL(40011,"新密码不能为空"),
    USER_PHONE_NULL(40012,"用户手机号码不能为空"),

    //--------------- 项目相关错误 50000+ --------------------
    PROJECT_ERROR(50001,"[]"),
    PROJECT_UPDATE_ERROR(50002,"父子级关系错误，请重新编辑"),
    PROJECT_EDIT_ERROR(50003,"该用户没有权限，只能查看，不能编辑"),
    PROJECT_NAME_EXIST(50004,"项目已存在"),

    //--------------数据字典相关错误 60000+ --------------------
    DIC_CATEGORY_NULL(60001,"字典类别不能为空"),
    DIC_KEY_NULL(60002,"字典编码不能为空"),
    DIC_VABLE_NULL(60003,"字典名称不能为空"),
    DIC_ENABLE_NULL(60004,"字典是否启动不能为空"),
    DIC_SORT_NULL(60005,"字典排序不能为空"),
    //省市区
    PARENT_ID_NULL(60006,"父级id不能为空"),
    AREA_NAME_NULL(60007,"区域名称不能为空"),
    SHOT_AREA_NAME_NULL(60008,"简写名称不能为空"),
    AREA_LEVEL_NULL(60009,"区域等级不能为空"),
    AREA_TYPE_NULL(600010,"类型不能为空"),

    //--------------区域单位场所相关错误 70000+ --------------------
    PLACE_NAME_NULL(70001,"场所名称不能为空"),
    PLACE_TYPE_NULL(70001,"场所性质不能为空"),
    PLACE_ADDRESS_NULL(70001,"场所地址不能为空"),
    PLACE_OF_AREA_NULL(70001,"所属区域不能为空"),     // 单位也有
    PLACE_UNIT_NULL(70001,"所属单位不能为空"),
    PLACE_MM_NULL(70001,"场所面积不能为空"),
    MANAGER_NULL(70001,"负责人不能为空"),              // 单位也有
    MANAGER_TEL_NULL(70001,"负责人电话不能为空"),        // 单位也有
    FIRE_TEL_NULL(70001,"消防室电话不能为空"),
    IS_MAIN_NULL(70001,"独立主机不能为空"),
    PLACE_LON_NULL(70001,"场所坐标-经度不能为空"),
    PLACE_LAT_NULL(70001,"场所坐标-纬度不能为空"),
    ADMIN_AREA_ID_MULL(70001,"adminAreaId不能为空"),
    PROVINCE_NULL(70001,"省份不能为空"),
    CITY_NULL(70001,"城市不能为空"),
    AREA_NULL(70001,"区不能为空"),
    CITY_CODE_NULL(70001,"城市编码不能为空"),
    AREA_CODE_NULL(70001,"区编码不能为空"),


    //单位
    UNIT_NAME_NULL(70001,"单位名称不能为空"),
    UNIT_ADDRESS_NULL(70001,"单位地址不能为空"),
    CREDIT_CODE_NULL(70001,"统一信用码不能为空"),
    UNIT_CHILDREN_PLACE_NULL(70001,"该单位下有场所,不能删除"),
    PARAM_IS_NOT_NULL(70001,"参数不能为空"),  //标志参数不能为空

    //区域
    PARENT_AREA_ID_NULL(70001,"上级区域id不能为空"),
    PARENT_AREA_IDS_NULL(70001,"上级区域ids不能为空"),


    ;



    ExceptionEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
