package com.example.bachelorprojectjava.validators;

import com.example.bachelorprojectjava.models.Classroom;
import com.example.bachelorprojectjava.models.Role;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ClassroomValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Classroom.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Classroom classroom = (Classroom) target;

        if (classroom.getName() == null || classroom.getName().trim().isEmpty()) {
            errors.rejectValue("name", "name.required", "Name is required");
        }
    }
}
