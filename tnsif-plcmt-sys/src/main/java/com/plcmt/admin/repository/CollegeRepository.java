package com.plcmt.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plcmt.admin.entity.College;

public interface CollegeRepository extends JpaRepository<College, Long> {
}