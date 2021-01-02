package com.thb.flightapiv1.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thb.flightapiv1.domain.bean.ArriveAirport;

@Repository
public interface ArriveAirportDao extends JpaRepository<ArriveAirport, Long> {

	
	public ArriveAirport findByFlight(String flight);
}
