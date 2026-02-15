package com.plcmt.admin.service;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.plcmt.admin.entity.*;
import com.plcmt.admin.repository.*;

@Service

public  class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final CollegeRepository collegeRepository;
    private final PlacementRepository placementRepository;
    private final StudentRepository studentRepository;

    public AdminServiceImpl(AdminRepository adminRepository,
                            CollegeRepository collegeRepository,
                            PlacementRepository placementRepository,
                            StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.collegeRepository = collegeRepository;
        this.placementRepository = placementRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        throw new RuntimeException("Invalid Admin Credentials");
    }

    @Override
    public College approveCollege(Long collegeId) {
        College college = collegeRepository.findById(collegeId).orElseThrow();
        college.setApproved(true);
        return collegeRepository.save(college);
    }

    @Override
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    @Override
    public Placement addPlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }
    
    @Override
    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

	@Override
	public College saveCollege(College college) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}
    @Override
    public Student approveStudent(Long id) {
	    Student s = studentRepository.findById(id).orElseThrow();
	    s.setApproved(true);
	    return studentRepository.save(s);
	}

    @Override
	public Student blockStudent(Long id) {
	    Student s = studentRepository.findById(id).orElseThrow();
	    s.setApproved(false);
	    return studentRepository.save(s);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Placement savePlacement(Placement placement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getStudentCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCollegeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getPlacementCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}