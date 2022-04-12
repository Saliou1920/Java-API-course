package com.saliou.course.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacher(Long id) {
        if (!teacherRepository.existsById(id)){
            throw new IllegalArgumentException("Teacher not found");
        }
        return teacherRepository.findById(id).get();
    }

    public Teacher addTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findByEmail(teacher.getEmail());
        if (teacherOptional.isPresent()) {
            throw new IllegalArgumentException("Teacher already exists");
        }
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        if (!teacherRepository.existsById(id)){
            throw new IllegalArgumentException("Teacher not found");
        }
        Optional<Teacher> teacherOptional = teacherRepository.findByEmail(teacher.getEmail());
        if (teacherOptional.isPresent()) {
            throw new IllegalArgumentException("Teacher already exists");
        }
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)){
            throw new IllegalArgumentException("Teacher not found");
        }
        teacherRepository.deleteById(id);
    }
}
