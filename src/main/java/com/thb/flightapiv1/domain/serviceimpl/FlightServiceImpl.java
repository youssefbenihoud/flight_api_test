package com.thb.flightapiv1.domain.serviceimpl;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thb.flightapiv1.domain.bean.Airport;
import com.thb.flightapiv1.domain.bean.Flight;
import com.thb.flightapiv1.domain.bean.JsonIndex;
import com.thb.flightapiv1.domain.bean.Plane;
import com.thb.flightapiv1.domain.dao.FlightDao;
import com.thb.flightapiv1.domain.helper.JSONHelper;
import com.thb.flightapiv1.domain.service.AirportService;
import com.thb.flightapiv1.domain.service.ArriveAirportService;
import com.thb.flightapiv1.domain.service.DepartAirportService;
import com.thb.flightapiv1.domain.service.FlightService;
import com.thb.flightapiv1.domain.service.GeoService;
import com.thb.flightapiv1.domain.service.PlaneService;


@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private PlaneService planeService;
	
	@Autowired
	private GeoService geoService;
	
	@Autowired
	private AirportService airportService;
	
	@Autowired
	private ArriveAirportService aas;
	
	@Autowired
	private DepartAirportService das;
	
	@Override
	public void saveFlight(Flight flight) {
		// TODO Auto-generated method stub
		if(flight != null)
			flightDao.save(flight);
	}
	
	
	@Override
	public Flight save(String flightId, String squawk, Plane plane) {
		// TODO Auto-generated method stub
		Flight flight = flightDao.findByFlightCode(flightId);
		System.out.print("Flight == "+flight);
		if(flight == null) {
		flight = new Flight();
		flight.setFlightCode(flightId);
		}
		
		flight.setSquawk(squawk);
		flight.setPlane(plane);
		flightDao.save(flight);
		
		
	return flight;
	}

	

	@Override
	public void getJSONDaten() {
		// TODO Auto-generated method stub
	
		 JSONObject json;
		try {
			json = JSONHelper.readJsonFromUrl
					("https://data-live.flightradar24.com/zones/fcgi/feed.js?bounds=52.65,52.10,12.99,13.83&faa=1&satellite=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=14400&gliders=1");
		
	    System.out.println(json.toString());
	    
	    JSONArray jsonDatas = json.names();
	    for(int i = 0; i< jsonDatas.length() ; i++) {
	    	
	    	String flightId = jsonDatas.get(i).toString();
	    	
	    	
	    
	    	
	    	
	    	
	    	if(!flightId.startsWith("f") && !flightId.startsWith("v")) {
	    		System.out.print("\n Flight ID "+flightId+" / ");	
	    		
	    		System.out.print("\n Array of this String \n");
	    		
	    		JSONArray flightDatas = json.getJSONArray(flightId);
	    		
	    		//Get Data from JSONFeed
	    		String squawk = flightDatas.get(JsonIndex.Squawk.getIndex()).toString();
	    		String airline = flightDatas.get(JsonIndex.Airline.getIndex()).toString();
	    		String hexcode = flightDatas.get(JsonIndex.Hexcode.getIndex()).toString();
	    		String manufacturer = flightDatas.get(JsonIndex.Manifacturer.getIndex()).toString();
	    		String Latitude = flightDatas.get(JsonIndex.Latitude.getIndex()).toString();
	    		String Longitude = flightDatas.get(JsonIndex.Longitude.getIndex()).toString();
	    		
	    		String arriveAirportShortcut = flightDatas.get(JsonIndex.ArriveAirport.getIndex()).toString();
	    		String departAirportShortcut = flightDatas.get(JsonIndex.DepartAirport.getIndex()).toString();
	    		
	    		//Save Airports
	    		Airport departAirport = airportService.save(departAirportShortcut);
	    		Airport arriveAirport = airportService.save(arriveAirportShortcut);
	    		
	    		//Save Plane
	    		Plane plane = planeService.save(hexcode, manufacturer, airline);;
	    		
	    		
	    		// Save Flight
	    		Flight flight = save(flightId, squawk, plane);
	    		
	    		//Save Geo
	    		geoService.save(Longitude, Latitude, flight);
	    		
	    		//Save Depart/Arrive Airport
	    		aas.save(flight.getFlightCode(), arriveAirport.getShortcut());
	    		das.save(flight.getFlightCode(), departAirport.getShortcut());
	    			
	    	} // if
	    	
	    } // for
	    
	    
		 } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PlaneService getPlaneService() {
		return planeService;
	}

	public void setPlaneService(PlaneService planeService) {
		this.planeService = planeService;
	}

	public GeoService getGeoService() {
		return geoService;
	}

	public void setGeoService(GeoService geoService) {
		this.geoService = geoService;
	}

	public AirportService getAirportService() {
		return airportService;
	}

	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}


	
	public FlightDao getFlightDao() {
		return flightDao;
	}

	public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}


	
	
	

}
