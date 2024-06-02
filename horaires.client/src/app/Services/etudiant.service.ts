import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Etudiant } from '../models/etudiant.model'; // Assuming you have a model file for Etudiant

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  private apiUrl = `${environment.apiUrl}/etudiant`;

  constructor(private http: HttpClient) { }

  getAllEtudiants(): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(this.apiUrl);
  }

  getEtudiantById(id: number): Observable<Etudiant> {
    return this.http.get<Etudiant>(`${this.apiUrl}/${id}`);
  }

  createEtudiant(etudiant: Etudiant): Observable<any> {
    return this.http.post(this.apiUrl, etudiant);
  }

  updateEtudiant(id: number, etudiant: any) {
    return this.http.put(`${this.apiUrl}/${id}`, etudiant);
  }

  deleteEtudiant(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  addEtudiantToFiliere(etudiantId: number, filiereId: number): Observable<Etudiant> {
    return this.http.post<Etudiant>(`${this.apiUrl}/${etudiantId}/filieres/${filiereId}`, {});
  }
}
