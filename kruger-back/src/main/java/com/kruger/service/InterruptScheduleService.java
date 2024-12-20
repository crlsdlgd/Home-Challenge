package com.kruger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.kruger.models.InterruptSchedule;
import com.kruger.repository.InterruptScheduleRepository;

@Service
public class InterruptScheduleService {

	@Autowired
    private InterruptScheduleRepository repository;
	
	public InterruptSchedule saveSchedule(InterruptSchedule schedule) {
		return repository.save(schedule);
	};
}
