package com.zdzc.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "place_info")
public class PlaceInfo {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 场所名称
     */
    private String name;

    /**
     * 场所编号
     */
    private String code;

    /**
     * 场所地址
     */
    private String address;

    /**
     * 场所性质
     */
    private Integer type;

    /**
     * 负责人
     */
    private String manager;

    /**
     * 负责人电话
     */
    @Column(name = "manager_telephone")
    private String managerTelephone;

    /**
     * 单位id
     */
    @Column(name = "unit_id")
    private String unitId;

    /**
     * 面积大小
     */
    @Column(name = "area_size")
    private String areaSize;

    /**
     * 消防室tel
     */
    @Column(name = "fire_telephone")
    private String fireTelephone;

    /**
     * 是否独立主机  0.是   1.否
     */
    @Column(name = "is_main")
    private String isMain;

    /**
     * 经度
     */
    private Double lon;

    /**
     * 纬度
     */
    private Double lat;

    private String province;

    private String city;

    @Column(name = "city_code")
    private String cityCode;

    private String district;

    private String adcode;

    @Column(name = "long_address")
    private String longAddress;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 描述信息
     */
    private String remark;

    /**
     * 是否删除  0.未删除  1.删除
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    @Column(name = "area_id")
    private String areaId;

    @Column(name = "admin_area_id")
    private String adminAreaId;

    /**
     * 冻结状态  0：未冻结，1：已冻结
     */
    @Column(name = "freeze_status")
    private Integer freezeStatus;

    @Transient
    private String keyWords;
    @Transient
    private Integer mark;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }


    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取场所名称
     *
     * @return name - 场所名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置场所名称
     *
     * @param name 场所名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取场所编号
     *
     * @return code - 场所编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置场所编号
     *
     * @param code 场所编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取场所地址
     *
     * @return address - 场所地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置场所地址
     *
     * @param address 场所地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取场所性质
     *
     * @return type - 场所性质
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置场所性质
     *
     * @param type 场所性质
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取负责人
     *
     * @return manager - 负责人
     */
    public String getManager() {
        return manager;
    }

    /**
     * 设置负责人
     *
     * @param manager 负责人
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * 获取负责人电话
     *
     * @return manager_telephone - 负责人电话
     */
    public String getManagerTelephone() {
        return managerTelephone;
    }

    /**
     * 设置负责人电话
     *
     * @param managerTelephone 负责人电话
     */
    public void setManagerTelephone(String managerTelephone) {
        this.managerTelephone = managerTelephone;
    }

    /**
     * 获取单位id
     *
     * @return unit_id - 单位id
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * 设置单位id
     *
     * @param unitId 单位id
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取面积大小
     *
     * @return area_size - 面积大小
     */
    public String getAreaSize() {
        return areaSize;
    }

    /**
     * 设置面积大小
     *
     * @param areaSize 面积大小
     */
    public void setAreaSize(String areaSize) {
        this.areaSize = areaSize;
    }

    /**
     * 获取消防室tel
     *
     * @return fire_telephone - 消防室tel
     */
    public String getFireTelephone() {
        return fireTelephone;
    }

    /**
     * 设置消防室tel
     *
     * @param fireTelephone 消防室tel
     */
    public void setFireTelephone(String fireTelephone) {
        this.fireTelephone = fireTelephone;
    }

    /**
     * 获取是否独立主机  0.是   1.否
     *
     * @return is_main - 是否独立主机  0.是   1.否
     */
    public String getIsMain() {
        return isMain;
    }

    /**
     * 设置是否独立主机  0.是   1.否
     *
     * @param isMain 是否独立主机  0.是   1.否
     */
    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    /**
     * 获取经度
     *
     * @return lon - 经度
     */
    public Double getLon() {
        return lon;
    }

    /**
     * 设置经度
     *
     * @param lon 经度
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return city_code
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return adcode
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * @param adcode
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    /**
     * @return long_address
     */
    public String getLongAddress() {
        return longAddress;
    }

    /**
     * @param longAddress
     */
    public void setLongAddress(String longAddress) {
        this.longAddress = longAddress;
    }

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取描述信息
     *
     * @return remark - 描述信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述信息
     *
     * @param remark 描述信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否删除  0.未删除  1.删除
     *
     * @return del_flag - 是否删除  0.未删除  1.删除
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置是否删除  0.未删除  1.删除
     *
     * @param delFlag 是否删除  0.未删除  1.删除
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @return area_id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * @return admin_area_id
     */
    public String getAdminAreaId() {
        return adminAreaId;
    }

    /**
     * @param adminAreaId
     */
    public void setAdminAreaId(String adminAreaId) {
        this.adminAreaId = adminAreaId;
    }

    /**
     * 获取冻结状态  0：未冻结，1：已冻结
     *
     * @return freeze_status - 冻结状态  0：未冻结，1：已冻结
     */
    public Integer getFreezeStatus() {
        return freezeStatus;
    }

    /**
     * 设置冻结状态  0：未冻结，1：已冻结
     *
     * @param freezeStatus 冻结状态  0：未冻结，1：已冻结
     */
    public void setFreezeStatus(Integer freezeStatus) {
        this.freezeStatus = freezeStatus;
    }
}