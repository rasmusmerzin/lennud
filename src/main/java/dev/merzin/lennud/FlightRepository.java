package dev.merzin.lennud;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class FlightRepository {
	private List<Flight> flights = null;

	public List<Flight> getAllFlights() {
		if (flights != null) return flights;
		try {
			flights = List.of(
				new Flight(
					"LO123",
					"TLL",
					"WAW",
					Instant.parse("2025-04-01T08:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-01T10:00:00Z").atZone(ZoneId.of("UTC")),
					100.0
				),
				new Flight(
					"LO124",
					"WAW",
					"TLL",
					Instant.parse("2025-04-01T12:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-01T14:00:00Z").atZone(ZoneId.of("UTC")),
					100.0
				),
				new Flight(
					"LO125",
					"TLL",
					"RIX",
					Instant.parse("2025-04-01T16:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-01T18:00:00Z").atZone(ZoneId.of("UTC")),
					50.0
				),
				new Flight(
					"LO126",
					"RIX",
					"TLL",
					Instant.parse("2025-04-01T20:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-01T22:00:00Z").atZone(ZoneId.of("UTC")),
					50.0
				),
				new Flight(
					"LO127",
					"TLL",
					"HEL",
					Instant.parse("2025-04-02T08:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-02T10:00:00Z").atZone(ZoneId.of("UTC")),
					75.0
				),
				new Flight(
					"LO128",
					"HEL",
					"TLL",
					Instant.parse("2025-04-02T12:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-02T14:00:00Z").atZone(ZoneId.of("UTC")),
					75.0
				),
				new Flight(
					"LO129",
					"TLL",
					"RIX",
					Instant.parse("2025-04-02T16:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-02T18:00:00Z").atZone(ZoneId.of("UTC")),
					50.0
				),
				new Flight(
					"LO130",
					"RIX",
					"TLL",
					Instant.parse("2025-04-02T20:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-02T22:00:00Z").atZone(ZoneId.of("UTC")),
					50.0
				),
				new Flight(
					"LO131",
					"TLL",
					"HEL",
					Instant.parse("2025-04-03T08:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-03T10:00:00Z").atZone(ZoneId.of("UTC")),
					75.0
				),
				new Flight(
					"LO132",
					"HEL",
					"TLL",
					Instant.parse("2025-04-03T12:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-03T14:00:00Z").atZone(ZoneId.of("UTC")),
					75.0
				),
				new Flight(
					"LO133",
					"TLL",
					"RIX",
					Instant.parse("2025-04-03T16:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-03T18:00:00Z").atZone(ZoneId.of("UTC")),
					50.0
				),
				new Flight(
					"LO134",
					"RIX",
					"TLL",
					Instant.parse("2025-04-03T20:00:00Z").atZone(ZoneId.of("UTC")),
					Instant.parse("2025-04-03T22:00:00Z").atZone(ZoneId.of("UTC")),
					50.0
				)
			);
			return flights;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Flight getFlight(String flightNumber) {
		return getAllFlights()
			.stream()
			.filter(f -> f.flightNumber().equals(flightNumber))
			.findFirst()
			.orElse(null);
	}
}
