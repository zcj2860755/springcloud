package com.zdzc.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_city")
public class TSysCity {
    /**
     * 市id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 省id
     */
    @Column(name = "provide_id")
    private Integer provideId;

    /**
     * 市名
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
     * 是否有效 0.无效  1.有效
     */
    private Integer enabled;

    /**
     * 获取市id
     *
     * @return id - 市id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置市id
     *
     * @param id 市id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取省id
     *
     * @return provide_id - 省id
     */
    public Integer getProvideId() {
        return provideId;
    }

    /**
     * 设置省id
     *
     * @param provideId 省id
     */
    public void setProvideId(Integer provideId) {
        this.provideId = provideId;
    }

    /**
     * 获取市名
     *
     * @return name - 市名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置市名
     *
     * @param name 市名
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