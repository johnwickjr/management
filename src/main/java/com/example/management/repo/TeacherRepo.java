package com.example.management.repo;

import com.example.management.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findByUserName(String name);

}
