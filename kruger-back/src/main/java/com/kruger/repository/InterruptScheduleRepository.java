package com.kruger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kruger.models.InterruptSchedule;

@Repository
public interface InterruptScheduleRepository extends JpaRepository<InterruptSchedule, Long> {

}
