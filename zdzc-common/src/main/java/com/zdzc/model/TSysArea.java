package com.zdzc.model;

import javax.persistence.*;

@Table(name = "t_sys_area")
public class TSysArea {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 简写名称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 城市级别 1.省 2.市 3.区 4.街道、镇
     */
    private Integer level;

    @Column(name = "path_ids")
    private String pathIds;

    @Transient
    private String GroupName;

    @Transient
    private Integer mark;


    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
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
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取地区名称
     *
     * @return name - 地区名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置地区名称
     *
     * @param name 地区名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取简写名称
     *
     * @return short_name - 简写名称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置简写名称
     *
     * @param shortName 简写名称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取城市级别 1.省 2.市 3.区 4.街道、镇
     *
     * @return level - 城市级别 1.省 2.市 3.区 4.街道、镇
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置城市级别 1.省 2.市 3.区 4.街道、镇
     *
     * @param level 城市级别 1.省 2.市 3.区 4.街道、镇
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return path
     */
    public String getPathIds() {
        return pathIds;
    }

    /**
     * @param pathIds
     */
    public void setPathIds(String pathIds) {
        this.pathIds = pathIds;
    }
}