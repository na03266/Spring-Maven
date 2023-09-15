package com.example.demo.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class LoginUser extends User {

    private String nickName;
    private String email;

    public LoginUser(String userId, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userId, password, authorities);
    }

    public LoginUser(String userId, String password, String nickName, Collection<? extends GrantedAuthority> authorities) {
        this(userId, password, authorities);
        this.nickName = nickName;
    }

    public LoginUser(UserModel user, Collection<? extends GrantedAuthority> authorities) {
        this(user.getUserId(), user.getPassword(), authorities);
        this.nickName = user.getUserName();
        this.email = user.getEmail();
    }
}
