package com.example.bachelorprojectjava.repositories;

import com.example.bachelorprojectjava.enums.RoleType;
import com.example.bachelorprojectjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
    User findByRole_RoleType(RoleType roleRoleType);
    List<User> findByEnabled(boolean enabled);
}
