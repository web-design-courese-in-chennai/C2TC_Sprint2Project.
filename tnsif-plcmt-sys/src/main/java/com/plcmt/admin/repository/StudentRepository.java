package com.plcmt.admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.plcmt.admin.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}