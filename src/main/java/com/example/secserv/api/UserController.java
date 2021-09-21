package com.example.secserv.api;


import com.example.secserv.entites.AppUser;
import com.example.secserv.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private AccountService accountService;
 @PostMapping()
    public AppUser addUser(@RequestBody  AppUser appUser) {

       return accountService.addNewUser(appUser);
   }
    @GetMapping()
    public List<AppUser> appUsers(){

       return  accountService.listUsers();
    }
    @PostMapping("/add")
    public void addRoleToUser( @RequestBody  RoleUserForm roleUserForm){

 accountService.addRoleToUser(roleUserForm.getUserName(),roleUserForm.getRoleName());
    }}
@Data
class RoleUserForm{
    private String UserName;
    private String RoleName;
}




