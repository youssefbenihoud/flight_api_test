package com.thb.flightapiv1.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thb.flightapiv1.domain.bean.Flight;
import com.thb.flightapiv1.domain.bean.Geo;

@Repository
public interface GeoDao extends JpaRepository<Geo, Long>{

	
	//public Geo findByFlight(Flight flight);
}
