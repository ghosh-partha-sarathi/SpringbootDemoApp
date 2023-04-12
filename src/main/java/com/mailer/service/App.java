package com.mailer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String args[]){
        ApplicationContext appContext = SpringApplication.run(App.class, args);
    }
}
