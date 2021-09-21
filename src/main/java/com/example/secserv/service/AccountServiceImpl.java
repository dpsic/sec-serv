package com.example.secserv.service;

import com.example.secserv.entites.AppRole;
import com.example.secserv.entites.AppUser;
import com.example.secserv.repo.AppRoleRepo;
import com.example.secserv.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppRoleRepo appRoleRepo;
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
PasswordEncoder passwordEncoder;
    @Override
    public AppUser addNewUser(AppUser appUser) {
String pw =appUser.getPassword();
appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepo.save(appUser);

    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepo.save(appRole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
AppUser appUser=appUserRepo.findByUserName(userName);
AppRole appRole=appRoleRepo.findByRoleName(roleName);
appUser.getAppRoles().add(appRole);

    }

    @Override
    public AppUser findUserByUserName(String userName) {

        return appUserRepo.findByUserName(userName);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepo.findAll();

    }
    @Override
    public List<AppRole> listRoles() {
        return appRoleRepo.findAll();

    }


}
