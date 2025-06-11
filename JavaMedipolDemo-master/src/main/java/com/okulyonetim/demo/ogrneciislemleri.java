
package com.okulyonetim.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ogrneciislemleri {

    @Autowired
    private ogrencikaynaklari studentRepository;

    public List<Ogrenci> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Ogrenci> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Ogrenci addStudent(Ogrenci student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Ogrenci updateStudent(Long id, Ogrenci updatedStudent) {
        Ogrenci existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setId(updatedStudent.getId());
        existingStudent.setPrice(updatedStudent.getPrice());
        existingStudent.setDescription(updatedStudent.getDescription());
        existingStudent.setStock(updatedStudent.getStock());
    
        return studentRepository.save(existingStudent);
    }
    
}
