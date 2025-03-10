<script lang="ts">
	import { getLayoutRows, getNextSeat } from "$lib/seats";
	import { onMount } from "svelte";
	import type { PageProps } from "./$types";
	import FlightInfo from "./FlightInfo.svelte";
	import PlaneLayout from "./PlaneLayout.svelte";
	import PlaneLayoutActions from "./PlaneLayoutActions.svelte";

	let { data }: PageProps = $props();
	let { flight, bookings } = $derived(data);
	let { plane, bookedSeats } = $derived(bookings);
	let { layout } = $derived(plane);
	let rows = $derived(getLayoutRows(layout));

	let selectedSeats = $state<number[]>([]);
	let totalPrice = $derived(selectedSeats.length * flight.price);

	onMount(() => {
		const nextSeat = getNextSeat(rows, bookedSeats);
		if (nextSeat) selectedSeats = [nextSeat];
	});
</script>

<div class="mx-auto my-8 max-w-192 px-4">
	<h1 class="text-2xl font-black">Flight {flight.flightNumber}</h1>
	<div class="my-4 flex flex-wrap justify-between gap-4">
		<div>
			<FlightInfo {flight} />
			<div class="mt-4 w-64">
				<div>
					{#if selectedSeats.length === 1}
						<b>Selected seat:</b> {selectedSeats[0]}
					{:else if selectedSeats.length > 1}
						<b>Selected seats:</b> {selectedSeats.join(", ")}
					{:else}
						<b>No seat selected</b>
					{/if}
				</div>
				<div><b>Total price:</b> {totalPrice.toFixed(2)} €</div>
			</div>
		</div>
		<PlaneLayoutActions bind:selectedSeats {rows} {bookedSeats} />
		<PlaneLayout bind:selectedSeats {rows} {bookedSeats} />
	</div>
</div>
