import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8080/admin';

  constructor(private http: HttpClient) {}

   /* ---------- STUDENT ---------- */

  getStudents(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/students`);
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
