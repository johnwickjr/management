package com.example.management.service;

import com.example.management.models.Student;
import com.example.management.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student get(int id) {
        return studentRepo.findById(id).get();
    }

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student) {
        Optional<Student> toUpdate = studentRepo.findById(student.getId());
        if (toUpdate.isPresent()) {
            studentRepo.save(student);
            return student;
        }
        return null;
    }

    public void deleteStudent(Student toDelete) {
        if (toDelete != null) {
            studentRepo.delete(toDelete);
        }
    }

    public Optional<Student> getStudentByName(String name) {
        return studentRepo.findByName(name);
    }

    public List<Student> getTeacherByAnyKey(String regex) {
        List<Student> students = new ArrayList<>();
        try {
            int anInt = Integer.parseInt(regex);
            students = studentRepo.findAllById(Collections.singletonList(anInt));
        } catch (NumberFormatException e) {
            if (studentRepo.findByUserNameList(regex).size() == 0) {
                if (studentRepo.getStudentByRole(regex).size() == 0) {
                    if (studentRepo.getStudentByBranch(regex).size() == 0) {
                        if (studentRepo.getStudentByAddress(regex).size() == 0) {
                            return students;
                        } else {
                            return studentRepo.getStudentByAddress(regex);
                        }
                    } else {
                        return studentRepo.getStudentByBranch(regex);
                    }
                } else {
                    return studentRepo.getStudentByRole(regex);
                }
            } else {
                return studentRepo.findByUserNameList(regex);
            }
        }
        return students;
    }
}
