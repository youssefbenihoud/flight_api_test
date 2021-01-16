package com.thb.flightapiv1.domain.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String serial;
	private String flightCode;
	private String squawk;
	@OneToMany(mappedBy = "flight")
	private List<Geo> geos;
	@ManyToOne
	private Plane plane;
	
	
	
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		if(flightCode.isEmpty())
			flightCode = "Unknown";
		this.flightCode = flightCode;
	}
	public String getSquawk() {
		return squawk;
	}
	public void setSquawk(String squawk) {
		this.squawk = squawk;
	}
	public List<Geo> getGeos() {
		return geos;
	}
	public void setGeos(List<Geo> geos) {
		this.geos = geos;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	
	
	
	
}
