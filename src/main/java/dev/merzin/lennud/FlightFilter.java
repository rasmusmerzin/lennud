package dev.merzin.lennud;

import java.time.ZonedDateTime;

public record FlightFilter(
	String departureLocation,
	String destinationLocation,
	ZonedDateTime departureTimeStart,
	ZonedDateTime departureTimeEnd,
	ZonedDateTime arrivalTimeStart,
	ZonedDateTime arrivalTimeEnd,
	Double priceMin,
	Double priceMax
) {}
