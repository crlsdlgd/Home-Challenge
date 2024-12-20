import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InterruptSchedule } from '../../models/interruptSchedule';
import { InterruptScheduleService } from '../../services/interrupt-schedule.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-admin',
  standalone: false,

  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css',
})
export class AdminComponent implements OnInit {
  updateForm: FormGroup;
  scheduleInfo: InterruptSchedule;
  options: google.maps.MapOptions = {
    center: { lat: -0.1854213, lng: -78.4748304 },
    zoom: 11,
  };

  constructor(
    private fb: FormBuilder,
    private scheduleService: InterruptScheduleService
  ) {}

  ngOnInit(): void {
    this.updateForm = this.fb.group({
      sectorName: ['', [Validators.required]],
      startHour: [
        '',
        [Validators.required, Validators.pattern('^[0-9]{1,2}$')],
      ],
      endHour: ['', [Validators.required, Validators.pattern('^[0-9]{1,2}$')]],
      polygonSector: ['', []],
    });
  }

  onSubmit(): void {
    if (this.updateForm.valid) {
      this.scheduleService.saveSchedule(this.updateForm.value).subscribe({
        next: () => {
          this.showAlert('Horario creado correctamente', 'success');
        },
        error: (error) => {
          this.showAlert('Error al crear el horario', 'error');
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
