package com.thb.flightapiv1.domain.serviceimpl;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thb.flightapiv1.domain.bean.Plane;
import com.thb.flightapiv1.domain.dao.PlaneDao;
import com.thb.flightapiv1.domain.service.PlaneService;
import com.thb.flightapiv1.util.EmailUtil;


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
	
	
	public void sendNotfallEmail() {
		try {
			EmailUtil.sendMail("Test Message", "benihoud@mail.uni-paderborn.de", "Test Subject");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PlaneDao getPlaneDao() {
		return planeDao;
	}

	public void setPlaneDao(PlaneDao planeDao) {
		this.planeDao = planeDao;
	}
	
	

}
