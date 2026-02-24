import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-student',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './student.html'
})
export class StudentComponent implements OnInit {

  students: any[] = [
    { id: 1, Name: 'Divya', Qualification: 'IT', status: 'Pending' },
    { id: 2, Name: 'Karthi', Qualification: 'CSC', status: 'Approved' }
  ];
  filteredStudents: any[] = [];
  searchText: string = '';

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents() {
    this.adminService.getStudents().subscribe((data: any[]) => {
      this.students = data;
      this.filteredStudents = data;
    });
  }

  searchStudent() {
    const text = this.searchText.toLowerCase();
    this.filteredStudents = this.students.filter(s =>
      s.name.toLowerCase().includes(text) ||
      s.qualification.toLowerCase().includes(text) ||
      String(s.year).includes(text)
    );
  }

  approve(id: number) {
    this.adminService.approveStudent(id).subscribe(() => {
      this.loadStudents();
    });
  }

  block(id: number) {
    this.adminService.blockStudent(id).subscribe(() => {
      this.loadStudents();
    });
  }
}
