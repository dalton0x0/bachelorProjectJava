package com.example.bachelorprojectjava.validators;

import com.example.bachelorprojectjava.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    static String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", "firstname.required", "Firstname is required");
        }
        if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", "lastname.required", "Lastname is required");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty() || !EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            errors.rejectValue("email", "email.required", "Email is required");
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            errors.rejectValue("username", "username.required", "Username is required");
        }
        if (user.getUsername().length() < 3) {
            errors.rejectValue("username", "username.required", "Username must be at least 8 characters long");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            errors.rejectValue("password", "password.required", "Password is required");
        }
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "Password.required", "Password must be at least 8 characters long");
        }
    }
}
