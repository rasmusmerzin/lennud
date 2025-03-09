<script lang="ts">
	import type { PageProps } from "./$types";
	import FlightInfo from "./FlightInfo.svelte";
	import PlaneLayout from "./PlaneLayout.svelte";

	let { data }: PageProps = $props();
	let { flight, bookings } = $derived(data);
	let { plane, bookedSeats } = $derived(bookings);
	let { layout } = $derived(plane);

	let selectedSeats = $state<number[]>([]);
	let totalPrice = $derived(selectedSeats.length * flight.price);
</script>

<div class="mx-auto my-8 max-w-128 px-4">
	<h1 class="text-2xl font-black">Flight {flight.flightNumber}</h1>
	<div class="my-4 flex flex-wrap justify-between gap-4">
		<div>
			<FlightInfo {flight} />
			{#if selectedSeats.length}
				<div class="mt-4">
					<div>Selected seats: {selectedSeats}</div>
					<div>Total price: {totalPrice.toFixed(2)} €</div>
				</div>
			{/if}
		</div>
		<PlaneLayout bind:selectedSeats {layout} {bookedSeats} />
	</div>
</div>
