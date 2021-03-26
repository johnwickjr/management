package com.example.management.service;

import com.example.management.models.Student;
import com.example.management.models.Teacher;
import com.example.management.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private StudentService studentService;

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
                studentService.saveStudent(toUpdate);
                return toUpdate;
            }
        }
        return null;
    }


    public Student deleteStudent(int teacherId, int studentId) {
        int position = -1;
        Optional<Teacher> teacher = teacherRepo.findById(teacherId);
        Student toDelete = null;
        if (teacher.isPresent()) {
            for (Student stu : teacher.get().getStudents()) {
                position += 1;
                if (stu.getId() == studentId) {
                    toDelete = stu;
                    System.out.println(toDelete);
                    break;
                }
            }
            if (toDelete != null) {
                teacher.get().getStudents().remove(position);
                studentService.deleteStudent(toDelete);
                return toDelete;
            }
        }
        return null;
    }

    public List<Teacher> getAllTeacher() {
        return teacherRepo.findAll();
    }

    public Optional<Teacher> getTeacherByName(String name){
        return teacherRepo.findByUserName(name);
    }
}
