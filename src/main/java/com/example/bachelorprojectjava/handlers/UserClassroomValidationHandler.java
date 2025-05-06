package com.example.bachelorprojectjava.handlers;

import com.example.bachelorprojectjava.enums.RoleType;
import com.example.bachelorprojectjava.exceptions.BadRequestException;
import com.example.bachelorprojectjava.models.Classroom;
import com.example.bachelorprojectjava.models.User;
import com.example.bachelorprojectjava.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class UserClassroomValidationHandler {

    @Autowired
    ClassroomRepository classroomRepository;

    @EventListener
    public void handleBeforeSave(BeforeSaveEvent event) {
        Object entity = event.getSource();

        if (entity instanceof User user && user.getId() != null) {

            Classroom classroom = classroomRepository.findById(user.getClassroom().getId()).orElse(null);

            if (user.getRole().getRoleType() == RoleType.ADMIN) {
                throw new BadRequestException("Admin users can't have a classroom");
            }

            if (user.isStudent()) {
                if (user.getClassroom() != null && user.getClassroom().equals(classroom)) {
                    throw new BadRequestException("This student is already on this classroom");
                }
                user.setClassroom(classroom);
            }

            if (user.isTeacher()) {
                if (user.getTaughtClassrooms().contains(classroom)) {
                    throw new BadRequestException("This teacher is already assigned to this classroom");
                }
                user.getTaughtClassrooms().add(classroom);
            }
        }
    }
}
