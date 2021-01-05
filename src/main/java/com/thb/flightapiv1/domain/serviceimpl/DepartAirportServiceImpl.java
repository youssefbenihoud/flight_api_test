package com.thb.flightapiv1.domain.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.thb.flightapiv1.domain.bean.DepartAirport;

import com.thb.flightapiv1.domain.dao.DepartAirportDao;
import com.thb.flightapiv1.domain.service.DepartAirportService;

@Service
public class DepartAirportServiceImpl implements DepartAirportService {

	@Autowired
	private DepartAirportDao departAirportDao;

	@Override
	public DepartAirport save(String flight, String airport) {
		// TODO Auto-generated method stub
		DepartAirport departAirport = departAirportDao.findByFlight(flight);
		if(departAirport == null){
		departAirport = new DepartAirport();
		}
		departAirport.setAirport(airport);
		departAirport.setFlight(flight);
		departAirportDao.save(departAirport);
		return departAirport;
	}
	
	@Override
	public String findAirportByFlight(String flight) {
		// TODO Auto-generated method stub
		return departAirportDao.findByFlight(flight).getAirport();
	}

	
	
	
	
	
	
	
	public DepartAirportDao getDepartAirportDao() {
		return departAirportDao;
	}

	public void setDepartAirportDao(DepartAirportDao departAirportDao) {
		this.departAirportDao = departAirportDao;
	}
	
	
	
}
