package dev.merzin.lennud;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
	private final FlightRepository flightRepository;

	public FlightService(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	public List<Flight> getAllFlights() {
		return flightRepository.getAllFlights();
	}

	public Flight getFlight(String flightNumber) {
		return flightRepository.getFlight(flightNumber);
	}
}
