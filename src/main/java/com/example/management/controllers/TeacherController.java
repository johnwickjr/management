package com.example.management.controllers;

import com.example.management.models.Student;
import com.example.management.models.Teacher;
import com.example.management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/admin/testing")
    public String teacherTesting() {
        return "teacher working";
    }

    @GetMapping("get-teacher/{id}")
    public Teacher getTeacher(@PathVariable("id") int id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/get-all-teacher")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @PostMapping("/save-teacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @PostMapping("/save-student/{teacherId}")
    public Student saveStudent(@PathVariable("teacherId") int id, @RequestBody Student student) {
        return teacherService.saveStudent(id, student);

    }


    @PutMapping("/update-student/{teacherId}")
    public Student updateStudent(@PathVariable("teacherId") int id, @RequestBody Student student) {
        return teacherService.updateStudent(id, student);
    }

    @DeleteMapping("/delete-student/{teacherId}/{studentId}")
    public Student deleteStudent(@PathVariable("teacherId") int teacherId, @PathVariable("studentId") int studentId) {
        return teacherService.deleteStudent(teacherId, studentId);
    }
}
