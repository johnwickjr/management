package com.example.management.repo;

import com.example.management.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    Optional<Student> findByName(String name);
}
