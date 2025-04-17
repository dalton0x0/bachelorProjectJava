package com.example.bachelorprojectjava.handlers;

import com.example.bachelorprojectjava.models.Role;
import com.example.bachelorprojectjava.models.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class RoleHandler {

    @HandleBeforeCreate
    public void handleRoleBeforeCreate(Role role) {
    }

    @HandleBeforeDelete
    public void handleRoleBeforeDelete(Role role) {
        if (!role.getUsers().isEmpty()) {
            throw new RuntimeException("Role cannot be deleted because it is assigned to a user");
        }
    }

    @HandleBeforeLinkSave
    public void handleRoleBeforeLinkSave(User user, Role role) {
        if (role.getUsers().contains(user)) {
            throw new RuntimeException("User cannot be assigned to a role that already has the user");
        }
    }
}
