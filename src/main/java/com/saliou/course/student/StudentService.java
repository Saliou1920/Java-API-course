package com.saliou.course.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private  final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new RuntimeException("Student already exists");
        }

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("Student does not exist");
        }
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("Student with id " + id + " does not exist");
        }
        student.setId(id);
        return studentRepository.save(student);
    }
}
