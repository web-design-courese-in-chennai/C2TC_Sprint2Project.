package com.plcmt.admin.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.plcmt.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}