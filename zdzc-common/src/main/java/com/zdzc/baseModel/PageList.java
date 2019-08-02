package com.zdzc.baseModel;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 分页包装类
 */

public class PageList<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageNo;

    private int pageSize;

    //由于startRow和endRow不常用，这里说个具体的用法
    //可以在页面中"显示startRow到endRow 共size条数据"

    private long totalCount;

    private int totalPages;

    private List<T> list;

    public PageList() {
    }

    /**
     * 包装Page对象
     *
     * @param list          page结果
     */
    public PageList(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNo = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.totalPages = page.getPages();
            this.list = page;

            this.totalCount = page.getTotal();
            //由于结果是>startRow的，所以实际的需要+1
        } else if (list instanceof Collection) {
            this.pageNo = 1;
            this.pageSize = list.size();

            this.totalPages = 1;
            this.list = list;
            this.totalCount = list.size();
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
