package pti.airplanes_mvc.service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import pti.airplanes_mvc.model.Flight;

@Component
public class FlightsGraph {
	
	private Map<Flight, List<Flight>> graph;

	public void buildGraph(List<Flight> flightsList) {
		
		Map<Flight, List<Flight>> graph = new HashMap<>();
		
		for(Flight flight : flightsList) {
			
			List<Flight> adjacency = new ArrayList<>();
			
			for(Flight adjacentFlight : flightsList) {
				
				if(!adjacentFlight.equals(flight) &&
					flight.getArrivalCity().equals(adjacentFlight.getDepartureCity()) &&
					flight.getArrivalTime().until(adjacentFlight.getDepartureTime(), ChronoUnit.MINUTES) > 0) {
					
					adjacency.add(adjacentFlight);
				}
			}
			
			graph.put(flight, adjacency);
			
		}
		
		this.graph = graph;
	}

	public Map<Flight, List<Flight>> getGraph() {
		
		return graph;
	}
	
	public void getRoutePlan(Flight departureFlight, String arrival, List<Flight> result) {
		
		if(graph.get(departureFlight).isEmpty()) {
			
			if(departureFlight.getArrivalCity().equals(arrival)) {
				result.add(departureFlight);
			}
			
		} else {
			
			result.add(departureFlight);
			
			if(!departureFlight.getArrivalCity().equals(arrival)) {
				
				for(Flight adjacentFlight : graph.get(departureFlight)) {
					
					getRoutePlan(adjacentFlight, arrival, result);
					
					if(result.get(result.size() - 1).getArrivalCity().equals(arrival)) {
						
						break;
					} else {
						
						result.remove(result.size() - 1);
					}
				}
			}
		}
	}
}
