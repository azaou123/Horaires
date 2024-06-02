import { DataService } from './../../services/data.service';
// src/app/components/interventions/interventions.component.ts
import { Component, OnInit } from '@angular/core';
import { Intervention } from '../../models/intervention.model';
import { Professeur } from 'src/app/models/professeur.model';
import { Module } from 'src/app/models/module.model';

@Component({
  selector: 'app-interventions',
  templateUrl: './interventions.component.html',
  styleUrls: ['./interventions.component.css']
})
export class InterventionsComponent implements OnInit {

  interventions: Intervention[] = [];
  modules: Module[] = [];
  viewMode: string = 'table'; // Default view mode
  professeurs: Professeur[] = [];
  newIntervention: Intervention = {
    id: 0,
    intitule: '', // Add other properties as needed
    nombreEvaluationsInter: 0,
    nombreHeuresCoursInter: 0,
    nombreHeuresTDInter: 0,
    nombreHeuresTPInter: 0,
    moduleId: 0,
    professeurId: 0
  };
  selectedIntervention: Intervention = {
    id: 0,
    intitule: '',
    nombreEvaluationsInter: 0,
    nombreHeuresCoursInter: 0,
    nombreHeuresTDInter: 0,
    nombreHeuresTPInter: 0,
    moduleId: 0,
    professeurId: 0
  };


  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.loadInterventions();
    this.loadProfesseurs();
    this.loadModules();
  }

  addIntervention(): void {
    this.dataService.createIntervention(this.newIntervention).subscribe(
      () => {
        console.log('Intervention added successfully.');
        this.loadInterventions(); // Reload interventions after adding a new one
        // Optionally, reset the newIntervention object to clear the form fields
        this.newIntervention = {
          id: 0,
          intitule: '', // Reset other properties as needed
          nombreEvaluationsInter: 0,
          nombreHeuresCoursInter: 0,
          nombreHeuresTDInter: 0,
          nombreHeuresTPInter: 0,
          moduleId: 0,
          professeurId: 0
        };
      },
      error => {
        console.log('Error adding intervention:', error);
      }
    );
  }

  editIntervention(intervention: Intervention): void {
    // Assign the selected intervention to the selectedIntervention property
    this.selectedIntervention = { ...intervention };
  }

  saveEditedIntervention(): void {
    this.dataService.updateIntervention(this.selectedIntervention.id,this.selectedIntervention).subscribe(
      () => {
        console.log('Intervention updated successfully.');
        this.loadInterventions(); // Reload interventions after updating
        // Optionally, reset the selectedIntervention object to clear the form fields
        this.selectedIntervention = {
          id: 0,
          intitule: '',
          nombreEvaluationsInter: 0,
          nombreHeuresCoursInter: 0,
          nombreHeuresTDInter: 0,
          nombreHeuresTPInter: 0,
          moduleId: 0,
          professeurId: 0
        };
      },
      error => {
        console.log('Error updating intervention:', error);
      }
    );
  }





  loadModules(): void {
    this.dataService.getAllModules().subscribe(
      modules => {
        this.modules = modules;
      },
      error => {
        console.log('Error fetching modules:', error);
      }
    );
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

  loadInterventions(): void {
    this.dataService.getAllInterventions().subscribe(
      interventions => {
        this.interventions = interventions;
      },
      error => {
        console.log('Error fetching interventions:', error);
      }
    );
  }

  deleteIntervention(id: number): void {
    this.dataService.deleteIntervention(id).subscribe(
      () => {
        console.log('Intervention deleted successfully.');
        this.loadInterventions();
      },
      error => {
        console.log('Error deleting intervention:', error);
      }
    );
  }

  changeViewMode(mode: string): void {
    this.viewMode = mode;
  }

  interventionExists(professeurId: number, moduleId: number): boolean {
    // Obtenez toutes les interventions
    const interventions = this.interventions;

    // Parcourez toutes les interventions
    for (const intervention of interventions) {
      // Vérifiez si l'intervention correspond au professeur et au module donnés
      if (intervention.professeurId === professeurId && intervention.moduleId === moduleId) {
        return true; // L'intervention existe
      }
    }

    return false; // Aucune intervention correspondante trouvée
  }

  getNumberOfHours(professeurId: number, moduleId: number): number {
    // Find the intervention matching the provided professeurId and moduleId
    const intervention = this.interventions.find(int => int.professeurId === professeurId && int.moduleId === moduleId);

    if (intervention) {
      // Calculate the total number of hours
      const totalHours = intervention.nombreHeuresCoursInter + intervention.nombreHeuresTDInter + intervention.nombreHeuresTPInter;
      return totalHours;
    } else {
      return 0; // Return 0 if no intervention is found
    }
  }


}
