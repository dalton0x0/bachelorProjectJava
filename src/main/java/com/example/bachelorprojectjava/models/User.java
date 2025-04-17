package com.example.bachelorprojectjava.models;

import com.example.bachelorprojectjava.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public boolean isTeacher() {
        return role.getRoleType() == RoleType.TEACHER;
    }

    public boolean isStudent() {
        return role.getRoleType() == RoleType.STUDENT;
    }
}
