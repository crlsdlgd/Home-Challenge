import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8080/api/v1/user';

  constructor(private http: HttpClient) { }

  getUserInfo(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/info`, { withCredentials: true });
  }

  isAuthenticated(): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/auth`, { withCredentials: true });
  }

  logout(): void {
    localStorage.removeItem('token');
  }
}
