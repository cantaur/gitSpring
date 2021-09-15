package com.project.pium.mapper;


import com.project.pium.domain.SignDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SignMapper {
    String signup(SignDTO signDTO); //회원가입
    int emailCheck(String mEmail);
    void emailAuth(String mEmail, String uuid);
    int verification(String mEmail, String uuid);
}
