package com.example.management.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    public Teacher(String userName) {
        this.userName = userName;
    }

    public Teacher(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public Teacher(String userName, String password, String role, List<Student> students) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.students = students;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", students=" + students +
                '}';
    }
}
