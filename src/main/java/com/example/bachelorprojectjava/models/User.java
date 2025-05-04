package com.example.bachelorprojectjava.models;

import com.example.bachelorprojectjava.enums.RoleType;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "classroom_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id"))
    @JsonIgnore
    private List<Classroom> taughtClassrooms = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Note> notes = new ArrayList<>();

    public boolean isTeacher() {
        return role.getRoleType() == RoleType.TEACHER;
    }

    public boolean isStudent() {
        return role.getRoleType() == RoleType.STUDENT;
    }
}
