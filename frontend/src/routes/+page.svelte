<script lang="ts">
	import { getFlights } from "$lib/api";
	import type { Flight } from "$lib/model";
	import { onMount } from "svelte";

	let flights = $state<Flight[]>([]);

	onMount(async () => {
		flights = await getFlights({});
	});
</script>

{#each flights as flight}
	<a href="flights/{flight.flightNumber}">
		<pre>{JSON.stringify(flight, null, 2)}</pre>
	</a>
{/each}
