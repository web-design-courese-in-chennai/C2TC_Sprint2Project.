package com.plcmt.admin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plcmt.admin.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	 Student findByEmail(String email);

	    List<Student> findByApproved(boolean approved);

		
} 