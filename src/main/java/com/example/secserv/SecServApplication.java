package com.example.secserv;

import com.example.secserv.entites.AppRole;
import com.example.secserv.entites.AppUser;
import com.example.secserv.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecServApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServApplication.class, args);
    }
 @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
@Bean
    CommandLineRunner start(AccountService accountService){

        return args -> {
         accountService.addNewRole(new AppRole(null,"user"));
            accountService.addNewRole(new AppRole(null,"admin"));
            accountService.addNewRole(new AppRole(null,"customer_manager"));
            accountService.addNewRole(new AppRole(null,"produtc_manager"));


        accountService.addNewUser(new AppUser(null,"user1","1234",new ArrayList<>()));
        accountService.addNewUser(new AppUser(null,"admin","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user2","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"nouhaila","1234",new ArrayList<>()));

          accountService.addRoleToUser("user1","user");
            accountService.addRoleToUser("admin","user");
            accountService.addRoleToUser("admin","admin");
        };
    }
}
