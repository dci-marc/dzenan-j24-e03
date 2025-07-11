package org.dci.studentmanagementapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dci.studentmanagementapi.models.Student;
import org.dci.studentmanagementapi.models.StudentDTO;
import org.dci.studentmanagementapi.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) Integer limit) {
        List<Student> students = studentService.getStudents();
        if (limit != null && limit > 0) {
            return students.subList(0, Math.min(students.size(), limit));
        } else {
            return students;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable UUID id) {
        return ResponseEntity.of(studentService.getStudent(id));
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable UUID id) {
        return ResponseEntity.of(studentService.deleteStudent(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable UUID id, @Valid @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.of(studentService.updateStudent(id, studentDTO));
    }
}
