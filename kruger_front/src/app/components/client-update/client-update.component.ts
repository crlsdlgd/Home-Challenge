import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../auth/auth.service';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-client-update',
  standalone: false,
  templateUrl: './client-update.component.html',
  styleUrl: './client-update.component.css',
})
export class ClientUpdateComponent implements OnInit {
  updateForm: FormGroup;
  userRole: string;
  userInfo: User;
  options: google.maps.MapOptions = {
    center: { lat: -0.1854213, lng: -78.4748304 },
    zoom: 11,
  };

  markerPosition: google.maps.LatLngLiteral = {
    lat: -0.1854213,
    lng: -78.4748304,
  };
  markerOptions: google.maps.MarkerOptions = { draggable: true };

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.authService.getUserInfo().subscribe((user: User) => {
      this.userInfo = user;
      this.userRole = user.role;

      // Prellenar el formulario con los datos del usuario
      this.updateForm = this.fb.group({
        id: [this.userInfo.id || '', []],
        firstName: [this.userInfo.firstName || '', Validators.required],
        lastName: [this.userInfo.lastName || '', Validators.required],
        cedula: [this.userInfo.cedula || '', Validators.required],
        email: [this.userInfo.email || '', []],
        role: [this.userInfo.role || '', []],
        lng: [this.userInfo.lng || this.markerPosition.lng, []],
        lat: [this.userInfo.lat || this.markerPosition.lat, []],
      });

      this.markerPosition = {
        lat: this.userInfo.lat || this.markerPosition.lat,
        lng: this.userInfo.lng || this.markerPosition.lng,
      };
    });
  }

  onMarkerDragEnd(event: google.maps.MapMouseEvent) {
    if (event.latLng) {
      this.markerPosition = {
        lat: event.latLng.lat(),
        lng: event.latLng.lng(),
      };
      this.updateForm.patchValue({
        lng: this.markerPosition.lng,
        lat: this.markerPosition.lat,
      });
      console.log('Nueva posición del marcador:', this.markerPosition);
    }
  }

  onSubmit(): void {
    if (this.updateForm.valid) {
      this.userService.updateUser(this.updateForm.value).subscribe({
        next: () => {
          this.showAlert('Información actualizada correctamente', 'success');
        },
        error: (error) => {
          this.showAlert('Error al actualizar la información', 'error');
        },
      });
    }
  }

  showAlert(message: string, icon: string) {
    Swal.fire({
      icon: icon === 'error' ? 'error' : 'success',
      title: message,
      showConfirmButton: false,
      timer: 2000,
    });
  }
}
