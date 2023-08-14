package pti.airplanes_mvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.airplanes_mvc.data.FlightDao;
import pti.airplanes_mvc.model.Flight;
import pti.airplanes_mvc.model.FlightTimeOfCaptain;

@Service
public class FlightService {
	
	private final FlightDao dao;
	private final FlightsGraph graph;
	
	@Autowired
	public FlightService(FlightDao dao, FlightsGraph graph) {
		
		this.dao = dao;
		this.graph = graph;
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
	
	public List<List<Flight>> getPlan(String departureCity, String arrivalCity) {
		
		graph.setFlightsList(getFlights());
		
		List<Flight> possibleFlights = dao.getFlightsByDepartureCity(departureCity); 
		List<List<Flight>> planList = new ArrayList<>();
		
		for(Flight flight : possibleFlights) {
			
			List<Flight> plan = new ArrayList<>();
			graph.getRoutePlan(flight, arrivalCity, plan);
			
			if(!plan.isEmpty()) {
				
				planList.add(plan);
			}
		}
		
		return planList;
	}
	
	public List<String> getAllDestination() {
		
		List<Flight> allFlight = getFlights();
		Set<String> destinations = new HashSet<>();
		
		for(Flight flight : allFlight) {
			
			destinations.add(flight.getArrivalCity());
		}
		
		return destinations.stream().toList();
	}
	
	public List<String> getAllDeparture() {
		
		List<Flight> allFlight = getFlights();
		Set<String> departures = new HashSet<>();
		
		for(Flight flight : allFlight) {
			
			departures.add(flight.getDepartureCity());
		}
		
		return departures.stream().toList();
	}
	
}
