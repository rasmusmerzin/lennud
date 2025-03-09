<script lang="ts">
	import { onMount } from "svelte";
	import type { Flight } from "$lib/model";
	import { getFlights } from "$lib/api";
	import FlightRow from "./FlightRow.svelte";
	import FlightHeader from "./FlightHeader.svelte";

	let flights = $state<Flight[]>([]);

	onMount(async () => {
		flights = await getFlights({});
	});
</script>

<div class="container mx-auto min-w-192 px-4 lg:max-w-256">
	<h1 class="my-8 text-2xl font-black">Flights</h1>
	<FlightHeader />
	{#each flights as flight}
		<FlightRow {flight} />
	{/each}
</div>
