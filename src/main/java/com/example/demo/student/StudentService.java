package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) { this.studentRepository = studentRepository; }

    public List<Student> getStudents() { return studentRepository.findAll(); }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));

        //Checks if new name is given, length greater than 0 and not same as already set name
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        //Checks if email is given, length is greater than 0, and email not already taken
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
//    Personal Code...for exercise in creating PUT protocol
//    @Transactional
//    public void updateStudent(Long studentId,
//                              String name,
//                              String email) {
//        boolean exists = studentRepository.existsById(studentId);
//        if (exists) {
//            studentRepository.getOne(studentId).setName("Vincent");
//            studentRepository.getOne(studentId).setEmail("123@gmail.com");
//        }
//        else {
//            throw new IllegalStateException(
//                    "student with id " + studentId + " does not exists");
//        }
//    }
}
