package com.example.studentmanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String academicYear;
    private String program;
    private String contact;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<CourseGrade> courseGrades = new HashSet<>();
}
