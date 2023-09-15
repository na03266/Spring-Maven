package com.example.demo.service;

import com.example.demo.enums.UserRole;
import com.example.demo.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        // username으로 USER DB 조회


        List<GrantedAuthority> authorities = new ArrayList<>();

        /*롤 어드민에 해당하는 한국어는 뭐야!*/
//        UserRole.findBy("ROLE_ADMIN").getValuekor(); //관리자

        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        return new LoginUser(username, passwordEncoder.encode("1234"),"사용자이름", authorities);

    }
}
