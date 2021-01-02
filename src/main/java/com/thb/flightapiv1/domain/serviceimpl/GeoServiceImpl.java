package com.thb.flightapiv1.domain.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thb.flightapiv1.domain.bean.Flight;
import com.thb.flightapiv1.domain.bean.Geo;
import com.thb.flightapiv1.domain.dao.GeoDao;
import com.thb.flightapiv1.domain.service.GeoService;


@Service
public class GeoServiceImpl implements GeoService{

	
	@Autowired
	private GeoDao geoDao;
	
	@Override
	public void saveGeo(Geo geo) {
		// TODO Auto-generated method stub
		if(geo != null)
			geoDao.save(geo);
	}

	@Override
	public Geo save(String Longitude, String Latitude, Flight flight) {
		// TODO Auto-generated method stub
		Geo geo = new Geo();
		geo.setLatitude(Latitude);
		geo.setLongitude(Longitude);
		geo.setFlight(flight);
		geoDao.save(geo);
		
		return geo;
	}

	public GeoDao getGeoDao() {
		return geoDao;
	}

	public void setGeoDao(GeoDao geoDao) {
		this.geoDao = geoDao;
	}

	
	
}
