package com.project.pium.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private String member_email;
    private String member_pw;
    private String member_platform;


    public CustomUserDetails(String username, String password,
                             boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                             Collection<? extends GrantedAuthority> authorities, String platform) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.member_email = username;
        this.member_pw = password;
        this.member_platform = platform;
    }



    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getMember_platform() {
        return member_platform;
    }

    public void setMember_platform(String member_platform) {
        this.member_platform = member_platform;
    }
}
