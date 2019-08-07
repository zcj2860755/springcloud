package com.zdzc.model;

import javax.persistence.*;

@Table(name = "t_sys_dic_category")
public class TSysDicCategory {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 字典key
     */
    @Column(name = "dic_key")
    private String dicKey;

    /**
     * 字典value
     */
    @Column(name = "dic_value")
    private String dicValue;

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
     * 描述
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
    public String getDicValue() {
        return dicValue;
    }

    /**
     * 设置字典value
     *
     * @param dicValue 字典value
     */
    public void setDicValue(String dicValue) {
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
     * 获取描述
     *
     * @return remark - 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述
     *
     * @param remark 描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}