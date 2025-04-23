package com.example.bachelorprojectjava.repositories;

import com.example.bachelorprojectjava.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByTitleContaining(String title);
}
