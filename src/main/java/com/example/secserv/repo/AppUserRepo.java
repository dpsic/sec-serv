package com.example.secserv.repo;

import com.example.secserv.entites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String username);
}
