package com.sachin.slog.pojo;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户实体类
 */
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", length = 50)
    private String id;

    @NotBlank(message = "账号不能为空")
    @Column(name = "login", length = 50)
    private String login; // 账号

    @NotBlank(message = "昵称不能为空")
    @Column(name = "username")
    private String username; // 姓名

    @NotBlank(message = "密码不能为空")
    @Column(name = "password", length = 50)
    private String password; //密码

    @Email(message = "邮箱格式错误")
    @Column(name = "email")
    private String email; //邮箱

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    @Column(name = "last_login")
    private Timestamp lastLogin; // 上次登录时间
}
