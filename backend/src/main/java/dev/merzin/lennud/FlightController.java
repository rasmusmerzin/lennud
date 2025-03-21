package dev.merzin.lennud;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/flights")
public class FlightController {
	private final FlightService flightService;

	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@GetMapping
	public List<Flight> getFlights(
		@RequestParam(required = false) String departureLocation,
		@RequestParam(required = false) String destinationLocation,
		@RequestParam(required = false) ZonedDateTime departureTimeStart,
		@RequestParam(required = false) ZonedDateTime departureTimeEnd,
		@RequestParam(required = false) Integer durationMinutesMin,
		@RequestParam(required = false) Integer durationMinutesMax,
		@RequestParam(required = false) Double priceMin,
		@RequestParam(required = false) Double priceMax
	) {
		return flightService.getFilteredFlights(new FlightFilter(
			departureLocation,
			destinationLocation,
			departureTimeStart,
			departureTimeEnd,
			durationMinutesMin,
			durationMinutesMax,
			priceMin,
			priceMax
		));
	}

	@GetMapping("{flightNumber}")
	public Flight getFlight(@PathVariable String flightNumber) {
		return flightService.getFlight(flightNumber);
	}

	@GetMapping("{flightNumber}/bookings")
	public FlightBookings getFlightBookings(@PathVariable String flightNumber) {
		return flightService.getFlightBookings(flightNumber);
	}
}
