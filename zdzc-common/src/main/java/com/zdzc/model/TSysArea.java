package com.zdzc.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_area")
public class TSysArea {
    /**
     * 区id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 省id
     */
    @Column(name = "province_id")
    private Integer provinceId;

    /**
     * 市id
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 区名
     */
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 创建者
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 是否有效 0.无效  1.有效
     */
    private Integer enabled;

    /**
     * 获取区id
     *
     * @return id - 区id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置区id
     *
     * @param id 区id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取省id
     *
     * @return province_id - 省id
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省id
     *
     * @param provinceId 省id
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取市id
     *
     * @return city_id - 市id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置市id
     *
     * @param cityId 市id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取区名
     *
     * @return name - 区名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置区名
     *
     * @param name 区名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取创建者
     *
     * @return create_user - 创建者
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建者
     *
     * @param createUser 创建者
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取是否有效 0.无效  1.有效
     *
     * @return enabled - 是否有效 0.无效  1.有效
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * 设置是否有效 0.无效  1.有效
     *
     * @param enabled 是否有效 0.无效  1.有效
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}