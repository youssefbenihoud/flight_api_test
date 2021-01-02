package com.thb.flightapiv1.domain.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ArriveAirport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String flight;
	private String airport;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		//if(airport.isEmpty())
			//airport = "NN";
		this.airport = airport;
	}
	
	
	
	
	
}
