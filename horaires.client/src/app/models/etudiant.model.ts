export interface Etudiant {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  password: string;
  filiereId?: any; // Optional if it can be null
}
