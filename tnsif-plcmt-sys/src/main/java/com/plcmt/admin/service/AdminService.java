package com.plcmt.admin.service;


import java.util.List;
import com.plcmt.admin.entity.*;

public interface AdminService {

    Admin login(String username, String password);

    College approveCollege(Long collegeId);

    List<College> getAllColleges();

    Placement addPlacement(Placement placement);
   
    void deletePlacement(Long id);

    List<Placement> getAllPlacements();

    List<Student> getAllStudents();
}