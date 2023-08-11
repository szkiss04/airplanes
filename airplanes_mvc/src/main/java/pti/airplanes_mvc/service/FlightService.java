package pti.airplanes_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.airplanes_mvc.data.FlightDao;
import pti.airplanes_mvc.model.Flight;

@Service
public class FlightService {
	
	private final FlightDao dao;
	
	@Autowired
	public FlightService(FlightDao dao) {
		
		this.dao = dao;
	}
	
	public List<Flight> getFlights() {
		
		List<Flight> flightList = dao.getAllFlights();
		
		return flightList;
	}
	
	public List<Flight> getFlightsWithFlightTime() {
		
		List<Flight> flightList = dao.getAllFlights();
		
		for(Flight flight : flightList) {
			
			flight.calcFlightTime();
		}
		
		return flightList;
	}
	
}
