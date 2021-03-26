package com.example.management.service;

import com.example.management.dto.CurrentUser;
import com.example.management.models.Student;
import com.example.management.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.plaf.ColorUIResource;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        CurrentUser user;

        Optional<Student> student = studentService.getStudentByName(userName);
        if (student.isEmpty()) {
            Optional<Teacher> teacher = teacherService.getTeacherByName(userName);
            if (teacher.isEmpty()) {
                throw new RuntimeException("No user found with this name");
            } else {
                Teacher ct = teacher.get();
                user = new CurrentUser(ct.getUserName(), ct.getPassword(), ct.getRole());
            }
        } else {
            Student st = student.get();
            user = new CurrentUser(st.getName(), st.getPassword(), st.getRole());
        }
        return new MUserDetail(user);
    }
}
