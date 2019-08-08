package com.zdzc.model;

import com.zdzc.common.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@ApiModel
@Table(name = "t_sys_role")
public class TSysRole extends BaseRequest {

    /**
     * 角色禁用状态
     */
    public static final Integer ROLE_FORBID=1;

    /**
     * 主键id
     */
    @Id
    @ApiModelProperty("主键id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色标识
     */
    @ApiModelProperty("角色标识")
    @Column(name = "role_sign")
    private String roleSign;

    /**
     * 所属机构id
     */
    @ApiModelProperty("所属机构id")
    @Column(name = "org_id")
    private String orgId;

    /**
     * 状态( 0-启用 1-禁用)
     */
    @ApiModelProperty("状态( 0-启用 1-禁用)")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

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
     * 是否可以登录，0-可以登录，1-不容许
     */
    @Column(name = "is_login")
    private Integer isLogin;

    /**
     * 权限集合
     */
    @Transient
    @ApiModelProperty("权限集合")
    private String[] authIds;

    /**
     * 查询内容
     */
    @Transient
    private String searchContent;

    /**
     * 上级名称
     */
    @Transient
    private String parentName;

    /**
     * 是否删除标识，0-正常，1-删除
     */
    @ApiModelProperty("是否删除标识，0-正常，1-删除")
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色标识
     *
     * @return role_sign - 角色标识
     */
    public String getRoleSign() {
        return roleSign;
    }

    /**
     * 设置角色标识
     *
     * @param roleSign 角色标识
     */
    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    /**
     * 获取所属机构id
     *
     * @return org_id - 所属机构id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置所属机构id
     *
     * @param orgId 所属机构id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取状态( 0-禁用 1-启用)
     *
     * @return status - 状态( 0-禁用 1-启用)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态( 0-禁用 1-启用)
     *
     * @param status 状态( 0-禁用 1-启用)
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    public String[] getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String[] authIds) {
        this.authIds = authIds;
    }

    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}