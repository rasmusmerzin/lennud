<script lang="ts">
	import type { PageProps } from "./$types";
	import FlightInfo from "./FlightInfo.svelte";
	import PlaneLayout from "./PlaneLayout.svelte";

	let { data }: PageProps = $props();
	let { flight, bookings } = $derived(data);
	let { plane, bookedSeats } = $derived(bookings);
	let { layout } = $derived(plane);
</script>

<div class="mx-auto my-8 max-w-128 px-4">
	<h1 class="text-2xl font-black">Flight {flight.flightNumber}</h1>
	<div class="my-4 flex flex-wrap justify-between gap-4">
		<FlightInfo {flight} />
		<PlaneLayout {layout} {bookedSeats} />
	</div>
</div>
