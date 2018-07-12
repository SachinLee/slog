package com.sachin.slog.vo;

import com.google.common.collect.Lists;
import com.sachin.slog.pojo.Menu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单展示，对应前端的json要求
 */
@Data
public class MenuVo implements Serializable {

    private String id;

    private String title;

    private String icon;

    private String href;

    private boolean spread;

    private List<MenuVo> children = Lists.newArrayList();

}
