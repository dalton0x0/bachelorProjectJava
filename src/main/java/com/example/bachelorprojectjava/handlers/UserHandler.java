package com.example.bachelorprojectjava.handlers;

import com.example.bachelorprojectjava.models.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class UserHandler {

    @HandleBeforeCreate
    public void handleUserBeforeCreate(User user) {
        user.setEnabled(true);
    }

    @HandleBeforeSave
    public void handleUserBeforeSave(User user) {
        user.setEnabled(true);
    }
}
