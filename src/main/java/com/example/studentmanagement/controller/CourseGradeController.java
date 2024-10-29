package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.CourseGrade;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.CourseGradeService;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students/{studentId}/courses")
public class CourseGradeController {

    @Autowired
    private CourseGradeService courseGradeService;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listCourses(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        model.addAttribute("courses", courseGradeService.getCoursesByStudentId(studentId));
        model.addAttribute("courseGrade", new CourseGrade());
        return "courses/list";
    }

    @PostMapping("/add")
    public String addCourse(@PathVariable Long studentId, @ModelAttribute CourseGrade courseGrade) {
        courseGradeService.saveCourseGrade(studentId, courseGrade);
        return "redirect:/students/" + studentId + "/courses";
    }

    @GetMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        courseGradeService.deleteCourseGrade(courseId);
        return "redirect:/students/" + studentId + "/courses";
    }
}