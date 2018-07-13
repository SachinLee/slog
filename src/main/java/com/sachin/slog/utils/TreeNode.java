package com.sachin.slog.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class TreeNode implements Serializable {

    private String id;

    private String pid;

    private String name;

    private String href;

    private Integer open = 0; //是否展开

    private Integer isParent = 1;
}
