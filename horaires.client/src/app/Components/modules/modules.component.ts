import { Component, OnInit } from '@angular/core';
import { Module } from '../../models/module.model';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-modules',
  templateUrl: './modules.component.html',
  styleUrls: ['./modules.component.css']
})
export class ModulesComponent implements OnInit {

  modules: Module[] = [];
  selectedModule: Module = {
    id: 0,
    intitule: '',
    nombreEvaluations: 0,
    nombreHeuresCours: 0,
    nombreHeuresTD: 0,
    nombreHeuresTP: 0,
    filiereId: 0
  };
  filieres: any = [];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.loadModules();
    this.loadFilieres();
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

  deleteModule(id: number): void {
    this.dataService.deleteModule(id).subscribe(
      () => {
        console.log('Module deleted successfully.');
        this.loadModules();
      },
      error => {
        console.log('Error deleting module:', error);
      }
    );
  }

  openEditModal(module: Module): void {
    this.selectedModule = { ...module }; // Copy the module object
  }

  editModule(): void {
    if (this.selectedModule) {
      this.selectedModule.filiereId = +this.selectedModule.filiereId; // Ensure filiereId is a number
      this.dataService.updateModule(this.selectedModule.id, this.selectedModule).subscribe(
        () => {
          console.log('Module updated successfully.');
          this.loadModules();
          this.resetSelectedModule();
        },
        error => {
          console.log('Error updating module:', error);
        }
      );
    }
  }

  openAddModal(): void {
    this.resetSelectedModule();
  }

  addModule(): void {
    if (this.selectedModule) {
      this.selectedModule.filiereId = +this.selectedModule.filiereId; // Ensure filiereId is a number
      this.dataService.createModule(this.selectedModule).subscribe(
        () =>{
          console.log('Module added successfully.');
          this.loadModules();
          this.resetSelectedModule();
        },
        error => {
          console.log('Error adding module:', error);
        }
      );
    }
  }

  updateSelectedFiliereId(event: any): void {
    console.log(event.target.value);
    const selectedFiliereId = event?.target?.value;
    if (selectedFiliereId !== undefined) {
      this.selectedModule.filiereId = selectedFiliereId;
    }
  }



  resetSelectedModule(): void {
    this.selectedModule = {
      id: 0,
      intitule: '',
      nombreEvaluations: 0,
      nombreHeuresCours: 0,
      nombreHeuresTD: 0,
      nombreHeuresTP: 0,
      filiereId: 0
    };
  }
}
