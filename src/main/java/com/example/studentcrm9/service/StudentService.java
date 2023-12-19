package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAllByFaculty(Faculty faculty) {
        return studentRepository.findAllByFaculty(faculty);
    }
//TODO: is it effective?
//    public void updateStudentById(Student student) {
//        studentRepository.findById(student.getId())
//                .map(obj->{
//                    obj.setFaculty(student.getFaculty());
//                    obj.setGroup(student.getGroup());
//                    obj.setFirstName(student.getFirstName());
//                    obj.setLastName(student.getLastName());
//
//                }).orElseThrow(NoSuchElementException::new);
//    }

    public List<Student> findGroupMates(Student student) {
        return studentRepository.findAllByFacultyAndGroup(student.getFaculty(),student.getGroup())
                .stream()
                .filter(object-> !student.equals(object))
                .distinct()
                .collect(Collectors.toList());
    }
}
