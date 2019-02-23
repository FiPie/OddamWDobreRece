package com.f.piechowiak.spring.OddamWDobreRece.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper( mail, true );
            helper.setTo( to );
            helper.setReplyTo( "applicationtestsender@gmail.com" );
            helper.setFrom( "applicationtestsender@gmail.com" );
            helper.setSubject( subject );
            helper.setText( content, true );


        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send( mail );
    }
}
