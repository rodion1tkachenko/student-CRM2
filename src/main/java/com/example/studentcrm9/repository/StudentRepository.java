package com.example.studentcrm9.repository;

import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    @Override
    Optional<Student> findById(Long id);
    List<Student> findAllByFaculty(Faculty faculty);
    List<Student> findAllByFacultyAndGroup(Faculty faculty, Integer group);


}
