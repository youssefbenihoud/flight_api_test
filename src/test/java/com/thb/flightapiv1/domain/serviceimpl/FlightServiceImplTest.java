package com.thb.flightapiv1.domain.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.thb.flightapiv1.domain.bean.Flight;

class FlightServiceImplTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void testSaveFlight() {
		FlightServiceImpl flightServiceImpl = new FlightServiceImpl();
		
		Flight flight = new Flight();
		flight.setFlightCode("flightIDXXX");
		flight.setSquawk("1000");
		flightServiceImpl.saveFlight(flight);
	}

}
