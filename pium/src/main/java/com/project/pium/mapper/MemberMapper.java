package com.project.pium.mapper;

import com.project.pium.domain.SignDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {
    List<SignDTO> list();
    void insert(SignDTO member);
    String selectByEmail (String member_email);
}
