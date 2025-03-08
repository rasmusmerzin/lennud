package dev.merzin.lennud;

import java.time.ZonedDateTime;

public record Flight(
	String flightNumber,
	String departureLocation,
	String destinationLocation,
	ZonedDateTime departureTime,
	ZonedDateTime arrivalTime,
	Double price
) {}
