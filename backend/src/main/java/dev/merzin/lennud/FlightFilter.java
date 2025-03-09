package dev.merzin.lennud;

import java.time.ZonedDateTime;

public record FlightFilter(
	String departureLocation,
	String destinationLocation,
	ZonedDateTime departureTimeStart,
	ZonedDateTime departureTimeEnd,
	Integer durationMinutesMin,
	Integer durationMinutesMax,
	Double priceMin,
	Double priceMax
) {}
