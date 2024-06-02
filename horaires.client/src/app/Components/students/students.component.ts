import { Component, OnInit } from '@angular/core';
import { EtudiantService } from '../../services/etudiant.service';
import { Etudiant } from '../../models/etudiant.model';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  etudiants: Etudiant[] = [];
  newEtudiant: Etudiant = { id: 0, nom: '', prenom: '', email: '', password: 'hello@123', filiereId: 0 };
  filieres: any = [];
  selectedEtudiant: Etudiant = { id: 0, nom: '', prenom: '', email: '', password: 'hello@123', filiereId: 0 };

  constructor(private etudiantService: EtudiantService, private dataService: DataService) { }

  ngOnInit(): void {
    this.loadEtudiants();
    this.loadFilieres();
  }

  loadEtudiants(): void {
    this.etudiantService.getAllEtudiants().subscribe(
      data => {
        this.etudiants = data;
      },
      error => {
        console.error('Error fetching students', error);
      }
    );
  }

  loadFilieres(): void {
    this.dataService.getFilieres().subscribe(
      data => {
        this.filieres = data;
      },
      error => {
        console.error('Error fetching filieres', error);
      }
    );
  }

  addEtudiant(): void {
    this.etudiantService.createEtudiant(this.newEtudiant).subscribe(
      () => {
        console.log('Student added successfully');
        this.loadEtudiants();
        this.newEtudiant = { id: 0, nom: '', prenom: '', email: '', password: 'hello@123', filiereId: 0 };
      },
      error => {
        console.error('Error adding student', error);
      }
    );
  }

  editEtudiant(etudiant: Etudiant): void {
    this.selectedEtudiant = { ...etudiant };
  }

  updateEtudiant(): void {
    if (this.selectedEtudiant) {
      this.etudiantService.updateEtudiant(this.selectedEtudiant.id, this.selectedEtudiant).subscribe(
        () => {
          console.log('Student updated successfully');
          this.loadEtudiants();
          this.selectedEtudiant = { id: 0, nom: '', prenom: '', email: '', password: 'hello@123', filiereId: 0 };
          const closeButton = document.querySelector('#editEtudiantModal .btn-close');
          if (closeButton) {
            closeButton.dispatchEvent(new MouseEvent('click', { bubbles: true }));
          }
        },
        error => {
          console.error('Error updating student', error);
        }
      );
    }
  }

  deleteEtudiant(id: number): void {
    this.etudiantService.deleteEtudiant(id).subscribe(
      () => {
        console.log('Student deleted successfully');
        this.loadEtudiants();
      },
      error => {
        console.error('Error deleting student', error);
      }
    );
  }
}
