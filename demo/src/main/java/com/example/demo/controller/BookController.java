package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.address.Address;
import com.example.demo.model.dto.BookDto;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/books")
public class BookController extends AbstractController<BookDto>{

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll() {
        return new ResponseEntity<>(StreamSupport.stream(bookService.getAll().spliterator(),false)
                .map(BookDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(Address.ID)
    public ResponseEntity<BookDto> findId(@PathVariable Long id) {
        return new ResponseEntity<>(BookDto.from(bookService.getId(id)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody BookDto object) {
        return new ResponseEntity<>(BookDto.from(bookService.save(Book.from(object))),HttpStatus.CREATED);
    }

    @PutMapping(Address.UPDATE)
    public ResponseEntity<BookDto> update(@PathVariable Long id,@RequestBody BookDto object) {
        return new ResponseEntity<>(BookDto.from(bookService.update(id,Book.from(object))),HttpStatus.OK);
    }

    @DeleteMapping(Address.DELETE)
    public ResponseEntity<BookDto> delete(@RequestParam Long id) {
        return new ResponseEntity<>(BookDto.from(bookService.remove(bookService.getId(id))),HttpStatus.OK);
    }
}
