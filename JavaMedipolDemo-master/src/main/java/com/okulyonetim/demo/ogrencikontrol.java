package com.okulyonetim.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Ogrenci getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id).orElse(null);
    }

    @PostMapping
    public Ogrenci addStudent(@RequestBody Ogrenci student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Ogrenci updateStudent(@PathVariable Long id, @RequestBody Ogrenci student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
