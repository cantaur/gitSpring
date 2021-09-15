package com.project.pium.security;

import com.project.pium.domain.SignDTO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SqlSession sqlSession;

    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    public CustomUserDetailsService(){}
    public CustomUserDetailsService(SqlSessionTemplate sqlSession){
        this.sqlSession=sqlSession;
    }

    @Override
    public UserDetails loadUserByUsername(String mEmail) throws UsernameNotFoundException, DisabledException {
        SignDTO signDTO = sqlSession.selectOne("com.project.pium.domain.SignDTO.userdetails", mEmail);
        if(signDTO == null) throw new UsernameNotFoundException(mEmail);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new CustomUserDetails(signDTO.getMember_email()
                ,signDTO.getMember_pw()
                ,enabled, accountNonExpired, credentialsNonExpired, accountNonLocked
                ,authorities
                ,signDTO.getMember_platform()
        );
    }
}
