package com.okulyonetim.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class ogrencikontrol {

    @Autowired
    private ogrneciislemleri studentService;

    @GetMapping
    public List<Ogrenci> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ogrenci> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ogrenci> addStudent(@RequestBody Ogrenci student) {
        Ogrenci createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ogrenci> updateStudent(@PathVariable Long id, @RequestBody Ogrenci student) {
        try {
            Ogrenci updatedStudent = studentService.updateStudent(id, student);
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // bölüme göre öğrenci arama
    @GetMapping("/bolum/{bolum}")
    public ResponseEntity<List<Ogrenci>> getStudentsByBolum(@PathVariable String bolum) {
    List<Ogrenci> students = studentService.getStudentsByBolum(bolum);
    return ResponseEntity.ok(students);
    }

}
