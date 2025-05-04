package com.example.bachelorprojectjava.handlers;

import com.example.bachelorprojectjava.exceptions.BadRequestException;
import com.example.bachelorprojectjava.models.User;
import com.example.bachelorprojectjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @HandleBeforeCreate
    public void handleUserBeforeCreate(User user) {
        checkUniqueConstraints(user);
        user.setEnabled(true);
    }

    @HandleBeforeSave
    public void handleUserBeforeSave(User user) {
        String oldUserEmail = userRepository.findById(user.getId()).get().getEmail();
        String oldUsername = userRepository.findById(user.getId()).get().getUsername();
        if (!oldUserEmail.equals(user.getEmail()) || !oldUsername.equals(user.getUsername())) {
            checkUniqueConstraints(user);
        }
        user.setEnabled(true);
    }

    private void checkUniqueConstraints(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("This email address already exists");
        }
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new BadRequestException("Username already exists");
        }
    }
}
