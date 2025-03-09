package dev.merzin.lennud;

import java.util.List;

public record FlightBookings(
	Plane plane,
	// bookedSeats is a list of seat numbers starting from 1
	List<Integer> bookedSeats
) {}
