/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FilieresComponent } from './filieres.component';

describe('FilieresComponent', () => {
  let component: FilieresComponent;
  let fixture: ComponentFixture<FilieresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilieresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilieresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
