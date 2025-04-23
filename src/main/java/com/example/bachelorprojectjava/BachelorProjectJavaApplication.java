package com.example.bachelorprojectjava;

import com.example.bachelorprojectjava.enums.RoleType;
import com.example.bachelorprojectjava.models.Role;
import com.example.bachelorprojectjava.repositories.RoleRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BachelorProjectJavaApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_CONNECTION", dotenv.get("DB_CONNECTION"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI"));
        System.setProperty("MONGODB_DATABASE", dotenv.get("MONGODB_DATABASE"));

        SpringApplication.run(BachelorProjectJavaApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
//        return args -> {
//            Role adminRole = new Role();
//            adminRole.setRoleType(RoleType.ADMIN);
//            adminRole.setLabel("Admin");
//            roleRepository.save(adminRole);
//
//            Role teacherRole = new Role();
//            teacherRole.setRoleType(RoleType.TEACHER);
//            teacherRole.setLabel("Teacher");
//            roleRepository.save(teacherRole);
//
//            Role studentRole = new Role();
//            studentRole.setRoleType(RoleType.STUDENT);
//            studentRole.setLabel("Student");
//            roleRepository.save(studentRole);
//        };
//    }
}
