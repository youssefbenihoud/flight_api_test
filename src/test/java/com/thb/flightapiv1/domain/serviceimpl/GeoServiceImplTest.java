package com.thb.flightapiv1.domain.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.thb.flightapiv1.domain.bean.Geo;

class GeoServiceImplTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void getGeo() {
		GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
		
		Geo geo = new Geo();
		geo.setLatitude("52.3904");
		geo.setLongitude("13.5210");
		geoServiceImpl.getLand(geo);
		
	}

}
