import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  {
    path: 'login',
    loadComponent: () =>
      import('./login/login').then(m => m.LoginComponent)
  },
  {
    path: 'dashboard',
    loadComponent: () =>
      import('./dashboard/dashboard').then(m => m.DashboardComponent)
  },
  {
    path: 'college',
    loadComponent: () =>
      import('./college/college').then(m => m.CollegeComponent)
  },
  {
    path: 'student',
    loadComponent: () =>
      import('./student/student').then(m => m.StudentComponent)
  },
  {
    path: 'placement',
    loadComponent: () =>
      import('./placement/placement').then(m => m.PlacementComponent)
  }
];
