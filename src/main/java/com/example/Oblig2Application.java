package com.example;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oblig2Application implements CommandLineRunner {

    @Autowired
    UserService service;

    public static void main(String[] args) {
        SpringApplication.run(Oblig2Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        service.deleteAll();
        User user = new User("demo", "demo", "ADMIN");
        service.save(user);
    }
}
