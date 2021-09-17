package com.example.secserv.api;

import com.example.secserv.entites.AppUser;
import com.example.secserv.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api1/users")
public class UserController {
    @Autowired
    private AccountService accountService;
   @PostMapping()
    public AppUser addUser(AppUser appUser) {
       return accountService.addNewUser(appUser);
   }
    @GetMapping()
    public List<AppUser> appUsers(){

       return  accountService.listUsers();
    }

}
