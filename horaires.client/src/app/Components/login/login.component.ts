import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = '';
  password: string = '';
  userType: string = 'admin'; // Default to 'admin'. This could be set via a dropdown in the template.
  loginError: string = '';

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.authService.isLoggedIn().subscribe(isLoggedIn => {
      if (isLoggedIn) {
        this.router.navigate(['/dashboard']); // Redirect if already logged in
      }
    });
  }

  onSubmit(): void {
    this.authService.login(this.email, this.password, this.userType).subscribe(
      response => {
        if (response.status === 200) {
          console.log('Login successful:', response.body);
          this.router.navigate(['/dashboard']); // Redirect to dashboard on successful login
        } else {
          this.loginError = "Authentication failed";
        }
      },
      error => {
        this.loginError = error.error || 'An unknown error occurred';
      }
    );
  }
}
