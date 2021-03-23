package com.example.management.controllers;

import com.example.management.models.Student;
import com.example.management.models.Teacher;
import com.example.management.service.TeacherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherImpl teacherImpl;

    @GetMapping("/admin/testing")
    public String teacherTesting() {
        return "teacher working";
    }

    @GetMapping("get-teacher/{id}")
    public Teacher getTeacher(@PathVariable("id") int id) {
        return teacherImpl.getTeacherById(id);
    }

    @PostMapping("/save-teacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherImpl.saveTeacher(teacher);
    }

    @PostMapping("/save-student/{teacherId}")
    public Student saveStudent(@PathVariable("teacherId") int id, @RequestBody Student student) {
        return teacherImpl.saveStudent(id, student);

    }


    @PutMapping("/update-student/{teacherId}")
    public Student updateStudent(@PathVariable("teacherId") int id, @RequestBody Student student) {
        return teacherImpl.updateStudent(id, student);
    }

    @DeleteMapping("/delete-student/{teacherId}")
    public Student deleteStudent(@PathVariable("teacherId") int id, @RequestBody Student student) {
        return teacherImpl.deleteStudent(id, student);
    }
}
