import { TestBed } from '@angular/core/testing';

import { InterruptScheduleService } from './interrupt-schedule.service';

describe('InterruptScheduleService', () => {
  let service: InterruptScheduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InterruptScheduleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
