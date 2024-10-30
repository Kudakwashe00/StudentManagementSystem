package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.CourseGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseGradeRepository extends JpaRepository<CourseGrade, Long> {
    List<CourseGrade> findByStudentId(Long studentId);
}