package com.kruger.models;

import org.locationtech.jts.geom.Polygon;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="interrupt_schedule")
public class InterruptSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "start_hour")
	private Integer startHour;
	
	@Column(name = "end_hour")
	private Integer endHour;
	
	@Column(name = "sector_name")
	private String sectorName;
	
	@Column(name = "sector_polygon")
	private Polygon sectorPolygon;
	
	public InterruptSchedule() {
		super();
	}
	
	public InterruptSchedule(Long id, Integer startHour, Integer endHour, String sectorName, Polygon sectorPolygon) {
		super();
		this.id = id;
		this.startHour = startHour;
		this.endHour = endHour;
		this.sectorName = sectorName;
		this.sectorPolygon = sectorPolygon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public Polygon getSectorPolygon() {
		return sectorPolygon;
	}

	public void setSectorPolygon(Polygon sectorPolygon) {
		this.sectorPolygon = sectorPolygon;
	}
}
