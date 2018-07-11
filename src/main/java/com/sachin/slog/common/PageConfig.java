package com.sachin.slog.common;

import java.io.Serializable;

public class PageConfig implements Serializable {

    private static final int DEFAULT_PAGESIZE = 10;

    private long rowCount;

    private int pageSize = DEFAULT_PAGESIZE;

    private int pageNum = 1;

    private int pageCount;

    private String orderBy;

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowCount() {
        return this.rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        int count = Integer.valueOf(String.valueOf(this.rowCount/pageSize));
        return this.rowCount%pageSize==0L?count:count+1;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getFirst(){
        return (pageNum - 1) * pageSize;
    }

}
