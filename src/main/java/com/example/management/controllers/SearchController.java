package com.example.management.controllers;

import com.example.management.models.Student;
import com.example.management.models.Teacher;
import com.example.management.service.StudentService;
import com.example.management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/search-teacher/{regex}")
    public ResponseEntity<List<Teacher>> findAndTeacher(@PathVariable("regex") String regex) {
        List<Teacher> teachers = teacherService.getTeacherByAnyKey(regex);
        if (teachers.size() != 0) {
            return ResponseEntity.status(HttpStatus.FOUND).body(teachers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/search-student/{regex}")
    public ResponseEntity<List<Student>> findAnyStudent(@PathVariable("regex") String regex) {
        List<Student> students = studentService.getTeacherByAnyKey(regex);
        if (students.size() != 0) {
            return ResponseEntity.status(HttpStatus.FOUND).body(students);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
