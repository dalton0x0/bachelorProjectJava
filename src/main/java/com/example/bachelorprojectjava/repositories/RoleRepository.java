package com.example.bachelorprojectjava.repositories;

import com.example.bachelorprojectjava.enums.RoleType;
import com.example.bachelorprojectjava.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByRoleType(RoleType roleType);
}
