package com.zdzc.model;

import com.zdzc.common.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ApiModel
@Table(name = "t_sys_authority")
public class TSysAuthority extends BaseRequest {
    /**
     * 主键id
     */
    @Id
    @ApiModelProperty("主键id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    @Column(name = "auth_name")
    private String authName;

    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    @Column(name = "auth_sign")
    private String authSign;

    /**
     * 访问路径
     */
    @ApiModelProperty("访问路径")
    @Column(name = "auth_url")
    private String authUrl;

    @ApiModelProperty("实际文件路径")
    @Column(name = "auth_filePath")
    private String authFilePath;

    /**
     * 上级ID
     */
    @ApiModelProperty("上级ID")
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 权限类型（1:菜单;2:操作）
     */
    @ApiModelProperty("权限类型（1:菜单;2:操作）")
    @Column(name = "auth_type")
    private String authType;

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
     * 排序
     */
    @ApiModelProperty("排序")
    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     *子节点
     */
    @Transient
    public List<TSysAuthority> children;


    @Transient
    private String searchContent;

    @Transient
    @ApiModelProperty("父节点名称")
    private String parentName;

    @Transient
    private List<String> ids;

    @Transient
    private String keyword;

    @Transient
    private String authTypeBlack;

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
     * 获取权限名称
     *
     * @return auth_name - 权限名称
     */
    public String getAuthName() {
        return authName;
    }

    /**
     * 设置权限名称
     *
     * @param authName 权限名称
     */
    public void setAuthName(String authName) {
        this.authName = authName;
    }

    /**
     * 获取权限标识
     *
     * @return auth_sign - 权限标识
     */
    public String getAuthSign() {
        return authSign;
    }

    /**
     * 设置权限标识
     *
     * @param authSign 权限标识
     */
    public void setAuthSign(String authSign) {
        this.authSign = authSign;
    }

    /**
     * 获取访问路径
     *
     * @return auth_url - 访问路径
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * 设置访问路径
     *
     * @param authUrl 访问路径
     */
    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
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
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取权限类型（1:菜单;2:操作）
     *
     * @return auth_type - 权限类型（1:菜单;2:操作）
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * 设置权限类型（1:菜单;2:操作）
     *
     * @param authType 权限类型（1:菜单;2:操作）
     */
    public void setAuthType(String authType) {
        this.authType = authType;
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

    public List<TSysAuthority> getChildren() {
        return children;
    }

    public void setChildren(List<TSysAuthority> children) {
        this.children = children;
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

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAuthTypeBlack() {
        return authTypeBlack;
    }

    public void setAuthTypeBlack(String authTypeBlack) {
        this.authTypeBlack = authTypeBlack;
    }

    public String getAuthFilePath() {
        return authFilePath;
    }

    public void setAuthFilePath(String authFilePath) {
        this.authFilePath = authFilePath;
    }
}
