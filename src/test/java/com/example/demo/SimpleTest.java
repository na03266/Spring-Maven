package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest //스프링에서 제공하는 애너테이션을 사용하여 테스트하고싶을때 사용
public class SimpleTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void someTest(){
        System.out.println("테스트 코드 돌려");
    }
}
