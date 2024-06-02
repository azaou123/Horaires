import { FiliereComponent } from './Components/filieres/filieres.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { LoginComponent } from './Components/login/login.component'; // Import the LoginComponent
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { RegisterComponent } from './Components/register/register.component';
import { AuthGuard } from './guards/auth.guard'; // Import the AuthGuard
import { StudentsComponent } from './Components/students/students.component';
import { ProfesseursComponent } from './Components/professeurs/professeurs.component';
import { ModulesComponent } from './Components/modules/modules.component';
import { InterventionsComponent } from './Components/interventions/interventions.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent }, // Add the login route
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] }, // Apply the AuthGuard to the dashboard route
  { path: 'students', component: StudentsComponent, canActivate: [AuthGuard] }, // Apply the AuthGuard to the dashboard route
  { path: 'filieres', component: FiliereComponent, canActivate: [AuthGuard] }, // Apply the AuthGuard to the dashboard route
  { path: 'professeurs', component: ProfesseursComponent, canActivate: [AuthGuard] }, // Apply the AuthGuard to the dashboard route
  { path: 'modules', component: ModulesComponent, canActivate: [AuthGuard] }, // Apply the AuthGuard to the dashboard route
  { path: 'interventions', component: InterventionsComponent, canActivate: [AuthGuard] }, // Apply the AuthGuard to the dashboard route
  { path: 'register', component: RegisterComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Redirect to dashboard by default
  { path: '**', redirectTo: '/login' } // Redirect to dashboard for any other unknown routes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
