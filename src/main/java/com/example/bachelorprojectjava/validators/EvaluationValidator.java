package com.example.bachelorprojectjava.validators;

import com.example.bachelorprojectjava.models.Evaluation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EvaluationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Evaluation.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Evaluation evaluation = (Evaluation) target;

        if (evaluation.getTitle() == null || evaluation.getTitle().trim().isEmpty()) {
            errors.rejectValue("title", "title.required", "Title is required");
        }
        if (evaluation.getDescription() == null || evaluation.getDescription().trim().isEmpty()) {
            errors.rejectValue("description", "description.required", "Description is required");
        }
        if (evaluation.getMinValue() < 0 || evaluation.getMaxValue() < 0) {
            errors.rejectValue("minValue", "minValue.required", "Min value must be a positive number");
            errors.rejectValue("maxValue", "maxValue.required", "Max value must be a positive number");
        }
        if (evaluation.getMinValue() > evaluation.getMaxValue()) {
            errors.rejectValue("minValue", "minValue.greaterThanMaxValue", "Min value must be greater than max value");
        }
        if (evaluation.getMinValue() == evaluation.getMaxValue()) {
            errors.rejectValue("minValue", "minValue.equalsMaxValue", "Min value must be different from max value");
        }
    }
}
