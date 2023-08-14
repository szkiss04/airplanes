package pti.airplanes_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.airplanes_mvc.model.Flight;
import pti.airplanes_mvc.service.FlightService;

@Controller
public class FlightController {
	
	private final FlightService service;
	
	@Autowired
	public FlightController(FlightService service) {
		
		this.service = service;
	}
	
	@GetMapping("/flight/all")
	public String getAllFlights(
				Model model
			) {
		
		model.addAttribute("flightList", service.getFlights());
		
		return "flights";
	}
	
	@GetMapping("/flight/all/withflighttime")
	public String getAllFlightsWithFlightTime(
				Model model
			) {
		
		model.addAttribute("flightList", service.getFlightsWithFlightTime());
		model.addAttribute("hasFlightTime", true);
		
		return "flights";
	}
	
	@GetMapping("flight/captains/totalflighttimes")
	public String getAllCaptainsTotalFlightTimes(
				Model model
			) {
		
		model.addAttribute("flightTimesList", service.getAllCaptainsFlightTimes());
		
		return "flight_times";
	}
	
	@GetMapping("/flight/plan")
	public String getPlannerPage(
				@RequestParam(name = "departure", defaultValue = "") String departureCity,
				@RequestParam(name = "destination", defaultValue = "") String destinationCity,
				Model model
			) {
		
		model.addAttribute("allDeparture", service.getAllDeparture());
		model.addAttribute("allDestination", service.getAllDestination());
		
		List<List<Flight>> plans = service.getPlan(departureCity, destinationCity);
		System.out.println(plans);
		
		model.addAttribute("plans", plans);
		
		return "planner";
	}

}
