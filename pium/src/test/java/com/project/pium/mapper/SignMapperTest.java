package com.project.pium.mapper;

import com.project.pium.domain.SignDTO;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.context.web.WebAppConfiguration;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration
@Log
class SignMapperTest {
    @Autowired
    SignMapper signMapper;

    @Test
    void signup() {
        SignDTO signDTO = new SignDTO(-1,"attackmood@gmail.com","1234",null,"user");
        signMapper.signup(signDTO);
        log.info("signup Test 완료");

    }

    @Test
    void emailCheck() {
    }

    @Test
    void emailAuth() {
    }

    @Test
    void verification() {
    }
}