package com.thb.flightapiv1.domain.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Plane {

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	private String hexcode;
	private String manufacturer;
	private String airline;
	@OneToMany(mappedBy = "plane")
	private List<Flight> flights;
	
	
	
	public Plane() {
		
	}
	
	public Plane(String hexcode, String manufacturer, String airline){
		this.hexcode = hexcode;
		this.manufacturer = manufacturer;
		this.airline = airline;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHexcode() {
		return hexcode;
	}
	public void setHexcode(String hexcode) {
		this.hexcode = hexcode;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		if(manufacturer.isEmpty())
			manufacturer = "NONE";
		this.manufacturer = manufacturer;
	}
	public String getAirline() {
		return airline;
	}
	
	
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	public void setAirline(String airline) {
		if(airline.isEmpty())
			airline = "NONE";
		this.airline = airline;
	}
	
	
	
}
