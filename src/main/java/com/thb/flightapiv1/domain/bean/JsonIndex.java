package com.thb.flightapiv1.domain.bean;

public enum JsonIndex {

	
Hexcode(0),Latitude(1),Longitude(2),Manifacturer(8),Squawk(6),DepartAirport(11), ArriveAirport(12),FlightCode(16), Airline(18);
	
	private int index;
	
	

	public int getIndex() {
		return index;
	}
	
	JsonIndex(int index) {
		this.index = index;
	}
	
	
}
