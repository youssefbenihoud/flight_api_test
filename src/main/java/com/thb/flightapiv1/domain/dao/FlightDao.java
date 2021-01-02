package com.thb.flightapiv1.domain.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thb.flightapiv1.domain.bean.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Long> {

	public Flight findByFlightCode(String flightCode);
}
