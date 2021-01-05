package com.thb.flightapiv1.domain.service;

import com.thb.flightapiv1.domain.bean.Flight;
import com.thb.flightapiv1.domain.bean.Geo;

public interface GeoService {

	
	public void saveGeo(Geo geo);
	
	public Geo save(String Longitude, String Latitude, Flight flight);
	
	public String getLand(String lat, String lng);
}
