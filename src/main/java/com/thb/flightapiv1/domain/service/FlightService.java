package com.thb.flightapiv1.domain.service;

import com.thb.flightapiv1.domain.bean.Flight;
import com.thb.flightapiv1.domain.bean.Plane;

public interface FlightService {

	
	public void saveFlight(Flight flight);
	
	public Flight save(String flightId, String serial, String squawk, Plane plane);
	
	public void getJSONDaten();
}
