package com.plcmt.admin.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.plcmt.admin.entity.*;
import com.plcmt.admin.service.AdminService;


@RestController     //handle REST API
@RequestMapping("/admin")   //maps URL

@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {
        return adminService.login(admin.getUsername(), admin.getPassword());
    }

    @PostMapping("/college")
    public College addCollege(@RequestBody College c) {
        return adminService.saveCollege(c);
    }

    @GetMapping("/colleges")
    public List<College> colleges() {
        return adminService.getAllColleges();
    }

    @PutMapping("/college/approve/{id}")
    public College approve(@PathVariable Long id) {
        return adminService.approveCollege(id);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student s) {
        return adminService.saveStudent(s);
    }

    @GetMapping("/students")
    public List<Student> students() {
        return adminService.getAllStudents();
    }
    @GetMapping("/pending")
    public List<Student> pendingStudents() {
        return adminService.getPendingStudents();
    }

    @GetMapping("/approved")
    public List<Student> approvedStudents() {
        return adminService.getApprovedStudents();
    }
    @PutMapping("/approve-student/{id}")
    public Student approveStudent(@PathVariable Long id) {
        return adminService.approveStudent(id);
    }
    
    @PutMapping("/student/approve/{id}")
    public Student approveStudents(@PathVariable Long id) {
        return adminService.approveStudent(id);
    }

    @PutMapping("/student/block/{id}")
    public Student blockStudent(@PathVariable Long id) {
        return adminService.blockStudent(id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        adminService.deleteStudent(id);
    }

    @PostMapping("/placement")
    public Placement addPlacement(@RequestBody Placement p) {
        return adminService.savePlacement(p);
    }
    
    @PutMapping("/placement/approve/{id}")
    public Placement approvePlacement(@PathVariable Long id) {
        return adminService.approvePlacement(id);
    }

    @GetMapping("/placements")
    public List<Placement> placements() {
        return adminService.getAllPlacements();
    }

    @DeleteMapping("/placement/{id}")
    public void deletePlacement(@PathVariable Long id) {
        adminService.deletePlacement(id);
    }

    @GetMapping("/count/students")
    public long studentCount() { return adminService.getStudentCount(); }

    @GetMapping("/count/colleges")
    public long collegeCount() { return adminService.getCollegeCount(); }

    @GetMapping("/count/placements")
    public long placementCount() { return adminService.getPlacementCount(); }
}