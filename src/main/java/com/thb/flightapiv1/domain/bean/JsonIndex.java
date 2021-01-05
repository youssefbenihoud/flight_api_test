package com.thb.flightapiv1.domain.bean;

public enum JsonIndex {

	
Hexcode(0,"hexcode"),Latitude(1,"latitude"),Longitude(2,"longitude"),Manifacturer(8,"manifacturer"),Squawk(6,"squawk"),DepartAirport(11,"departAirport"), ArriveAirport(12,"arriveAirport"),FlightCode(16,"flightCode"), Airline(18,"airline"), FlightId(-1,"flightId");
	
	private int index;
	private String name;
	
	

	public int getIndex() {
		return index;
	}
	
	public String getName() {
		return name;
	}
	
	JsonIndex(int index, String name) {
		this.index = index;
		this.name = name;
	}
	
	
}
