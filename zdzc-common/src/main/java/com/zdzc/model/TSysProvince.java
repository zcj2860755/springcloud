package com.zdzc.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_province")
public class TSysProvince implements Serializable {
    /**
     * 省id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 省名
     */
    private String name;

    /**
     * 拼音排序
     */
    @Column(name = "pinyin_sort")
    private String pinyinSort;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

    /**
     * 是否有效 0.无效 1.有效
     */
    private Integer enabled;


    public TSysProvince() {
        super();
    }

    /**
     * 获取省id
     *
     * @return id - 省id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置省id
     *
     * @param id 省id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取省名
     *
     * @return name - 省名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置省名
     *
     * @param name 省名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取拼音排序
     *
     * @return pinyin_sort - 拼音排序
     */
    public String getPinyinSort() {
        return pinyinSort;
    }

    /**
     * 设置拼音排序
     *
     * @param pinyinSort 拼音排序
     */
    public void setPinyinSort(String pinyinSort) {
        this.pinyinSort = pinyinSort;
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
     * 获取是否有效 0.无效 1.有效
     *
     * @return enabled - 是否有效 0.无效 1.有效
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * 设置是否有效 0.无效 1.有效
     *
     * @param enabled 是否有效 0.无效 1.有效
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}