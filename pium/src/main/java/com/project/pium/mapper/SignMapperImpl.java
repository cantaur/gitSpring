package com.project.pium.mapper;

import com.project.pium.domain.SignDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SignMapperImpl implements SignMapper {

    @Autowired
    private SqlSession sqlSession;
    private String ns_sign = "com.project.pium.domain.SignDTO";


    @Override
    public String signup(SignDTO signDTO) {
        int check = sqlSession.selectOne(ns_sign+".userEmail_check", signDTO);
        if(signDTO.getMember_platform().equals("PIUM")){
            if(check==0){
                sqlSession.insert(ns_sign+".signup", signDTO);
                return "PIUM";
            }else{
                return "duplicated";
            }
        }else{
            if(check==0){
                sqlSession.insert(ns_sign+".signup", signDTO);
            }
            if(signDTO.getMember_platform().equals("NAVER")){
                return "NAVER";
            }else if(signDTO.getMember_platform().equals("KAKAO")){
                return "KAKAO";
            }
        }
        return null;
    }

    @Override
    public int emailCheck(String mEmail) {
        if((int)sqlSession.selectOne(ns_sign + ".email_check", mEmail) != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public void emailAuth(String mEmail, String uuid) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("userEmail", mEmail);
        params.put("uuid", uuid);

        sqlSession.insert(ns_sign + ".email_auth", params);

    }

    @Override
    public int verification(String mEmail, String uuid) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("userEmail", mEmail);
        params.put("uuid", uuid);

        return sqlSession.update(ns_sign + ".verification", params);
    }
}
