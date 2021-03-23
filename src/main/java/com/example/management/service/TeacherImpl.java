package com.example.management.service;

import com.example.management.models.Student;
import com.example.management.models.Teacher;
import com.example.management.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherImpl {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private StudentImpl studentImpl;

    public Teacher save(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public Student saveStudent(int teacherId, Student student) {

        Optional<Teacher> teacher = teacherRepo.findById(teacherId);
        if (teacher.isPresent()) {
            teacher.get().getStudents().add(student);
            teacherRepo.save(teacher.get());
        }
        return student;
    }

    public Teacher getTeacherById(int id) {
        return teacherRepo.findById(id).get();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public Student updateStudent(int teacherId, Student student) {
        Optional<Teacher> teacher = teacherRepo.findById(teacherId);
        Student toUpdate = null;
        if (teacher.isPresent()) {
            for (Student stu : teacher.get().getStudents()) {
                if (stu.getId() == student.getId()) {
                    toUpdate = student;
                    break;
                }
            }
            if (toUpdate != null) {
                studentImpl.saveStudent(toUpdate);
                return toUpdate;
            }
        }
        return null;
    }

    public Student deleteStudent(int id, Student student) {
        return null;
    }
}
