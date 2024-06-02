import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

import { Professeur } from '../models/professeur.model';

import { Observable } from 'rxjs';
import { Module } from '../models/module.model';
import { Intervention } from '../models/intervention.model';


@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  // Etudiant methods
  getEtudiants() {
    return this.http.get(`${this.apiUrl}/etudiant`);
  }

  updateEtudiant(id: number, etudiant: any) {
    return this.http.put(`${this.apiUrl}/etudiant/${id}`, etudiant);
  }

  deleteEtudiant(id: number) {
    return this.http.delete(`${this.apiUrl}/etudiant/${id}`);
  }

  // Filiere methods
  getFilieres() {
    return this.http.get(`${this.apiUrl}/filieres`);
  }

  createFiliere(filiere: any) {
    return this.http.post(`${this.apiUrl}/filieres`, filiere);
  }

  updateFiliere(id: number, filiere: any) {
    return this.http.put(`${this.apiUrl}/filieres/${id}`, filiere);
  }

  deleteFiliere(id: number) {
    return this.http.delete(`${this.apiUrl}/filieres/${id}`);
  }


  createProfesseur(professeur: Professeur): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/professeurs`, professeur);
  }

  getAllProfesseurs(): Observable<Professeur[]> {
    return this.http.get<Professeur[]>(`${this.apiUrl}/professeurs`);
  }

  getProfesseurById(id: number): Observable<Professeur> {
    return this.http.get<Professeur>(`${this.apiUrl}/professeurs/${id}`);
  }

  updateProfesseur(id: number, professeur: Professeur): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/professeurs/${id}`, professeur);
  }

  deleteProfesseur(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/professeurs/${id}`);
  }


  createModule(module: Module): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/modules`, module);
  }

  getAllModules(): Observable<Module[]> {
    return this.http.get<Module[]>(`${this.apiUrl}/modules`);
  }

  getModuleById(id: number): Observable<Module> {
    return this.http.get<Module>(`${this.apiUrl}/modules/${id}`);
  }

  updateModule(id: number, module: Module): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/modules/${id}`, module);
  }

  deleteModule(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/modules/${id}`);
  }



  createIntervention(intervention: Intervention): Observable<Intervention> {
    return this.http.post<Intervention>(`${this.apiUrl}/interventions`, intervention);
  }

  getAllInterventions(): Observable<Intervention[]> {
    return this.http.get<Intervention[]>(`${this.apiUrl}/interventions`);
  }

  getInterventionById(id: number): Observable<Intervention> {
    return this.http.get<Intervention>(`${this.apiUrl}/interventions/${id}`);
  }

  updateIntervention(id: number, intervention: Intervention): Observable<Intervention> {
    return this.http.put<Intervention>(`${this.apiUrl}/interventions/${id}`, intervention);
  }

  deleteIntervention(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/interventions/${id}`);
  }
}
