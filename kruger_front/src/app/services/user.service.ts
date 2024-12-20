import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private baseUrl = 'http://localhost:8080/api/v1/user';

  constructor(private http: HttpClient) {}

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/${id}`);
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/save`, user);
  }

  updateUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/update`, user, {
      withCredentials: true,
    });
  }
}
