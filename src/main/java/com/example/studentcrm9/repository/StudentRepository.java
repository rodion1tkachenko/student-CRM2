package com.example.studentcrm9.repository;

import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student,Long> {
    @Override
    Optional<Student> findById(Long id);
    List<Student> findAllByFaculty(Faculty faculty);
    List<Student> findAllByFacultyAndGroup(Faculty faculty, Integer group);

    @Modifying
    @Query("update Student s set s.firstName = ?1, s.lastName = ?2 where s.id = ?3")
    void setStudentInfoById(String firstname, String lastname, Long userId);
//    List<Student> removeById(Long id);
    List<Student> removeById(Long id);
}
