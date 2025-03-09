import type { Flight, FlightBookings, FlightFilter } from "./model";

const API_URL = "http://localhost:8080";

export async function getFlights(
	filter: FlightFilter,
	f = fetch,
): Promise<Flight[]> {
	const query = filterToQuery(filter);
	const url = `${API_URL}/flights?${query}`;
	const response = await f(url);
	if (response.ok) return response.json();
	else alert(response.statusText);
	return [];
}

export async function getFlight(
	flightNumber: string,
	f = fetch,
): Promise<Flight> {
	const url = `${API_URL}/flights/${flightNumber}`;
	const response = await f(url);
	if (response.ok) return response.json();
	else alert(response.statusText);
	return {} as Flight;
}

export async function getFlightBookings(
	flightNumber: string,
	f = fetch,
): Promise<FlightBookings> {
	const url = `${API_URL}/flights/${flightNumber}/bookings`;
	const response = await f(url);
	if (response.ok) return response.json();
	else alert(response.statusText);
	return {} as FlightBookings;
}

function filterToQuery(filter: Record<string, any>): string {
	const parts = [];
	for (const key in filter) {
		const value = filter[key];
		if (value === undefined) continue;
		parts.push(`${key}=${encodeURIComponent(value)}`);
	}
	return parts.join("&");
}
