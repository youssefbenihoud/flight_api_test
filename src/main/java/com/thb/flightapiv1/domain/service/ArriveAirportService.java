package com.thb.flightapiv1.domain.service;


import com.thb.flightapiv1.domain.bean.ArriveAirport;


public interface ArriveAirportService {

	public ArriveAirport save(String flight, String airport);
	
	public String findAirportByFlight(String flight);
}
