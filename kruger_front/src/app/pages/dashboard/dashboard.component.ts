import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../auth/auth.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-dashboard',
  standalone: false,

  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export class DashboardComponent implements OnInit {
  userRole: string = '';
  constructor(private auth: AuthService, private router: Router) {}
  ngOnInit(): void {
    this.auth.getUserInfo().subscribe(
      (user : User) => {
        this.userRole = user.role;
        if (this.userRole === 'ADMIN') {
          this.router.navigate(['/admin']);
        } else if (this.userRole === 'CLIENT') {  
          this.router.navigate(['/client']);
        } else {
          console.error('Rol desconocido');
        }
      },
      (error) => {
        console.error('Error al obtener la información del usuario', error);
        this.router.navigate(['/login']);
      }
    );
  }
}
