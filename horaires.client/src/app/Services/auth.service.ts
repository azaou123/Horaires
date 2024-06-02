import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn: BehaviorSubject<boolean>;
  private apiUrl = environment.apiUrl;
  private userType: BehaviorSubject<string | null>;

  constructor(private http: HttpClient) {
    const loggedInStatus = localStorage.getItem('loggedIn');
    const userType = localStorage.getItem('userType');
    this.loggedIn = new BehaviorSubject<boolean>(loggedInStatus === 'true');
    this.userType = new BehaviorSubject<string | null>(userType);
  }

  // Method to log in the user
  login(email: string, password: string, userType: string): Observable<HttpResponse<string>> {
    const endpoint = `${this.apiUrl}/auth/${userType}`;
    return this.http.post(endpoint, { email, password }, { observe: 'response', responseType: 'text' })
      .pipe(
        tap(
          (response: HttpResponse<string>) => {
            if (response.status === 200) {
              this.setLoggedIn(true);
              this.setUserType(userType); // Notify subscribers about successful login and persist state
              console.log('Login successful:', response.body);
            }
          },
          error => {
            this.setLoggedIn(false); // Notify subscribers about failed login
            this.setUserType(null);
            console.error('Login failed:', error);
          }
        )
      );
  }

  // Method to log out the user
  logout(): void {
    this.setLoggedIn(false);
    this.setUserType(null);
  }

  // Method to check if the user is logged in
  isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  // Method to get user type
  getUserType(): Observable<string | null> {
    return this.userType.asObservable();
  }

  // Helper method to update loggedIn state and local storage
  private setLoggedIn(value: boolean): void {
    this.loggedIn.next(value);
    localStorage.setItem('loggedIn', value.toString());
  }

  // Helper method to update user type state and local storage
  private setUserType(type: string | null): void {
    this.userType.next(type);
    if (type) {
      localStorage.setItem('userType', type);
    } else {
      localStorage.removeItem('userType');
    }
  }
}
