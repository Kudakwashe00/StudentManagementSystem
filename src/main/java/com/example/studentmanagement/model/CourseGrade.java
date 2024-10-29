package com.example.studentmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CourseGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}