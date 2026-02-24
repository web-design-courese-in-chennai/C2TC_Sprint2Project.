package com.plcmt.admin.service;
import java.util.List;
import com.plcmt.admin.entity.*;


public interface AdminService {


	
	Admin login(String username, String password);

	  College saveCollege(College college);
	    List<College> getAllColleges();
	    College approveCollege(Long id);

	    Student saveStudent(Student student);
	    List<Student> getAllStudents();
	    

	    List<Student> getApprovedStudents();
	    void deleteStudent(Long id);
	    
	    

	    Placement savePlacement(Placement placement);
		Placement addPlacement(Placement placement);
	    List<Placement> getAllPlacements();
	    void deletePlacement(Long id);

	    long getStudentCount();
	    long getCollegeCount();
	    long getPlacementCount();

		Student approveStudent(Long id);

		Student blockStudent(Long id);

		List<Student> getPendingStudents();

		Placement approvePlacement(Long id);
		}
		

