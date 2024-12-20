package com.kruger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.models.InterruptSchedule;
import com.kruger.repository.InterruptScheduleRepository;
import com.kruger.service.InterruptScheduleService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class InterruptScheduleController {
	
	@Autowired
	private InterruptScheduleService service;
	
	@PostMapping("/schedule/save")
	public ResponseEntity<InterruptSchedule> saveSchedule(@RequestBody InterruptSchedule schedule) {
		return ResponseEntity.ok(service.saveSchedule(schedule));
	};
	
}
