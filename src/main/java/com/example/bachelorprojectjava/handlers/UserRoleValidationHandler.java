package com.example.bachelorprojectjava.handlers;

import com.example.bachelorprojectjava.enums.RoleType;
import com.example.bachelorprojectjava.models.Role;
import com.example.bachelorprojectjava.models.User;
import com.example.bachelorprojectjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class UserRoleValidationHandler {

    @Autowired
    UserRepository userRepository;

    @EventListener
    public void handleBeforeSave(BeforeSaveEvent event) {
        Object entity = event.getSource();

        if (entity instanceof User updatedUser && updatedUser.getId() != null) {
            userRepository.findById(updatedUser.getId()).ifPresent(existingUser -> {
                Role oldRole = existingUser.getRole();
                Role newRole = updatedUser.getRole();

                if (oldRole != newRole) {
                    boolean isAdmin = oldRole.getRoleType() == RoleType.ADMIN || newRole.getRoleType() == RoleType.ADMIN;

                    if (!isAdmin) {
                        throw new RuntimeException("Only admin can change user roles");
                    }
                }
            });
        }
    }
}
