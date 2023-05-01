package com.mailer.app.services;

import com.mailer.app.config.MailConfig;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MailerService {
    private MailConfig mailConfig;

    public String sendSimpleMail()
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("partha187@gmail.com");
            mailMessage.setTo("spiderman@endtest-mail.io");
            mailMessage.setText("This is a test mail");
            mailMessage.setSubject("HELLO WORLD");
 
            JavaMailSender mailSender = mailConfig.getMailSender();
            mailSender.send(mailMessage);
            log.info("[[ Mail sent SUCCESSFULLY...]]");
            return "Mail Sent Successfully...";
        } catch (Exception exp) {
            log.error("[[ ERROR while sending mail... ]]", exp);
            return "Error while Sending Mail";
        }
    }
}
