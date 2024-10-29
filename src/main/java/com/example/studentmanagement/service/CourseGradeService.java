package com.example.studentmanagement.service;

import com.example.studentmanagement.model.CourseGrade;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.CourseGradeRepository;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseGradeService {

    @Autowired
    private CourseGradeRepository courseGradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<CourseGrade> getCoursesByStudentId(Long studentId) {
        return courseGradeRepository.findByStudentId(studentId);
    }

    public CourseGrade saveCourseGrade(Long studentId, CourseGrade courseGrade) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        courseGrade.setStudent(student);
        return courseGradeRepository.save(courseGrade);
    }

    public void deleteCourseGrade(Long courseGradeId) {
        courseGradeRepository.deleteById(courseGradeId);
    }
}
