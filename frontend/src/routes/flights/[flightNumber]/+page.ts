import { getFlight, getFlightBookings } from "$lib/api";
import type { PageLoad } from "./$types";

export const load: PageLoad = async ({ params, fetch }) => {
	const { flightNumber } = params;
	const [flight, bookings] = await Promise.all([
		getFlight(flightNumber, fetch),
		getFlightBookings(flightNumber, fetch),
	]);
	return { flight, bookings };
};
