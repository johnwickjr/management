package com.example.management.controllers;

import com.example.management.models.Student;
import com.example.management.service.StudentImpl;
import com.example.management.service.TeacherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private TeacherImpl teacherImpl;
    @Autowired
    private StudentImpl studentImpl;

    @GetMapping("/user/testing")
    public String testing() {
        return "working";
    }

//    @PostMapping("/save-student/{teacherId}")
//    public Student saveStudent(@PathVariable("teacherId") int id, @RequestBody Student student) {
//        return service.saveStudent(id, student);
//    }


    // to save user
    @GetMapping("/save-student")
    public Student saveStudent(@RequestBody Student student) {
        return studentImpl.saveStudent(student);
    }

    //    to get user by id
    @GetMapping("/get-student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentImpl.get(id);

    }

    //    to get all student
    @GetMapping("/get-all-student")
    public List<Student> getAllStudent() {
        return studentImpl.getAll();
    }

//    to update student
    @PutMapping("/update-student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {

        Student stu = studentImpl.updateStudent(student);

        if (stu != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(stu);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
