package com.project.pium.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignDTO {
    private long member_seq;
    private String member_email;
    private String member_pw;
    private String member_platform;
    private String authority;


}
