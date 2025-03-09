<script lang="ts">
	import type { Flight } from "$lib/model";
	const { flight }: { flight: Flight } = $props();
	const departureDate = flight.departureTime.substring(0, 10);
	const departureTime = flight.departureTime.substring(11, 16);
	const departureTimestamp = new Date(flight.departureTime).getTime();
	const arrivalTimestamp =
		departureTimestamp + flight.durationMinutes * 60 * 1000;
	const arrivalTime = new Date(arrivalTimestamp)
		.toISOString()
		.substring(11, 16);
</script>

<a
	href="flights/{flight.flightNumber}"
	class="flex border-b p-2 hover:font-bold hover:shadow-md"
>
	<div class="flex-1">{flight.flightNumber}</div>
	<div class="flex-1">
		<span>{flight.departureLocation}</span>
		<span> → </span>
		<span>{flight.destinationLocation}</span>
	</div>
	<div class="flex-1">{departureDate}</div>
	<div class="flex-1">
		<span>{departureTime}</span>
		<span> → </span>
		<span>{arrivalTime}</span>
	</div>
	<div class="flex flex-1 justify-end">{flight.durationMinutes} min</div>
	<div class="flex flex-1 justify-end">{flight.price.toFixed(2)} €</div>
</a>
