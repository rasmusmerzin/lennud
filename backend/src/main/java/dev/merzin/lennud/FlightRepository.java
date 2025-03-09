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
					120,
					100.0,
					"ES-AAC"
				),
				new Flight(
					"LO124",
					"WAW",
					"TLL",
					Instant.parse("2025-04-01T12:00:00Z").atZone(ZoneId.of("UTC")),
					120,
					100.0,
					"ES-AAC"
				),
				new Flight(
					"LO125",
					"TLL",
					"RIX",
					Instant.parse("2025-04-01T16:00:00Z").atZone(ZoneId.of("UTC")),
					90,
					50.0,
					"ES-AAC"
				),
				new Flight(
					"LO126",
					"RIX",
					"TLL",
					Instant.parse("2025-04-01T20:00:00Z").atZone(ZoneId.of("UTC")),
					90,
					50.0,
					"ES-AAC"
				),
				new Flight(
					"LO127",
					"TLL",
					"HEL",
					Instant.parse("2025-04-02T08:00:00Z").atZone(ZoneId.of("UTC")),
					60,
					75.0,
					"ES-AAC"
				),
				new Flight(
					"LO128",
					"HEL",
					"TLL",
					Instant.parse("2025-04-02T12:00:00Z").atZone(ZoneId.of("UTC")),
					60,
					75.0,
					"ES-AAC"
				),
				new Flight(
					"LO129",
					"TLL",
					"RIX",
					Instant.parse("2025-04-02T16:00:00Z").atZone(ZoneId.of("UTC")),
					90,
					50.0,
					"ES-AAC"
				),
				new Flight(
					"LO130",
					"RIX",
					"TLL",
					Instant.parse("2025-04-02T20:00:00Z").atZone(ZoneId.of("UTC")),
					90,
					50.0,
					"ES-AAC"
				),
				new Flight(
					"LO131",
					"TLL",
					"HEL",
					Instant.parse("2025-04-03T08:00:00Z").atZone(ZoneId.of("UTC")),
					60,
					75.0,
					"ES-AAC"
				),
				new Flight(
					"LO132",
					"HEL",
					"TLL",
					Instant.parse("2025-04-03T12:00:00Z").atZone(ZoneId.of("UTC")),
					60,
					75.0,
					"ES-AAC"
				),
				new Flight(
					"LO133",
					"TLL",
					"RIX",
					Instant.parse("2025-04-03T16:00:00Z").atZone(ZoneId.of("UTC")),
					90,
					50.0,
					"ES-AAC"
				),
				new Flight(
					"LO134",
					"RIX",
					"TLL",
					Instant.parse("2025-04-03T20:00:00Z").atZone(ZoneId.of("UTC")),
					90,
					50.0,
					"ES-AAC"
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

	public List<Flight> getFilteredFlights(FlightFilter flightFilter) {
		return getAllFlights()
			.stream()
			.filter(f -> flightFilter.departureLocation() == null
					|| f.departureLocation().equals(flightFilter.departureLocation()))
			.filter(f -> flightFilter.destinationLocation() == null
					|| f.destinationLocation().equals(flightFilter.destinationLocation()))
			.filter(f -> flightFilter.departureTimeStart() == null
					|| f.departureTime().isAfter(flightFilter.departureTimeStart())
					|| f.departureTime().equals(flightFilter.departureTimeStart()
						.withZoneSameInstant(ZoneId.of("UTC"))))
			.filter(f -> flightFilter.departureTimeEnd() == null
					|| f.departureTime().isBefore(flightFilter.departureTimeEnd())
					|| f.departureTime().equals(flightFilter.departureTimeEnd()
						.withZoneSameInstant(ZoneId.of("UTC"))))
			.filter(f -> flightFilter.durationMinutesMin() == null
					|| f.durationMinutes() >= flightFilter.durationMinutesMin())
			.filter(f -> flightFilter.durationMinutesMax() == null
					|| f.durationMinutes() <= flightFilter.durationMinutesMax())
			.filter(f -> flightFilter.priceMin() == null
					|| f.price() >= flightFilter.priceMin())
			.filter(f -> flightFilter.priceMax() == null
					|| f.price() <= flightFilter.priceMax())
			.toList();
	}
}
