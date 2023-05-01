package com.mailer.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mailer.app.services.MailerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner {
    private MailerService mailerService;
    
    @Autowired
    private void setMailerService(MailerService mailerService){
        this.mailerService = mailerService;
    }

    public static void main(String args[]) {
        // SpringApplication.run(App.class, args).close();
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        mailerService.sendSimpleMail();
    }
}
