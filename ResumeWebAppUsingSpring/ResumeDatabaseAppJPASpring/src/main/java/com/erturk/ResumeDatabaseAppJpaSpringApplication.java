package com.erturk;

import com.erturk.dao.inter.UserRepository;
import com.erturk.entity.User;
import com.erturk.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeDatabaseAppJpaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumeDatabaseAppJpaSpringApplication.class, args);
    }
    // DI - Dependency Injection
    // IoC - Inversion of Control

    @Autowired
    @Qualifier("userService")
    private UserServiceInter userService;

    @Autowired
    private UserRepository userRepository;
    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("JPA app started!");
//                List<User> list = userRepository.findBySurname("Məmmədli");
//                for (User u: list) System.out.println(u.getName());
//                List<User> users = userService.getAll();
//                for(User u: users) {u.setPassword("12345"); userService.updateUser(u);}
            }
        };
        return clr;
    }
}
