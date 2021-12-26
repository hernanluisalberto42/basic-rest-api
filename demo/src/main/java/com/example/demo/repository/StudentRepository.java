package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
    public Student findByEmail(String email);
}
