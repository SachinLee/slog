package com.sachin.slog.config;

import com.sachin.slog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security配置类
 *
 * @author sachin
 * @create 2018-07-29 10:38
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 创建PasswordEncode的Bean
     * @return 返回BCryptPasswordEncoder对象
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable(); // iframe加载 'X-Frame-Options' to 'deny' 问题
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/imageges/**", "/layui/**", "/ztree/**")
                .permitAll() // 静态资源都可以访问
                //.antMatchers("/admin/**").hasRole("ADMIN") //管理才能访问
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login-error")
                .and().logout().logoutUrl("/logout")
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    /**
     * 用户认证
     * @param builder 权限信息
     * @throws Exception 异常
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userService);
        builder.authenticationProvider(authenticationProvider());
    }

    /**
     * 认证方式
     * @return 返回authenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
}
