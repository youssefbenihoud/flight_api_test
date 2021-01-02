package com.thb.flightapiv1.domain.service;


import com.thb.flightapiv1.domain.bean.DepartAirport;


public interface DepartAirportService {

	public DepartAirport save(String flight, String airport);
	public String findAirportByFlight(String flight);
	
	
}