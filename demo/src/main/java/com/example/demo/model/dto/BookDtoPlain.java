package com.example.demo.model.dto;

import com.example.demo.model.Book;
import lombok.Data;


@Data
public class BookDtoPlain {

    private Long idBook;
    private String name;

    public static BookDtoPlain from(Book book){
        BookDtoPlain bookDtoPlain=new BookDtoPlain();
        bookDtoPlain.setIdBook(book.getIdBook());
        bookDtoPlain.setName(book.getName());
        return bookDtoPlain;
    }

}
