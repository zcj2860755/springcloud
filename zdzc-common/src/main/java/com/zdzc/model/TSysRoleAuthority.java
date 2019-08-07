package com.zdzc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel
@Table(name = "t_sys_role_authority")
public class TSysRoleAuthority {
    /**
     * 主键id
     */
    @Id
    @ApiModelProperty("主键id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @Column(name = "role_id")
    private String roleId;

    /**
     * 权限id
     */
    @ApiModelProperty("权限id")
    @Column(name = "auth_id")
    private String authId;

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
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限id
     *
     * @return auth_id - 权限id
     */
    public String getAuthId() {
        return authId;
    }

    /**
     * 设置权限id
     *
     * @param authId 权限id
     */
    public void setAuthId(String authId) {
        this.authId = authId;
    }
}