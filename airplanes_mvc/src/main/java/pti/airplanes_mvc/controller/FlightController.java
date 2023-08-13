package pti.airplanes_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		
		return "flights";
	}
	
	@GetMapping("flight/captains/totalflighttimes")
	public String getAllCaptainsTotalFlightTimes(
				Model model
			) {
		
		model.addAttribute("flightTimesList", service.getAllCaptainsFlightTimes());
		
		return "flight_times";
	}

}
