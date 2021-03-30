package com.example.management.repo;

import com.example.management.models.Student;
import com.example.management.models.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    Optional<Student> findByName(String name);

    @Query("select t from Student t where t.name =:name")
    List<Student> findByUserNameList(@Param("name") String name);

    @Query("select t from Student t where t.role =:role")
    List<Student> getStudentByRole(@Param("role") String role);

    @Query("select t from Student t where t.branch =:branch")
    List<Student> getStudentByBranch(@Param("branch") String branch);

    @Query("select t from Student t where t.address =:address")
    List<Student> getStudentByAddress(@Param("address") String address);

    @Query("select s from Student s")
    Page<Student> testingPaging(Pageable pageable);

}
