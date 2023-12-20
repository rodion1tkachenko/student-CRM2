package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    @Query("update Student s set s.firstName = ?1, s.lastName = ?2 where s.id = ?3")
    @Modifying
    public void setStudentInfoById(String firstname, String lastname, Long userId) {
        studentRepository.setStudentInfoById(firstname, lastname, userId);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }
//TODO: no service logic in method. logic is in controller layer
    public List<Student> findAllByFaculty(Faculty faculty) {
        return studentRepository.findAllByFaculty(faculty);
    }

    public List<Student> removeById(Long id) {
        return studentRepository.removeById(id);
    }

    public List<Student> findGroupMates(Student student) {
        return studentRepository.findAllByFacultyAndGroup(student.getFaculty(),student.getGroup())
                .stream()
                .filter(object-> !student.equals(object))
                .distinct()
                .collect(Collectors.toList());
    }
}
