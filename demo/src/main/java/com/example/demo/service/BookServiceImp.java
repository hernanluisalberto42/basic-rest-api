package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImp implements BookService{

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getAll() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public Book getId(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found!!"));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        return bookRepository.findById(id).map(obj->{
            obj.setName(book.getName());
            return bookRepository.save(obj);
        }).orElseThrow(()->new RuntimeException("Not Found!!"));
    }

    @Override
    public Book remove(Book book) {
        return bookRepository.findById(book.getIdBook()).map(obj->{
            bookRepository.delete(obj);
            return obj;
        }).orElseThrow(()->new RuntimeException("Not Found!!"));
    }
}
