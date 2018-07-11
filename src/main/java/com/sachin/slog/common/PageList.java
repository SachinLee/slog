package com.sachin.slog.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageList<T> implements Serializable {

    private List<T> resultList;

    private PageConfig pageConfig;

    public PageList(List<T> resultList, PageConfig pageConfig) {
        this.resultList = resultList;
        this.pageConfig = pageConfig;
    }
}
