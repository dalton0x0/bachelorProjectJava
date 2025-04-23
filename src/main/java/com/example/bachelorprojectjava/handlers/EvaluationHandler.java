package com.example.bachelorprojectjava.handlers;

import com.example.bachelorprojectjava.models.Evaluation;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RepositoryEventHandler
public class EvaluationHandler {;

    @HandleBeforeCreate
    public void handleUserBeforeCreate(Evaluation evaluation) {
        evaluation.setDate(LocalDateTime.now());
    }

    @HandleBeforeSave
    public void handleUserBeforeSave(Evaluation evaluation) {
        evaluation.setDate(LocalDateTime.now());
    }
}
