package com.example.secserv.service;

import com.example.secserv.entites.AppRole;
import com.example.secserv.entites.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole (AppRole appRole);
    void addRoleToUser(String userName,String roleName);

    List<AppUser> listUsers();

    AppUser findUserByUserName(String UserName);
}
