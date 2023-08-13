package pti.airplanes_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.airplanes_mvc.data.FlightDao;
import pti.airplanes_mvc.model.Flight;
import pti.airplanes_mvc.model.FlightTimeOfCaptain;

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
	
	public List<FlightTimeOfCaptain> getAllCaptainsFlightTimes() {
		
		List<FlightTimeOfCaptain> flightTimeList = dao.getTotalFlightTimesOfCaptains();
		
		return flightTimeList;
	}
	
}
