import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8080/admin';

  constructor(private http: HttpClient) {}

  /* ---------- PLACEMENT ---------- */

getPlacements() {
  return this.http.get<any[]>(`${this.baseUrl}/placements`);
}

approvePlacement(id: number) {
  return this.http.put(`${this.baseUrl}/placement/approve/${id}`, {});
}

deletePlacement(id: number) {
  return this.http.delete(`${this.baseUrl}/placement/${id}`);
}


   /* ---------- STUDENT ---------- */

  getStudents(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/students`);
  }

  approveStudent(id: number) {
  return this.http.put(`${this.baseUrl}/student/approve/${id}`, {});
}

blockStudent(id: number) {
  return this.http.put(`${this.baseUrl}/student/block/${id}`, {});
}

  /* ---------- COLLEGE ---------- */

  getColleges(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/colleges`);
  }

  addCollege(college: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/college`, college);
  }

  approveCollege(id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/college/approve/${id}`, {});
  }

   /* ---------- STUDENT ---------- */

  
}
