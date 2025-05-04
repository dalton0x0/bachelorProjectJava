package com.example.bachelorprojectjava.repositories;

import com.example.bachelorprojectjava.enums.RoleType;
import com.example.bachelorprojectjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
    User findByRole_RoleType(RoleType roleRoleType);
    List<User> findByEnabled(boolean enabled);
}
