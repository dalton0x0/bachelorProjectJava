package com.example.bachelorprojectjava.handlers;

import com.example.bachelorprojectjava.models.Role;
import com.example.bachelorprojectjava.models.User;
import com.example.bachelorprojectjava.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class UserHandler {

    @Autowired
    RoleRepository roleRepository;

    @HandleBeforeCreate
    public void handleUserBeforeCreate(User user) {
        user.setEnabled(true);
        validateAndAssignRole(user);
    }

    @HandleBeforeSave
    public void handleUserBeforeSave(User user) {
        validateAndAssignRole(user);
    }

    private void validateAndAssignRole(User user) {
        if (user.getRole() == null) {
            throw new RuntimeException("User must be assigned a role");
        }

        Role role = roleRepository.findById(user.getRole().getId()).orElseThrow(
                () -> new RuntimeException("Role not found")
        );
        user.setRole(role);
    }
}
