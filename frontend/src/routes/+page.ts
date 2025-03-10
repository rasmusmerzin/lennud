import { getFlights } from "$lib/api";
import type { PageLoad } from "./$types";

export const load: PageLoad = async ({ fetch }) => {
	const flights = await getFlights({}, fetch);
	return { flights };
};
