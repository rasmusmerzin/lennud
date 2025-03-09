<script lang="ts">
	import { onMount } from "svelte";
	import type { Flight } from "$lib/model";
	import { getFlights } from "$lib/api";
	import FlightRow from "./FlightRow.svelte";
	import FlightHeader from "./FlightHeader.svelte";
	import FlightFilter from "./FlightFilter.svelte";

	let flights = $state<Flight[]>([]);

	onMount(async () => {
		flights = await getFlights({});
	});
</script>

<div class="container mx-auto my-8 min-w-192 px-4 lg:max-w-256">
	<h1 class="mb-8 text-2xl font-black">Flights</h1>
	<FlightFilter
		onFilter={async (filter) => (flights = await getFlights(filter))}
	/>
	<FlightHeader />
	{#each flights as flight (flight.flightNumber)}
		<FlightRow {flight} />
	{/each}
</div>
