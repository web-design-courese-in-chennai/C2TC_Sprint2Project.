import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-placement',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './placement.html',
  styleUrls: ['./placement.css']
})
export class PlacementComponent {

  companies: string[] = [
    'TCS',
    'Infosys',
    'Wipro',
    'Zoho',
    'Capgemini',
    'Accenture'
  ];

  placements: any[] = [
    { id: 1, company: 'TCS', role: 'Software Engineer', year: 2026, status: 'Pending' },
    { id: 2, company: 'Zoho', role: 'Product Engineer', year: 2026, status: 'Approved' },
    { id: 3, company: 'Capgemini', role: 'Analyst', year: 2025, status: 'Pending' }
  ];

  searchText: string = '';
  selectedCompany: string = '';

  approve(id: number) {
    const p = this.placements.find(p => p.id === id);
    if (p) p.status = 'Approved';
  }

  delete(id: number) {
    this.placements = this.placements.filter(p => p.id !== id);
  }

  filteredPlacements() {
    return this.placements.filter(p =>
      (this.selectedCompany === '' || p.company === this.selectedCompany) &&
      (p.company.toLowerCase().includes(this.searchText.toLowerCase()) ||
       p.role.toLowerCase().includes(this.searchText.toLowerCase()))
    );
  }
}
