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
	
	@GetMapping("/flights")
	public String getAllFlights(
				Model model
			) {
		
		model.addAttribute("flightList", service.getFlights());
		
		return "flights";
	}
	
	@GetMapping("/flights/flighttime")
	public String getAllFlightsWithFlightTime(
				Model model
			) {
		
		model.addAttribute("flightList", service.getFlightsWithFlightTime());
		model.addAttribute("hasFlightTime", true);
		
		return "flights";
	}
	
	@GetMapping("flights/captains")
	public String getAllCaptainsTotalFlightTimes(
				Model model
			) {
		
		model.addAttribute("flightTimes", service.getAllCaptainsFlightTimes());
		
		return "captain_flight_times";
	}
	
	@GetMapping("/flights/plan")
	public String getPlannerPage(
				@RequestParam(name = "departure", defaultValue = "") String departureCity,
				@RequestParam(name = "destination", defaultValue = "") String destinationCity,
				Model model
			) {
		
		model.addAttribute("allDeparture", service.getAllDeparture());
		model.addAttribute("allDestination", service.getAllDestination());
		
		List<List<Flight>> plans = service.getPlans(departureCity, destinationCity);
		
		model.addAttribute("plans", plans);
		
		return "planner";
	}
	
	@GetMapping("/flights/directlyback")
	public String showWhoCanFlyDirectlyBack(
				Model model
			) {
		
		model.addAttribute("captainNames", service.whoCanGetBackDirectly());
		
		return "who_can_fly_directly_back";
	}

}
