package com.sachin.slog.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "slog_menu")
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", length = 50)
    private String id;

    @NotNull(message = "菜单名称不能为空")
    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description", length = 200)
    private String description; //描述

    @Column(name = "level", length = 10)
    private Integer level; //菜单等级

    @Column(name = "href", length = 200)
    private String href; //菜单路径

    @Column(name = "pid", length = 50)
    private String pid;

    @Column(name = "key_word", length = 100)
    private String keyWord; //适应前台模板的需求

    @Column(name = "spread")
    private boolean spread = false;

    @Column(name = "icon", length = 100)
    private String icon;
}
