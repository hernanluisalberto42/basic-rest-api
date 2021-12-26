package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAll();

    public Student getId(Long id);

    public Student getEmail(String email);

    public Student save(Student student);

    public Student update(Long id, Student student);

    public Student remove(Student student);

    public Student addBookToStudent(Long idBook, Long idStudent);

    public Student removeBookFromStudent(Long idBook, Long idStudent);
}
