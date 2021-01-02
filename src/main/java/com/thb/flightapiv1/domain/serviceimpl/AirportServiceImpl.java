package com.thb.flightapiv1.domain.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thb.flightapiv1.domain.bean.Airport;
import com.thb.flightapiv1.domain.dao.AirportDao;
import com.thb.flightapiv1.domain.service.AirportService;


@Service
public class AirportServiceImpl implements AirportService{

	
	@Autowired
	private AirportDao airportDao;
	
	@Override
	public void saveAirport(Airport airport) {
		// TODO Auto-generated method stub
		if(airport != null)
			airportDao.save(airport);
	}

	@Override
	public Airport save(String shortcut) {
		// TODO Auto-generated method stub
		Airport airport = new Airport();
		if(airportDao.findById(shortcut).isEmpty() ) {
		//airport.setName(name);
		airport.setShortcut(shortcut);
		airportDao.save(airport);
		return airport;
		}else {
			return airportDao.getOne(shortcut);
		}
		
	}

}
