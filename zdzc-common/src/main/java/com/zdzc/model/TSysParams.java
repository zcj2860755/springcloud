package com.zdzc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "t_sys_params")
@ApiModel
public class TSysParams {

    @Id
    @ApiModelProperty("主键")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ApiModelProperty("参数名称")
    @Column(name = "params_name")
    private String paramsName;

    @ApiModelProperty("参数key")
    @Column(name = "params_key")
    private String paramsKey;

    @ApiModelProperty("参数值")
    @Column(name = "params_value")
    private String paramsValue;

    @ApiModelProperty("备注")
    private String remark;

    /**
     * 关键字
     */
    @Transient
    private String keyWord;

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
     * 获取参数名称
     *
     * @return params_name - 参数名称
     */
    public String getParamsName() {
        return paramsName;
    }

    /**
     * 设置参数名称
     *
     * @param paramsName 参数名称
     */
    public void setParamsName(String paramsName) {
        this.paramsName = paramsName;
    }

    /**
     * 获取参数key
     *
     * @return params_key - 参数key
     */
    public String getParamsKey() {
        return paramsKey;
    }

    /**
     * 设置参数key
     *
     * @param paramsKey 参数key
     */
    public void setParamsKey(String paramsKey) {
        this.paramsKey = paramsKey;
    }

    /**
     * 获取参数值
     *
     * @return params_value - 参数值
     */
    public String getParamsValue() {
        return paramsValue;
    }

    /**
     * 设置参数值
     *
     * @param paramsValue 参数值
     */
    public void setParamsValue(String paramsValue) {
        this.paramsValue = paramsValue;
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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
