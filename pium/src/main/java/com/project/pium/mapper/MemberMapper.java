package com.project.pium.mapper;

import com.project.pium.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {
    List<Member> list();
    void insert(Member member);
    String selectByEmail (String member_email);
}
