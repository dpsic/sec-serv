package com.example.secserv.repo;

import com.example.secserv.entites.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
