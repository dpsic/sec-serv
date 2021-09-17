package com.example.secserv.api;

import com.example.secserv.entites.AppRole;
import com.example.secserv.entites.AppUser;
import com.example.secserv.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
        @Autowired
        private AccountService accountService;

        @PostMapping()
        public AppRole addRole(AppRole appRole){
            return accountService.addNewRole(appRole);
        }


    }
