package com.anjaniy.springbootcrud.repositories;

import com.anjaniy.springbootcrud.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findById(Integer id);
}
