package dev.merzin.lennud;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
	private final FlightService flightService;

	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}

	@GetMapping("/flights/{flightNumber}")
	public Flight getFlight(@PathVariable String flightNumber) {
		return flightService.getFlight(flightNumber);
	}
}
