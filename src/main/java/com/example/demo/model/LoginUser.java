package com.example.demo.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class LoginUser extends User {

    private String name;

    public LoginUser(String userId, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userId, password, authorities);
    }

    public LoginUser(String userId, String password, String name, Collection<? extends GrantedAuthority> authorities) {
        this(userId, password, authorities);
        this.name = name;
    }
}
