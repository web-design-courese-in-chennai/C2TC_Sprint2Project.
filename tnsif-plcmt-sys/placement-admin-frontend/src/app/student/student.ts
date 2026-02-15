import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-student',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './student.html',
  styleUrls: ['./student.css']
})
export class StudentComponent implements OnInit {

  students: any[] = [];
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
    this.filteredStudents = this.students.filter(s =>
      s.name?.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }
}
