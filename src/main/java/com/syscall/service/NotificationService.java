package com.syscall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by harley on 06/06/2017.
 */

@Service
public class NotificationService {
    @Autowired
    private ConfigurableApplicationContext c;

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public SimpleMailMessage sendNotification(Map<String,String> object) throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(object.get("to"));
        mail.setFrom(c.getEnvironment().getProperty("spring.mail.username"));
        mail.setSubject(object.get("subject"));
        mail.setText(object.get("text"));
        javaMailSender.send(mail);
        return mail;
    }


    public SimpleMailMessage sendNotification(SimpleMailMessage mail) throws MailException {
        javaMailSender.send(mail);
        return mail;
    }

}