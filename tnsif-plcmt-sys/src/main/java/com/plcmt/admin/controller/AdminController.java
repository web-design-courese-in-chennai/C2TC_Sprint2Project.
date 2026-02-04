package com.plcmt.admin.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.plcmt.admin.entity.*;
import com.plcmt.admin.service.AdminService;


@RestController     //handle REST API
@RequestMapping("/admin")   //maps URL
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login") 
    public Admin login(@RequestParam String username,
                       @RequestParam String password) {
        return adminService.login(username, password);
    }
   

    @PutMapping("/approve-college/{id}")
    public College approveCollege(@PathVariable Long id) {
        return adminService.approveCollege(id);
    }

    @GetMapping("/colleges")
    public List<College> getAllColleges() {
        return adminService.getAllColleges();
    }

    @PostMapping("/placement")
    public Placement addPlacement(@RequestBody Placement placement) {
        return adminService.addPlacement(placement);
    }

    @GetMapping("/placements")
    public List<Placement> getAllPlacements() {
        return adminService.getAllPlacements();
    }
    
    @PutMapping("/placement/{id}")
    public Placement updatePlacement(@PathVariable Long id,
                                     @RequestBody Placement placement) {
        placement.setId(id);
        return adminService.addPlacement(placement);
    }

    @DeleteMapping("/placement/{id}")
    public String deletePlacement(@PathVariable Long id) {
        adminService.deletePlacement(id);
        return "Placement deleted successfully";
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return adminService.getAllStudents();
    }
}