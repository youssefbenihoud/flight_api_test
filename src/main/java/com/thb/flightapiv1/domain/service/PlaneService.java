package com.thb.flightapiv1.domain.service;

import com.thb.flightapiv1.domain.bean.Plane;

public interface PlaneService {

	
	public void savePlane(Plane plane);
	public Plane save(String hexcode, String manufacturer, String airline);
	
}
