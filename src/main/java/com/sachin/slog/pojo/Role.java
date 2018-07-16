package com.sachin.slog.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 角色实体类
 *
 * @author sachin
 * @create 2018-07-12 21:11
 */
@Data
@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @NotNull(message = "角色编码不能为空")
    @Column(name = "role_no", length = 50)
    private String roleNo; //角色编码

    @NotNull(message = "角色名称不能为空")
    @Column(name = "name", length = 100)
    private String name;
}
