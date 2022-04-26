package com.anjaniy.springbootcrud.repository;

import com.anjaniy.springbootcrud.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
