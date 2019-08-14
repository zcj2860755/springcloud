package com.zdzc.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_manager_area")
public class TManagerArea {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父级id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 所有父级id
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 区域编码
     */
    private String code;

    /**
     * 区域类型
     */
    private Integer type;

    /**
     * 创建者
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标记  0.未删除  1.已删除
     */
    @Column(name = "del_flag")
    private String delFlag;

    @Transient
    private String keyWords;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
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
     * 获取父级id
     *
     * @return parent_id - 父级id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级id
     *
     * @param parentId 父级id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取所有父级id
     *
     * @return parent_ids - 所有父级id
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置所有父级id
     *
     * @param parentIds 所有父级id
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取区域编码
     *
     * @return code - 区域编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置区域编码
     *
     * @param code 区域编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取区域类型
     *
     * @return type - 区域类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置区域类型
     *
     * @param type 区域类型
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取更新者
     *
     * @return update_user - 更新者
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新者
     *
     * @param updateUser 更新者
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    /**
     * 获取删除标记  0.未删除  1.已删除
     *
     * @return del_flag - 删除标记  0.未删除  1.已删除
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记  0.未删除  1.已删除
     *
     * @param delFlag 删除标记  0.未删除  1.已删除
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}