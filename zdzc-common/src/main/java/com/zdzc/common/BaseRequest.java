package com.zdzc.common;

import javax.persistence.Transient;
import java.io.Serializable;

public class BaseRequest implements Serializable {
    /**
     * 页数
     */
    @Transient
    private Integer pageNo = 1;

    /**
     * 每页展示条数
     */
    @Transient
    private Integer pageSize = 20;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if(pageNo!=null && pageNo>0){
            this.pageNo = pageNo;
        }else{
            this.pageNo=1;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        //pageSize为0查询全部数据
        if(pageSize!=null && pageSize>=0){
            this.pageSize = pageSize;
        }else{
            this.pageSize=20;
        }
    }
}
