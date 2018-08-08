package org.chinaos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable, UserDetails {
    private Integer id;

    private String email;

    private String username;

    private String password;

    /**
     * 设置true启用用户
     */
    private String enable;

    /**
     * 设置true用户账户未过期
     */
    private String account;

    /**
     * 设置true凭证尚未过期
     */
    private String credentials;

    /**
     * 设置true账户未锁定
     */
    private String locked;

    private Date createTime;

    private Date lastTime;

    private String salt;

    private List<Role> roles;

    /**
     * 自定义标识
     */
    private final String mySalt = "evy_salt:";

    /**
     * 注册时可使用该构造函数初始化数值
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.username = email;
        this.email = email;
        this.password = password;
        this.enable = Boolean.TRUE.toString();
        this.account = Boolean.TRUE.toString();
        this.credentials = Boolean.TRUE.toString();
        this.locked = Boolean.TRUE.toString();
        this.createTime = new Date();
        this.salt = this.username;
    }

    /**
     * 获取标识盐
     * @return
     */
    public String getCredentialsSalt(){
        return mySalt + salt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
        }
        return authorities;
    }

    /**
     * 帐户未过期
     **/
    @Override
    public boolean isAccountNonExpired() {
        return Boolean.valueOf(this.account);
    }
    /**
     * 是帐户非锁定
     **/
    @Override
    public boolean isAccountNonLocked() {
        return Boolean.valueOf(this.locked);
    }
    /**
     * 凭证
     **/
    @Override
    public boolean isCredentialsNonExpired() {
        return Boolean.valueOf(this.credentials);
    }
    /**
     * 是否启用
     **/
    @Override
    public boolean isEnabled() {
        return Boolean.valueOf(this.enable);
    }
}