package dev.merzin.lennud;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
	private final FlightService flightService;

	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@GetMapping("/flights")
	public List<Flight> getFlights(
		@RequestParam(required = false) String departureLocation,
		@RequestParam(required = false) String destinationLocation,
		@RequestParam(required = false) ZonedDateTime departureTimeStart,
		@RequestParam(required = false) ZonedDateTime departureTimeEnd,
		@RequestParam(required = false) ZonedDateTime arrivalTimeStart,
		@RequestParam(required = false) ZonedDateTime arrivalTimeEnd,
		@RequestParam(required = false) Double priceMin,
		@RequestParam(required = false) Double priceMax
	) {
		return flightService.getFilteredFlights(new FlightFilter(
			departureLocation,
			destinationLocation,
			departureTimeStart,
			departureTimeEnd,
			arrivalTimeStart,
			arrivalTimeEnd,
			priceMin,
			priceMax
		));
	}

	@GetMapping("/flights/{flightNumber}")
	public Flight getFlight(@PathVariable String flightNumber) {
		return flightService.getFlight(flightNumber);
	}
}
