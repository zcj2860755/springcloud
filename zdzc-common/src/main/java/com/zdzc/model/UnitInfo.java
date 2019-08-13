package com.zdzc.model;

import io.swagger.models.auth.In;

import java.util.Date;
import javax.persistence.*;

@Table(name = "unit_info")
public class UnitInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位编码
     */
    private String code;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 单位地址
     */
    private String address;

    @Column(name = "area_id")
    private String areaId;

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
     * 统一信用代码
     */
    @Column(name = "credit_code")
    private String creditCode;

    /**
     * 单位证书url
     */
    @Column(name = "unit_credent_url")
    private String unitCredentUrl;

    /**
     * logo地址url
     */
    @Column(name = "logo_url")
    private String logoUrl;

    /**
     * 冻结状态
     */
    @Column(name = "freeze_status")
    private Integer freezeStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private String updateUser;

    private String remark;

    /**
     * 是否删除  0.未删除  1.删除
     */
    @Column(name = "del_flag")
    private Integer delFlag;

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

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private String cityCode;

    private String district;

    /**
     * 区划分编码
     */
    private String adcode;

    @Column(name = "long_address")
    private String longAddress;

    @Column(name = "admin_area_id")
    private String adminAreaId;

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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取单位编码
     *
     * @return code - 单位编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置单位编码
     *
     * @param code 单位编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取单位名称
     *
     * @return name - 单位名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置单位名称
     *
     * @param name 单位名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取单位地址
     *
     * @return address - 单位地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置单位地址
     *
     * @param address 单位地址
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 获取统一信用代码
     *
     * @return credit_code - 统一信用代码
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * 设置统一信用代码
     *
     * @param creditCode 统一信用代码
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    /**
     * 获取单位证书url
     *
     * @return unit_credent_url - 单位证书url
     */
    public String getUnitCredentUrl() {
        return unitCredentUrl;
    }

    /**
     * 设置单位证书url
     *
     * @param unitCredentUrl 单位证书url
     */
    public void setUnitCredentUrl(String unitCredentUrl) {
        this.unitCredentUrl = unitCredentUrl;
    }

    /**
     * 获取logo地址url
     *
     * @return logo_url - logo地址url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 设置logo地址url
     *
     * @param logoUrl logo地址url
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * 获取冻结状态
     *
     * @return freeze_status - 冻结状态
     */
    public Integer getFreezeStatus() {
        return freezeStatus;
    }

    /**
     * 设置冻结状态
     *
     * @param freezeStatus 冻结状态
     */
    public void setFreezeStatus(Integer freezeStatus) {
        this.freezeStatus = freezeStatus;
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
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
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
     * 获取城市编码
     *
     * @return city_code - 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置城市编码
     *
     * @param cityCode 城市编码
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
     * 获取区划分编码
     *
     * @return adcode - 区划分编码
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * 设置区划分编码
     *
     * @param adcode 区划分编码
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
}