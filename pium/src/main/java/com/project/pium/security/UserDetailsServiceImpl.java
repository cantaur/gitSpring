package com.project.pium.security;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.project.pium.domain.Member;
import com.project.pium.mapper.MemberMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDetailsService 인터페이스를 구현하는 클래스
 * 이곳에서 최종적으로 security context 객체인, UserDetails 를 반환해야한다.
 */


@Log
@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private MemberMapper memberMapper;
    private SqlSession sqlSession;

    public UserDetailsServiceImpl() {

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //email 유효성검사 로직 들어가야함
        Member member = sqlSession.selectOne(username,"com.project.pium.domain.Member.userdetails");
        log.info("#member"+member);
        if(member==null) throw new UsernameNotFoundException(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority role = new SimpleGrantedAuthority("ROLE_USER");
        authorities.add(role);

        return new User(member.getMember_email(),member.getMember_pw(),authorities);
    }
}
