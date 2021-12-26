package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.address.Address;
import com.example.demo.model.dto.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/students")
public class StudentController extends AbstractController<StudentDto>{

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll() {
        return new ResponseEntity<>(StreamSupport.stream(studentService.getAll().spliterator(),false)
                .map(StudentDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(Address.ID)
    public ResponseEntity<StudentDto> findId(@PathVariable Long id) {
        return new ResponseEntity<>(StudentDto.from(studentService.getId(id)),HttpStatus.OK);
    }

    @GetMapping(Address.EMAIL)
    public ResponseEntity<StudentDto> findEmail(@PathVariable String email) {
        return new ResponseEntity<>(StudentDto.from(studentService.getEmail(email)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> save(@RequestBody StudentDto object) {
        return new ResponseEntity<>(StudentDto.from(studentService.save(Student.from(object))),HttpStatus.CREATED);
    }

    @PutMapping(Address.UPDATE)
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @RequestBody StudentDto object) {
        return new ResponseEntity<>(StudentDto.from(studentService.update(id,Student.from(object))),HttpStatus.OK);
    }

    @DeleteMapping(Address.DELETE)
    public ResponseEntity<StudentDto> delete(@RequestParam Long  id) {
        return new ResponseEntity<>(StudentDto.from(studentService.remove(studentService.getId(id))),HttpStatus.OK);
    }

    @PostMapping(Address.ADD_BOOK)
    public ResponseEntity<StudentDto> addBookStudent(@PathVariable Long idBook,@PathVariable Long idStudent) {
        return new ResponseEntity<>(StudentDto.from(studentService.addBookToStudent(idBook, idStudent)),HttpStatus.OK);
    }

    @DeleteMapping(Address.DEL_BOOK)
    public ResponseEntity<StudentDto> deleteBookStudent(@PathVariable Long idBook,@PathVariable Long idStudent) {
        return new ResponseEntity<>(StudentDto.from(studentService.removeBookFromStudent(idBook, idStudent)),HttpStatus.OK);
    }
}
