package com.example.back_students_test_task.service;

import com.example.back_students_test_task.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void deleteById(Long id);

    void update(Student student);

    void create(Student student);





}
