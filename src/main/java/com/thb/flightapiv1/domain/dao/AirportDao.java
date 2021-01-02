package com.thb.flightapiv1.domain.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thb.flightapiv1.domain.bean.Airport;

@Repository
public interface AirportDao extends JpaRepository<Airport, String> {

	
	
}
