package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            ArrayList<UserDB> userList = new ArrayList<>();
            UserDB user1 = new UserDB(
                    "Franco Folatelli",
                    LocalDate.of(1996, Month.JUNE, 13),
                    "franco.folatelli@hotmail.com"
            );
            userList.add(user1);
            UserDB user2 = new UserDB(
                    "Agustina Chianetta",
                    LocalDate.of(1992, Month.NOVEMBER, 26),
                    "aguschianetta@gmail.com"
            );
            userList.add(user2);
            userRepository.saveAll(userList);
        };
    }
}
