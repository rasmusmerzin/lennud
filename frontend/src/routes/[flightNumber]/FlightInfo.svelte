<script lang="ts">
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

<div>
	<div class="flex">
		<b class="w-24">From-To:</b>
		<span>{flight.departureLocation}</span>
		<span> → </span>
		<span>{flight.destinationLocation}</span>
	</div>
	<div class="flex">
		<b class="w-24">Date:</b>
		<span>{departureDate}</span>
	</div>
	<div class="flex">
		<b class="w-24">Time:</b>
		<span>{departureTime}</span>
		<span> → </span>
		<span>{arrivalTime}</span>
	</div>
	<div class="flex">
		<b class="w-24">Duration:</b>
		<span>{flight.durationMinutes} min</span>
	</div>
	<div class="flex">
		<b class="w-24">Price:</b>
		<span>{flight.price.toFixed(2)} €</span>
	</div>
</div>
