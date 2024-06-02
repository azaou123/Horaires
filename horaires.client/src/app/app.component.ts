


import { Component, OnInit, OnDestroy } from '@angular/core';
import { ScriptLoaderService } from './services/script-loader.service';
import { AuthService } from './services/auth.service'; // Import AuthService
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [
    './app.component.css',
    '../assets/css/bootstrap.min.css',
    '../assets/style.css',
    '../assets/css/responsive.css',
    '../assets/css/color_2.css',
    '../assets/css/bootstrap-select.css',
    '../assets/css/perfect-scrollbar.css',
    '../assets/css/custom.css'
  ]
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'horaires.client';
  isLoggedIn: boolean = false; // Flag to indicate whether the user is logged in
  private authSubscription: Subscription | undefined;

  constructor(
    private scriptLoaderService: ScriptLoaderService,
    private authService: AuthService, private router: Router // Inject AuthService
  ) { }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  ngOnInit(): void {
    this.authSubscription = this.authService.isLoggedIn().subscribe((loggedIn: boolean) => {
      this.isLoggedIn = loggedIn;
    });

    this.scriptLoaderService.loadScript('assets/js/jquery.min.js').then(() => {
    }).catch(error => console.log('Error loading jQuery:', error));
    this.scriptLoaderService.loadScript('assets/js/jquery.min.js').then(() => {
    }).catch(error => console.log('Error loading jQuery:', error));
    this.scriptLoaderService.loadScript('assets/js/popper.min.js').then(() => {
    }).catch(error => console.log('Error loading Popper.js:', error));
    this.scriptLoaderService.loadScript('assets/js/bootstrap.min.js').then(() => {
    }).catch(error => console.log('Error loading Bootstrap:', error));
    this.scriptLoaderService.loadScript('assets/js/animate.js').then(() => {
    }).catch(error => console.log('Error loading Animate.js:', error));
    this.scriptLoaderService.loadScript('assets/js/bootstrap-select.js').then(() => {
    }).catch(error => console.log('Error loading Bootstrap Select:', error));
    this.scriptLoaderService.loadScript('assets/js/owl.carousel.js').then(() => {
    }).catch(error => console.log('Error loading Owl Carousel:', error));
    this.scriptLoaderService.loadScript('assets/js/Chart.min.js').then(() => {
    }).catch(error => console.log('Error loading Chart.js:', error));
    this.scriptLoaderService.loadScript('assets/js/utils.js').then(() => {
    }).catch(error => console.log('Error loading Utils.js:', error));
    this.scriptLoaderService.loadScript('assets/js/analyser.js').then(() => {
    }).catch(error => console.log('Error loading Analyser.js:', error));
    this.scriptLoaderService.loadScript('assets/js/perfect-scrollbar.min.js').then(() => {
    }).catch(error => console.log('Error loading Perfect Scrollbar:', error));
    this.scriptLoaderService.loadScript('assets/js/custom.js').then(() => {
    }).catch(error => console.log('Error loading Custom.js:', error));
    this.scriptLoaderService.loadScript('assets/js/chart_custom_style1.js').then(() => {
    }).catch(error => console.log('Error loading Chart Custom Style 1:', error));
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
  }
}
