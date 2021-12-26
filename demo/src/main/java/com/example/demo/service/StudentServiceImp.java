package com.example.demo.service;

import com.example.demo.config.CustomNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.model.Student;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Student> getAll() {
        return StreamSupport.stream(studentRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public Student getId(Long id) {
        return studentRepository.findById(id).orElseThrow(()->new CustomNotFoundException("Not Found!!"));
    }

    @Override
    public Student getEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return studentRepository.findById(id).map(obj->{
            obj.setName(student.getName());
            obj.setEmail(student.getEmail());
            obj.setAge(student.getAge());
            return studentRepository.save(obj);
        }).orElseThrow(()->new CustomNotFoundException("Not Found!!"));
    }

    @Override
    public Student remove(Student student) {
        return studentRepository.findById(student.getIdStudent()).map(obj->{
            studentRepository.delete(obj);
            return obj;
        }).orElseThrow(()->new CustomNotFoundException("Not Found!!"));
    }

    @Override
    @Transactional
    public Student addBookToStudent(Long idBook, Long idStudent) {
        Student student=studentRepository.findById(idStudent).orElseThrow(()->new CustomNotFoundException("Not Found!!"));
        Book book=bookRepository.findById(idBook).orElseThrow(()->new CustomNotFoundException("Not Found!!"));
        student.addBook(book);
        book.setStudent(student);
        return student;
    }

    @Override
    @Transactional
    public Student removeBookFromStudent(Long idBook, Long idStudent) {
        Student student=studentRepository.findById(idStudent).orElseThrow(()->new CustomNotFoundException("Not Found!!"));
        Book book=bookRepository.findById(idBook).orElseThrow(()->new CustomNotFoundException("Not Found!!"));
        student.removeBook(book);
        book.setStudent(null);
        return student;
    }
}
