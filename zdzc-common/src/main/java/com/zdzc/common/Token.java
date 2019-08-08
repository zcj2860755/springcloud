package com.zdzc.common;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/14.
 */
public class Token implements Serializable {

    private static final long serialVersionUID = -7195818219149330529L;

    @ApiModelProperty("用户Id")
    private String userId;
    @ApiModelProperty("session Id")
    private String uuid;
    @ApiModelProperty("角色 Id")
    private String roleId;
    @ApiModelProperty("用户名称")
    private String realName;
    @ApiModelProperty("项目id")
    private String proId;
    @ApiModelProperty("权限合集")
    private Set<String> signSet;

    public Token() {
    }

    public Token(String userId, String uuid, Set<String> signSet) {
        this.userId = userId;
        this.uuid = uuid;
        this.signSet = signSet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Set<String> getSignSet() {
        return signSet;
    }

    public void setSignSet(Set<String> signSet) {
        this.signSet = signSet;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 校验权限，即所请求的接口是否在当前token所拥有的权限列表中
     * 包含其中一个标识，即可访问
     *
     * @param signArr 权限标识
     * @return 校验结果
     */
    public boolean confirmSign(String... signArr) {
        if (signArr == null) return true;
        for (String sign : signArr) {
            if (this.signSet != null && this.signSet.contains(sign)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 包含其中一个标识,及不可访问
     *
     * @param signArr 权限标识
     * @return
     */
    public boolean refuseSign(String... signArr) {
        if (signArr == null) return true;
        return confirmSign(signArr);
    }

    /**
     * 两者冲突一sign内可访问为准
     *
     * @param sign    拥有即可访问
     * @param disSign 拥有即不能访问
     * @return
     */
    public boolean confirm(String[] sign, String[] disSign) {
        if (sign == null && disSign == null) {
            return true;
        } else if (sign == null && disSign != null) {
            return refuseSign(disSign);
        } else if (sign != null && disSign == null) {
            return confirmSign(sign);
        } else {
            return confirmSign(sign);
        }
    }


    @Override
    public boolean equals(Object that) {
        if (that != null
                && that instanceof Token) {
            return this.getUuid().equals(((Token) that).getUuid())
                    && this.getUserId().equals(((Token) that).getUserId());
        }
        return false;
    }


}
