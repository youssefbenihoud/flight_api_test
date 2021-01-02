package com.thb.flightapiv1.domain.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thb.flightapiv1.domain.bean.Flight;
import com.thb.flightapiv1.domain.service.FlightService;

@RestController
@RequestMapping("/flight-api/flights")
public class FlightRest {

	@Autowired
	private FlightService flightService;
	
	
	

	@PostMapping("/")
	public void saveFlight(@RequestBody Flight flight) {
		flightService.saveFlight(flight);
	}
	
	
	@PostMapping("/getJSON/")
	public void saveJsonData() {
		flightService.getJSONDaten();
	}
	

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}
	
	
	
}
