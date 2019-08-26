package com.zdzc.model;

import com.zdzc.common.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ApiModel
@Table(name = "t_sys_project")
public class TSysProject extends BaseRequest {

    /**
     * 主键
     */
    @Id
    @ApiModelProperty("主键")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 上级ID
     */
    @ApiModelProperty("上级ID")
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 串联id
     */
    @ApiModelProperty("串联id")
    @Column(name = "cascade_id")
    private String cascadeId;

    /**
     * 项目编码
     */
    @ApiModelProperty("项目编码")
    @Column(name = "pro_code")
    private String proCode;

    /**
     * 项目名称
     */
    @ApiModelProperty("项目名称")
    @Column(name = "pro_name")
    private String proName;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    private String contacts;

    /**
     * 是否叶子节点
     */
    @ApiModelProperty("是否叶子节点")
    @Column(name = "is_leaf")
    private Integer isLeaf;

    /**
     * 排序字段
     */
    @ApiModelProperty("排序字段")
    private String orders;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    @Column(name = "is_enable")
    private Integer isEnable;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @Column(name = "account_id")
    private String accountId;

    /**
     *查询内容
     */
    @Transient
    private String searchContent;

    /**
     *上级名称
     */
    @Transient
    private String parentName;

    /**
     * 上级CascadeId
     */
    @Transient
    private String parentCascadeId;

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
     * 获取上级ID
     *
     * @return parent_id - 上级ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置上级ID
     *
     * @param parentId 上级ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取串联id
     *
     * @return cascade_id - 串联id
     */
    public String getCascadeId() {
        return cascadeId;
    }

    /**
     * 设置串联id
     *
     * @param cascadeId 串联id
     */
    public void setCascadeId(String cascadeId) {
        this.cascadeId = cascadeId;
    }

    /**
     *子节点
     */
    @Transient
    public List<TSysProject> childTSysProject;

    /**
     * 获取项目编码
     *
     * @return pro_code - 项目编码
     */
    public String getProCode() {
        return proCode;
    }

    /**
     * 设置项目编码
     *
     * @param proCode 项目编码
     */
    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    /**
     * 获取项目名称
     *
     * @return pro_name - 项目名称
     */
    public String getProName() {
        return proName;
    }

    /**
     * 设置项目名称
     *
     * @param proName 项目名称
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /**
     * 获取联系人
     *
     * @return contacts - 联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     *
     * @param contacts 联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * 获取是否叶子节点
     *
     * @return is_leaf - 是否叶子节点
     */
    public Integer getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否叶子节点
     *
     * @param isLeaf 是否叶子节点
     */
    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 获取排序字段
     *
     * @return orders - 排序字段
     */
    public String getOrders() {
        return orders;
    }

    /**
     * 设置排序字段
     *
     * @param orders 排序字段
     */
    public void setOrders(String orders) {
        this.orders = orders;
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
     * 获取是否启用
     *
     * @return is_enable - 是否启用
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否启用
     *
     * @param isEnable 是否启用
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
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
     * 获取创建人
     *
     * @return account_id - 创建人
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 设置创建人
     *
     * @param accountId 创建人
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<TSysProject> getChildTSysProject() {
        return childTSysProject;
    }

    public void setChildTSysProject(List<TSysProject> childTSysProject) {
        this.childTSysProject = childTSysProject;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentCascadeId() {
        return parentCascadeId;
    }

    public void setParentCascadeId(String parentCascadeId) {
        this.parentCascadeId = parentCascadeId;
    }
}
