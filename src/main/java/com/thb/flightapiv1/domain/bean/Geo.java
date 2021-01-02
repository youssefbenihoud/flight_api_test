package com.thb.flightapiv1.domain.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Geo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String longitude;
	private String latitude;
	@ManyToOne
	private Flight flight;
	
	
	
	public Geo() {
		
	}
	
	
	
	public Geo(String longitude, String latitude, Flight flight){
		this.longitude = longitude;
		this.latitude = latitude;
		this.flight = flight;
	}
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
}
