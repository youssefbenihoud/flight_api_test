package com.thb.flightapiv1.domain.service;

import com.thb.flightapiv1.domain.bean.Airport;

public interface AirportService {

	public void saveAirport(Airport airport);
	public Airport save(String shortcut);
}
