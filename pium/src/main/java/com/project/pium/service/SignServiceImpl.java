//package com.project.pium.service;
//
//import com.project.pium.domain.SignDTO;
//import com.project.pium.email.MailHandler;
//import com.project.pium.mapper.SignMapper;
//import lombok.AllArgsConstructor;
//import lombok.extern.java.Log;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Log
//
//@Service
//public class SignServiceImpl implements SignService {
//    @Autowired
//    private SignMapper signMapper;
//    @Autowired
//    private JavaMailSender mailSender;
//
//
//    @Override
//    public String signupS(SignDTO signDTO) {
//        return signMapper.signup(signDTO);
//    }
//
//    @Override
//    public int emailCheckS(String mEmail) {
//        return signMapper.emailCheck(mEmail);
//    }
//
//    @Transactional
//    @Override
//    public void emailAuthS(String mEmail, String uuid) {
//        signMapper.emailAuth(mEmail,uuid);
//        try {
//            MailHandler sendMail = new MailHandler(mailSender);
//            sendMail.setSubject("이메일 인증 메일입니다");
//            sendMail.setText(new StringBuffer()
//                    .append("<div style='max-width: 750px; padding: 30px; border-radius: 3px; text-align: left;'>")
//                    .append("<p><font size='6px' color='#565a5c'><strong>이메일 인증을 위한<br>링크 주소입니다.</strong></font></p>")
//                    .append("<hr style='margin-top: 30px; margin-bottom: 50px;'>")
//                    .append("<div style='border: 1px solid #ced1cc; padding: 10px;'><h3><font color='#565a5c'>해당 <a href='https://localhost:8000/verification/" + mEmail + "/" + uuid + "' target='_blank' style='text-decoration: none;'>링크</a>를 클릭하시면 인증 절차가 완료됩니다.</font></h3></div>")
//                    .append("<hr style='margin-top: 50px; margin-bottom: 30px;'></div>")
//                    .toString());
//            sendMail.setFrom("atackmood@gmail.com", "Pium");
//            sendMail.setTo(mEmail);
//            sendMail.send();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public int verificationS(String mEmail, String uuid) {
//        return signMapper.verification(mEmail,uuid);
//    }
//}
