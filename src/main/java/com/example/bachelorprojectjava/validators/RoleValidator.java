package com.example.bachelorprojectjava.validators;

import com.example.bachelorprojectjava.models.Role;
import com.example.bachelorprojectjava.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RoleValidator implements Validator {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Role.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Role role = (Role) target;

        if (role.getLabel() == null || role.getLabel().trim().isEmpty()) {
            errors.rejectValue("label", "label.required", "Label is required");
        }
        if (role.getRoleType() == null) {
            errors.rejectValue("roleType", "roleType.required", "Role type is required");
        }
        if (roleRepository.existsByRoleType(role.getRoleType())) {
            errors.rejectValue("roleType", "roleType.exists", "Role type already exists");
        }
    }
}
