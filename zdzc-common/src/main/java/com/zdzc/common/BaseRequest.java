package com.zdzc.common;

import java.io.Serializable;

public class BaseRequest implements Serializable {
    /**
     * 页数
     */
    private Integer pageNo = 1;

    /**
     * 每页展示条数
     */
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
