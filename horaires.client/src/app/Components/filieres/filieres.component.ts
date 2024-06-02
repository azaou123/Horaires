import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DataService } from '../../services/data.service';
import { Filiere } from '../../models/filiere.model';

@Component({
  selector: 'app-filiere',
  templateUrl: './filieres.component.html',
  styleUrls: ['./filieres.component.css']
})
export class FiliereComponent implements OnInit {
  filieres: Filiere[] = [];
  editFiliereForm: FormGroup;
  addFiliereForm: FormGroup;
  selectedFiliere: Filiere | null = null;

  constructor(
    private dataService: DataService,
    private fb: FormBuilder
  ) {
    this.editFiliereForm = this.fb.group({
      nomFiliere: ['', Validators.required]
    });

    this.addFiliereForm = this.fb.group({
      nomFiliere: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadFilieres();
  }

  loadFilieres(): void {
    this.dataService.getFilieres().subscribe((data: any) => {
      this.filieres = data;
    });
  }

  openEditModal(filiere: Filiere): void {
    this.selectedFiliere = filiere;
    this.editFiliereForm.patchValue(filiere);
  }

  onSubmit(): void {
    if (this.selectedFiliere && this.editFiliereForm.valid) {
      const updatedFiliere: Filiere = {
        ...this.selectedFiliere,
        ...this.editFiliereForm.value
      };

      this.dataService.updateFiliere(updatedFiliere.id, updatedFiliere).subscribe(() => {
        this.loadFilieres();
      });
    }
  }

  onAddSubmit(): void {
    if (this.addFiliereForm.valid) {
      const newFiliere: Filiere = {
        id: 0, // You can initialize id to 0 or leave it empty
        nomFiliere: this.addFiliereForm.value.nomFiliere
      };

      this.dataService.createFiliere(newFiliere).subscribe((response: any) => {
        // Update the id with the one returned from the backend
        newFiliere.id = response.id;

        // Add the new filiere to the list of filieres
        this.filieres.push(newFiliere);
      });
    }
  }

  deleteFiliere(id: number): void {
    this.dataService.deleteFiliere(id).subscribe(() => {
      this.loadFilieres();
    });
  }
}
