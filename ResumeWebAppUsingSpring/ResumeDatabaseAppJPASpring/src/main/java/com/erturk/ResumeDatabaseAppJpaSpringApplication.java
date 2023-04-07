package com.erturk;

import com.erturk.dao.impl.UserDaoImpl;
import com.erturk.dao.inter.UserDaoInter;
import com.erturk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeDatabaseAppJpaSpringApplication {
    @Autowired
    @Qualifier("userDao")
    private UserDaoInter userDao;

    public static void main(String[] args) {
        SpringApplication.run(ResumeDatabaseAppJpaSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<User> list = userDao.getAll();
                System.out.println(list);
            }
        };
        return clr;
    }
}
