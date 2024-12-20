import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InterruptSchedule } from '../models/interruptSchedule';

@Injectable({
  providedIn: 'root',
})
export class InterruptScheduleService {
  private baseUrl = 'http://localhost:8080/api/v1/schedule';

  constructor(private http: HttpClient) {}

  saveSchedule(schedule: InterruptSchedule): Observable<InterruptSchedule> {
    return this.http.post<InterruptSchedule>(`${this.baseUrl}/save`, schedule, {
      withCredentials: true,
    });
  }
}
