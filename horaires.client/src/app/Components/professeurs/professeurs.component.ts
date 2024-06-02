// professeurs.component.ts
import { Component, OnInit } from '@angular/core';
import { Professeur, ProfesseurClass } from '../../models/professeur.model';
import { DataService } from './../../services/data.service';

@Component({
  selector: 'app-professeurs',
  templateUrl: './professeurs.component.html',
  styleUrls: ['./professeurs.component.css']
})
export class ProfesseursComponent implements OnInit {

  professeurs: Professeur[] = [];
  selectedProfesseur: ProfesseurClass = new ProfesseurClass(0, '', '', '', '', []);

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.loadProfesseurs();
  }

  loadProfesseurs(): void {
    this.dataService.getAllProfesseurs().subscribe(
      professeurs => {
        this.professeurs = professeurs;
      },
      error => {
        console.log('Error fetching professeurs:', error);
      }
    );
  }

  deleteProfesseur(id: number): void {
    this.dataService.deleteProfesseur(id).subscribe(
      () => {
        console.log('Professeur deleted successfully.');
        this.loadProfesseurs();
      },
      error => {
        console.log('Error deleting professeur:', error);
      }
    );
  }

  openEditModal(professeur: Professeur): void {
    this.selectedProfesseur = new ProfesseurClass(professeur.id, professeur.nom, professeur.prenom, professeur.email, professeur.password, professeur.interventionIds);
  }

  editProfesseur(): void {
    if (this.selectedProfesseur) {
      this.dataService.updateProfesseur(this.selectedProfesseur.id, this.selectedProfesseur).subscribe(
        () => {
          console.log('Professeur updated successfully.');
          this.loadProfesseurs();
          this.selectedProfesseur = new ProfesseurClass(0, '', '', '', '', []);
        },
        error => {
          console.log('Error updating professeur:', error);
        }
      );
    }
  }

  openAddModal(): void {
    this.selectedProfesseur = new ProfesseurClass(0, '', '', '', '', []);
  }

  addProfesseur(): void {
    if (this.selectedProfesseur) {
      this.dataService.createProfesseur(this.selectedProfesseur).subscribe(
        () => {
          console.log('Professeur added successfully.');
          this.loadProfesseurs();
          this.selectedProfesseur = new ProfesseurClass(0, '', '', '', '', []);
        },
        error => {
          console.log('Error adding professeur:', error);
        }
      );
    }
  }
}
