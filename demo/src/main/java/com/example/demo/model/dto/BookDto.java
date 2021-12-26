package com.example.demo.model.dto;

import com.example.demo.model.Book;
import lombok.Data;

import java.util.Objects;

@Data
public class BookDto {

    private Long idBook;
    private String name;
    private StudentDto studentDto;

    public static BookDto from(Book book){
        BookDto bookDto=new BookDto();
        bookDto.setIdBook(book.getIdBook());
        bookDto.setName(book.getName());
        if(Objects.nonNull(book.getStudent()))
            bookDto.setStudentDto(StudentDto.from(book.getStudent()));
        return bookDto;
    }
}
