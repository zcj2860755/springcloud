package com.zdzc.model;

import javax.persistence.*;

@Table(name = "t_sys_dic")
public class TSysDic {
    /**
     * 主键
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 类别id
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 字典key
     */
    @Column(name = "dic_key")
    private String dicKey;

    /**
     * 字典value
     */
    @Column(name = "dic_value")
    private Integer dicValue;

    /**
     * 是否启用 1-启用 0-关闭
     */
    @Column(name = "is_enable")
    private Integer isEnable;

    /**
     * 排序
     */
    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取类别id
     *
     * @return category_id - 类别id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类别id
     *
     * @param categoryId 类别id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取字典key
     *
     * @return dic_key - 字典key
     */
    public String getDicKey() {
        return dicKey;
    }

    /**
     * 设置字典key
     *
     * @param dicKey 字典key
     */
    public void setDicKey(String dicKey) {
        this.dicKey = dicKey;
    }

    /**
     * 获取字典value
     *
     * @return dic_value - 字典value
     */
    public Integer getDicValue() {
        return dicValue;
    }

    /**
     * 设置字典value
     *
     * @param dicValue 字典value
     */
    public void setDicValue(Integer dicValue) {
        this.dicValue = dicValue;
    }

    /**
     * 获取是否启用 1-启用 0-关闭
     *
     * @return is_enable - 是否启用 1-启用 0-关闭
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否启用 1-启用 0-关闭
     *
     * @param isEnable 是否启用 1-启用 0-关闭
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取排序
     *
     * @return sort_no - 排序
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 设置排序
     *
     * @param sortNo 排序
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}