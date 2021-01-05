package com.thb.flightapiv1.domain.serviceimpl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thb.flightapiv1.domain.bean.Flight;
import com.thb.flightapiv1.domain.bean.Geo;
import com.thb.flightapiv1.domain.dao.GeoDao;
import com.thb.flightapiv1.domain.helper.JSONHelper;
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
	
	@Override
	public String getLand(String lat, String lng) {
		JSONObject jsonObject;
		String region = "NONE";
		
		
		try {
			jsonObject = JSONHelper.readJsonFromUrl("http://api.geonames.org/countrySubdivisionJSON?lat="
		+lat+"&lng="+lng+"&username=free");
			
			
			region = jsonObject.getString("adminName1");
			
			System.out.print("Region === "+region);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("e message "+e);
		}
		
		return region;
	}
	
	
	
	
	
	
	
	
	
	
	

	public GeoDao getGeoDao() {
		return geoDao;
	}

	public void setGeoDao(GeoDao geoDao) {
		this.geoDao = geoDao;
	}

	
	
}
