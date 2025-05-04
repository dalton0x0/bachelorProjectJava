package com.example.bachelorprojectjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.EAGER)
    @JsonIgnore
    List<User> students = new ArrayList<>();

    @ManyToMany(mappedBy = "taughtClassrooms", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User> teachers = new ArrayList<>();
}
