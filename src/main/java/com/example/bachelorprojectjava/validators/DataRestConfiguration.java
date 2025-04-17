package com.example.bachelorprojectjava.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class DataRestConfiguration implements RepositoryRestConfigurer {

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private RoleValidator roleValidator;

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
        v.addValidator("beforeCreate", userValidator);
        v.addValidator("beforeSave", userValidator);

        v.addValidator("beforeCreate", roleValidator);
        v.addValidator("beforeSave", roleValidator);
    }
}
