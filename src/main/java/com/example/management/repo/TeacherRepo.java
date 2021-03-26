package com.example.management.repo;

import com.example.management.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findByUserName(String name);

    @Query("select t from Teacher t where t.userName =:userName")
    List<Teacher> findByUserNameList(@Param("userName") String userName);

    @Query("select t from Teacher t where t.role =:role")
    List<Teacher> getTeacherByRole(@Param("role") String role);
}
