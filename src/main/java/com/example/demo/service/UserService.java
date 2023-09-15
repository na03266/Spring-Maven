package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void insertUser(UserModel user) {
        // 회원 가입 시 가공할 데이터는 여기에서 처리한다.

        // 패스워드 암호화
        encryptPassword(user);

        userDAO.insertUser(user);
    }

    private void encryptPassword(UserModel user) {
        String encodedPw = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPw);
    }

    public UserModel selectUserByUserId(String userId) {
        return userDAO.selectUser(userId);
    }
}
