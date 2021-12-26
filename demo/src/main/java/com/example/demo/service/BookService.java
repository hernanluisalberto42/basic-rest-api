package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAll();

    public Book getId(Long id);

    public Book save(Book book);

    public Book update(Long id, Book book);

    public Book remove(Book book);
}
