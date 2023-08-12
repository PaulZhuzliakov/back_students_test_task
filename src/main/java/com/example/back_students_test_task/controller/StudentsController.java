package com.example.back_students_test_task.controller;

import com.example.back_students_test_task.model.Student;
import com.example.back_students_test_task.service.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentsController {

    private final StudentsServiceImpl studentsService;

    @Autowired
    public StudentsController(StudentsServiceImpl studentsService) {
        this.studentsService = studentsService;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentsService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentsService.create(student);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentsService.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentsService.deleteById(id);
    }
}
