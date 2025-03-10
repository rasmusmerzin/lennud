<script lang="ts">
	import { slide } from "svelte/transition";
	import type { Flight } from "$lib/model";

	let { flight }: { flight: Flight } = $props();

	let departureTimestamp = $derived(new Date(flight.departureTime).getTime());
	let arrivalTimestamp = $derived(
		departureTimestamp + flight.durationMinutes * 60 * 1000,
	);
	let departureDate = $derived(
		new Date(departureTimestamp).toISOString().substring(0, 10),
	);
	let departureTime = $derived(
		new Date(departureTimestamp).toISOString().substring(11, 16),
	);
	let arrivalTime = $derived(
		new Date(arrivalTimestamp).toISOString().substring(11, 16),
	);
</script>

<a
	in:slide
	out:slide
	href={flight.flightNumber}
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
