package com.example.demo.controller;


import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController<T> {

    public abstract ResponseEntity<List<T>> findAll();

    public abstract ResponseEntity<T> findId(Long id);

    public abstract ResponseEntity<T> save(T object);

    public abstract ResponseEntity<T> update(Long id, T object);

    public abstract ResponseEntity<T> delete(Long id);


}
