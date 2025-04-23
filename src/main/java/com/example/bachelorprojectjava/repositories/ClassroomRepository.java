package com.example.bachelorprojectjava.repositories;

import com.example.bachelorprojectjava.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<Classroom> findByNameContaining(String name);
}
