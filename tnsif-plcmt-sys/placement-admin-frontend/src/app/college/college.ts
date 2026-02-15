import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-college',
  standalone: true,

  // 🔥 THIS IS THE FIX
  imports: [CommonModule, FormsModule],

  templateUrl: './college.html',
  styleUrls: ['./college.css']
})
export class CollegeComponent implements OnInit {

  colleges: any[] = [];
  filteredColleges: any[] = [];

  college = {
    collegeName: '',
    location: '',
    approved: false
  };

  searchText = '';

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.loadColleges();
  }

  loadColleges() {
    this.adminService.getColleges().subscribe(data => {
      this.colleges = data;
      this.filteredColleges = data;
    });
  }

   addCollege(): void {
    this.adminService.addCollege(this.college).subscribe(() => {

      // 1️⃣ reload table
      this.loadColleges();

      // 2️⃣ reset form
      this.college = {
        collegeName: '',
        location: '',
        approved: false
      };

      alert('College added successfully');
    });
  }

  searchCollege() {
    this.filteredColleges = this.colleges.filter(c =>
      c.collegeName.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }

  toggleApproval(college: any): void {
  if (!college.approved) {
    this.adminService.approveCollege(college.id).subscribe(() => {
      this.loadColleges();
    });
  }
}

  approveCollege(id: number) {
    this.adminService.approveCollege(id).subscribe(() => {
      this.loadColleges();
    });
  }
}
