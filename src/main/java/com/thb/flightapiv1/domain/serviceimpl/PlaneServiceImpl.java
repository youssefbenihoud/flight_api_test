package com.thb.flightapiv1.domain.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thb.flightapiv1.domain.bean.Plane;
import com.thb.flightapiv1.domain.dao.PlaneDao;
import com.thb.flightapiv1.domain.service.PlaneService;


@Service
public class PlaneServiceImpl implements PlaneService{

	
	@Autowired
	private PlaneDao planeDao;
	
	@Override
	public void savePlane(Plane plane) {
		// TODO Auto-generated method stub
		if(plane != null)
			planeDao.save(plane);
	}

	@Override
	public Plane save(String hexcode, String manufacturer, String airline) {
		// TODO Auto-generated method stub
		Plane plane = planeDao.findByHexcode(hexcode);
		if(plane == null) {
			plane = new Plane();
			plane.setAirline(airline);
		    plane.setHexcode(hexcode);
		    plane.setManufacturer(manufacturer);
		    planeDao.save(plane);
		}
		
		return plane;
	}

	public PlaneDao getPlaneDao() {
		return planeDao;
	}

	public void setPlaneDao(PlaneDao planeDao) {
		this.planeDao = planeDao;
	}
	
	

}
