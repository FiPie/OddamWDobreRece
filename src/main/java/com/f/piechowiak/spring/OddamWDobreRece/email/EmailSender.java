package com.f.piechowiak.spring.OddamWDobreRece.email;

public interface EmailSender {

    void sendEmail(String to, String subject, String content);

}
