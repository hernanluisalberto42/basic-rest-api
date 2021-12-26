package com.example.demo.model.dto;

import com.example.demo.model.Student;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class StudentDto {

    private Long idStudent;
    private String name;
    private String email;
    private Integer age;
    private List<BookDtoPlain> books;

    public static StudentDto from(Student student){
        StudentDto studentDto=new StudentDto();
        studentDto.setIdStudent(student.getIdStudent());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setAge(student.getAge());
        if(Objects.nonNull(student.getBooks()))
            studentDto.setBooks(student.getBooks().stream().map(BookDtoPlain::from).collect(Collectors.toList()));
        return studentDto;
    }
}
