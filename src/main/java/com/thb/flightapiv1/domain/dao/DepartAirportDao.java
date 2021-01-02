package com.thb.flightapiv1.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thb.flightapiv1.domain.bean.DepartAirport;

@Repository
public interface DepartAirportDao extends JpaRepository<DepartAirport, Long> {

		public DepartAirport findByFlight(String flight);
}
