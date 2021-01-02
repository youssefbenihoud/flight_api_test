package com.thb.flightapiv1.domain.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thb.flightapiv1.domain.bean.Airport;
import com.thb.flightapiv1.domain.bean.ArriveAirport;
import com.thb.flightapiv1.domain.bean.Flight;
import com.thb.flightapiv1.domain.dao.ArriveAirportDao;
import com.thb.flightapiv1.domain.service.ArriveAirportService;

@Service
public class ArriveAirportServiceImpl implements ArriveAirportService {

	
	@Autowired
	private ArriveAirportDao arriveAirportDao;
	
	@Override
	public ArriveAirport save(String flight, String airport) {
		// TODO Auto-generated method stub
		ArriveAirport arriveAirport = arriveAirportDao.findByFlight(flight);
		System.out.print("arriveAirport == "+arriveAirport);
		if(arriveAirport == null) {
			arriveAirport = new ArriveAirport();
		}
		arriveAirport.setAirport(airport);
		arriveAirport.setFlight(flight);
		arriveAirportDao.save(arriveAirport);
		return arriveAirport;
	}
	
	

	@Override
	public String findAirportByFlight(String flight) {
		// TODO Auto-generated method stub
		return arriveAirportDao.findByFlight(flight).getAirport();
	}



	public ArriveAirportDao getArriveAirportDao() {
		return arriveAirportDao;
	}

	public void setArriveAirportDao(ArriveAirportDao arriveAirportDao) {
		this.arriveAirportDao = arriveAirportDao;
	}
	
	
	

}
