package com.example.back_students_test_task.service;

import com.example.back_students_test_task.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Service
public class StudentsServiceImpl implements StudentService {
    List<Student> students = new ArrayList<>();

    //замена primary key :)
    Long counter = 2L;

    @PostConstruct
    void init() {
        students.add(new Student(1L, "Смирнов", "Борис", "Иванович", LocalDate.of(2002, 1, 5).toString(), "Биоинформатика"));
        students.add(new Student(2L, "Гаврилова", "Анна", "Николаевна",
                LocalDate.of(2005, 4, 17).toString(), "Электроэнергетика"));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void deleteById(Long id) {
        students = students.stream().filter(not(s -> s.getId().equals(id))).collect(Collectors.toList());
    }

    @Override
    public void update(Student student) {
        deleteById(student.getId());
        students.add(student);
    }

    @Override
    public void create(Student student) {
        student.setId(++counter);
        students.add(student);
    }

}
