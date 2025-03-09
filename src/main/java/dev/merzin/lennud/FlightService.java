package dev.merzin.lennud;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
	private final FlightRepository flightRepository;
	private final PlaneRepository planeRepository;

	public FlightService(
		FlightRepository flightRepository,
		PlaneRepository planeRepository
	) {
		this.flightRepository = flightRepository;
		this.planeRepository = planeRepository;
	}

	public List<Flight> getAllFlights() {
		return flightRepository.getAllFlights();
	}

	public Flight getFlight(String flightNumber) {
		return flightRepository.getFlight(flightNumber);
	}

	public List<Flight> getFilteredFlights(FlightFilter flightFilter) {
		return flightRepository.getFilteredFlights(flightFilter);
	}

	public FlightBookings getFlightBookings(String flightNumber) {
		var flight = getFlight(flightNumber);
		var plane = planeRepository.getPlane(flight.planeNumber());
		var availableSeats = new ArrayList<Integer>();
		var bookedSeats = new ArrayList<Integer>();
		for (int i = 0; i < plane.getSeats(); i++) availableSeats.add(i + 1);
		for (int i = 0; i < plane.getSeats() / 2; i++) {
			var seat = availableSeats.remove((int) (Math.random() * availableSeats.size()));
			bookedSeats.add(seat);
		}
		return new FlightBookings(plane, bookedSeats);
	}
}
