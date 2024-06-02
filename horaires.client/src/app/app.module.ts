import { Module } from './models/module.model';
import { StudentsComponent } from './Components/students/students.component';
import { FiliereComponent } from './Components/filieres/filieres.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component';
import { ProfesseursComponent } from './Components/professeurs/professeurs.component';
import { ModulesComponent } from './Components/modules/modules.component';
import { InterventionsComponent } from './Components/interventions/interventions.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StudentsComponent,
    FiliereComponent,
    ProfesseursComponent,
    ModulesComponent,
    InterventionsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    BrowserModule,
    ReactiveFormsModule,
    FormsModule // Add FormsModule to the imports array
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
