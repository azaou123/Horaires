export interface Professeur {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  password: string;
  interventionIds: number[];
}

export class ProfesseurClass implements Professeur {
  constructor(
    public id: number,
    public nom: string,
    public prenom: string,
    public email: string,
    public password: string,
    public interventionIds: number[]
  ) {}
}
