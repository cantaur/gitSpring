package com.project.pium.security;

import com.project.pium.security.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //유저 인증정보를 설정 할 수 있다.
        //이곳에서 jdbc 에 인증정보를 연결한다.
        //super.configure(auth);
        /**


        auth.inMemoryAuthentication()
                .withUser("user")//user 계정 생성(==로그인 ID)
                .password(passwordEncoder().encode("1234")) //passwordEncoder로 등록한 인코더로 1234를 암호화한다.
                .roles("USER"); //유저에게 USER라는 역할을 제공한다.
        */

        auth
                .userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

        log.info("#auth"+auth);
        log.info("userDetailsService"+userDetailsService.getClass());

    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }



    @Override
    public void configure(WebSecurity web) throws Exception {
        //security 전역 설정을 할 수 있다.
        // 밑에 HttpSecurity 보다 우선시 되며, static 파일 (css, js 같은) 인증이 필요없는 리소스는 이곳에서 설정 할 수 있다.
        //super.configure(web);
        web.ignoring().antMatchers("/css", "/js");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //resource 보안 부분
        //super.configure(http);
        http.authorizeRequests() //권한요청 처리 설정 메소드
                .antMatchers("/private/**").hasAnyRole("USER") //private 이하의 모든 요청은 USER 역할을 갖는다.
                .anyRequest().permitAll() //다른 요청은 누구든지 접근 할 수 있다.
                .and()
                .formLogin()
                .loginPage("/login") //.formLogin() 의 .loginPage() 메소드 : security는 더이상 기본으로 제공하는 페이지를 보여주지 않고, 개발자가 설정한 컨트롤러로 바인딩한다.
                .usernameParameter("username") // username parameter
                .passwordParameter("password"); // password parameter

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //PasswordEncoder 설정
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
