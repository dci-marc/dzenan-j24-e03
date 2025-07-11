package org.dci.studentmanagementapi.services;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dci.studentmanagementapi.models.Student;
import org.dci.studentmanagementapi.models.StudentDTO;
import org.dci.studentmanagementapi.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudent(UUID id) {
       return studentRepository.findById(id);
    }

    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.firstName());
        student.setLastName(studentDTO.lastName());
        student.setMajor(studentDTO.major());
        student.setAge(studentDTO.age());
        return studentRepository.save(student);
    }

    public Optional<Student> deleteStudent(UUID id) {
        Optional<Student> studentDTO = studentRepository.findById(id);
        if (studentDTO.isPresent()) {
            studentRepository.deleteById(id);
        }
        return studentDTO;
    }

    public Optional<Student> updateStudent(UUID id, StudentDTO studentDTO) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            return Optional.empty();
        }

        Student student = studentOptional.get();

        if (studentDTO.firstName() != null) {
            student.setFirstName(studentDTO.firstName());
        }

        if (studentDTO.lastName() != null) {
            student.setLastName(studentDTO.lastName());
        }

        if (studentDTO.major() != null) {
            student.setMajor(studentDTO.major());
        }

        if (studentDTO.age() != null) {
            student.setAge(studentDTO.age());
        }

        return Optional.of(studentRepository.save(student));
    }

    public List<Student> findStudentsByMajor(String major) {
        return studentRepository.findByMajorIgnoreCase(major);
    }

}
