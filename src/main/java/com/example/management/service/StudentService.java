package com.example.management.service;

import com.example.management.models.Student;
import com.example.management.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Optional<Student> getStudentByName(String name){
        return studentRepo.findByName(name);
    }
}
