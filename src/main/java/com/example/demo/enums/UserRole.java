package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

@Getter
@AllArgsConstructor /*생성자를 자동으로 생성해줌*/
public enum UserRole {/*리스트를 배열식으로 표현*/
    ADMIN("ROLE_ADMIN", "관리자"),
    USER("ROLE_USER", "회원");

    private String value;
    private String valueKor;

    public  static UserRole findBy(String v) {
        for (UserRole r : UserRole.values()) {
            if (StringUtils.equals(r.getValue(), v)) {
                return  r;
            }
        }

        return UserRole.USER;
    }
}
