package com.zdzc.model;

import com.zdzc.common.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ApiModel
@Table(name = "t_sys_account")
public class TSysAccount extends BaseRequest {

    @ApiModelProperty("主键")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @Column(name = "real_name")
    private String realName;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Integer sex;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String tel;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;

    /**
     * 项目id
     */
    @ApiModelProperty("项目id")
    @Column(name = "pro_id")
    private String proId;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @Column(name = "role_id")
    private String roleId;

    /**
     * 状态( 0-启用 1-禁用)
     */
    @ApiModelProperty("状态( 0-启用 1-冻结)")
    private Integer status;

    /**
     * 最后登录时间
     */
    @ApiModelProperty("最后登录时间")
    @Column(name = "lastlogin_time")
    private Date lastloginTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否绑定到项目，0-未绑定，1-已绑定，项目管理员
     */
    @ApiModelProperty("是否绑定到项目，0-未绑定，1-已绑定，项目管理员")
    private Integer isbind;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @Column(name = "self_id")
    private String selfId;

    /**
     * 是否删除标识，0-正常，1-删除
     */
    @ApiModelProperty("是否删除标识，0-正常，1-删除")
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 设备编号集
     */
    @ApiModelProperty("设备编号集合")
    @Transient
    private String[] deviceCodes;

    /**
     * 设备id集
     */
    @ApiModelProperty("设备id集合")
    @Transient
    private String[] deviceIds;
    /**
     * 查询条件
     */
    @ApiModelProperty("查询条件")
    @Transient
    private String searchContent;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    @Transient
    private String roleName;

    /**
     * 多个主键
     */
    @ApiModelProperty("主键集")
    @Transient
    private String[] ids;

    /**
     * 权限集合
     */
    @ApiModelProperty("权限集合")
    @Transient
    private Set<String> authIds;


    /**
     * 旧密码
     */
    @ApiModelProperty("旧密码")
    @Transient
    private String oldPassword;

    @ApiModelProperty("父级Id")
    @Transient
    private List<String> projectIds;

    @ApiModelProperty("当前时间戳")
    @Transient
    private String timestamp;

    @ApiModelProperty("项目id-单元测试用")
    @Transient
    private String projectId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

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
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取姓名
     *
     * @return real_name - 姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置姓名
     *
     * @param realName 姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取联系电话
     *
     * @return tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取项目id
     *
     * @return pro_id - 项目id
     */
    public String getProId() {
        return proId;
    }

    /**
     * 设置项目id
     *
     * @param proId 项目id
     */
    public void setProId(String proId) {
        this.proId = proId;
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
     * 获取状态( 0-启用 1-禁用)
     *
     * @return status - 状态( 0-启用 1-禁用)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态( 0-启用 1-禁用)
     *
     * @param status 状态( 0-启用 1-禁用)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取最后登录时间
     *
     * @return lastlogin_time - 最后登录时间
     */
    public Date getLastloginTime() {
        return lastloginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastloginTime 最后登录时间
     */
    public void setLastloginTime(Date lastloginTime) {
        this.lastloginTime = lastloginTime;
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
     * 获取是否绑定到项目，0-未绑定，1-已绑定，项目管理员
     *
     * @return isbind - 是否绑定到项目，0-未绑定，1-已绑定，项目管理员
     */
    public Integer getIsbind() {
        return isbind;
    }

    /**
     * 设置是否绑定到项目，0-未绑定，1-已绑定，项目管理员
     *
     * @param isbind 是否绑定到项目，0-未绑定，1-已绑定，项目管理员
     */
    public void setIsbind(Integer isbind) {
        this.isbind = isbind;
    }

    /**
     * 获取创建人
     *
     * @return self_id - 创建人
     */
    public String getSelfId() {
        return selfId;
    }

    /**
     * 设置创建人
     *
     * @param selfId 创建人
     */
    public void setSelfId(String selfId) {
        this.selfId = selfId;
    }

    /**
     * 获取是否删除标识，0-正常，1-删除
     *
     * @return del_flag - 是否删除标识，0-正常，1-删除
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置是否删除标识，0-正常，1-删除
     *
     * @param delFlag 是否删除标识，0-正常，1-删除
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String[] getDeviceCodes() {
        return deviceCodes;
    }

    public void setDeviceCodes(String[] deviceCodes) {
        this.deviceCodes = deviceCodes;
    }

    public String[] getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(String[] deviceIds) {
        this.deviceIds = deviceIds;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<String> getAuthIds() {
        return authIds;
    }

    public void setAuthIds(Set<String> authIds) {
        this.authIds = authIds;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public List<String> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<String> projectIds) {
        this.projectIds = projectIds;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {

        this.timestamp = timestamp;
    }
}
