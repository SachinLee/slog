package com.sachin.slog.vo;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * securityUser对象
 *
 * @author sachin
 * @create 2018-07-29 19:13
 */
@Data
public class SecurityUser implements UserDetails {

    private String id;

    private String username;

    private String password;

    private List<GrantedAuthority> authorities;

    public SecurityUser(String id, String username, String password, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() { // 未过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 未锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //
        return true;
    }

    @Override
    public boolean isEnabled() { // 账号是否可用
        return true;
    }
}
