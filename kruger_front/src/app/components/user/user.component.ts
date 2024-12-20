import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user',
  standalone: false,
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit {
  user: User;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    // Probar obteniendo un usuario por ID
    this.userService.getUserById(1).subscribe({
      next: (response) => {
        console.log('Usuario obtenido:', response);
        this.user = response;
      },
      error: (error) => {
        console.error('Error al obtener el usuario:', error);
      },
    });
  }
}
