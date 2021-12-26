package com.example.demo.model;

import com.example.demo.model.dto.BookDto;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;

    @NotEmpty
    private String name;

    @ManyToOne
    private Student student;

    public static Book from(BookDto bookDto){
        Book book=new Book();
        book.setName(bookDto.getName());
        return book;
    }
}
