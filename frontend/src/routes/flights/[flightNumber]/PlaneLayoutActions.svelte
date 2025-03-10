<script lang="ts">
	import {
		type LayoutRows,
		getNextAisleSeat,
		getNextLegspaceSeat,
		getNextWindowSeat,
	} from "$lib/seats";

	let {
		rows,
		bookedSeats,
		selectedSeats = $bindable([]),
	}: {
		rows: LayoutRows;
		bookedSeats: number[];
		selectedSeats?: number[];
	} = $props();

	let nextWindowSeat = $derived(
		getNextWindowSeat(rows, [...bookedSeats, ...selectedSeats]),
	);
	let nextAisleSeat = $derived(
		getNextAisleSeat(rows, [...bookedSeats, ...selectedSeats]),
	);
	let nextLegspaceSeat = $derived(
		getNextLegspaceSeat(rows, [...bookedSeats, ...selectedSeats]),
	);
</script>

<div class="flex flex-col gap-1">
	<button
		disabled={!selectedSeats.length}
		onclick={() => (selectedSeats = [])}
	>
		Clear selection
	</button>
	<button
		disabled={nextWindowSeat === null}
		onclick={() => selectedSeats.push(nextWindowSeat!)}
	>
		Add window seat
	</button>
	<button
		disabled={nextAisleSeat === null}
		onclick={() => selectedSeats.push(nextAisleSeat!)}
	>
		Add aisle seat
	</button>
	<button
		disabled={nextLegspaceSeat === null}
		onclick={() => selectedSeats.push(nextLegspaceSeat!)}
	>
		Add legspace seat
	</button>
</div>

<style>
	button {
		padding: 0.25rem 0.75rem;
		background: #000;
		color: #fff;
		border-radius: 0.25rem;
		font-weight: bold;
		&:active {
			opacity: 0.5;
		}
		&:disabled {
			opacity: 0.25;
		}
		&:not(:disabled):hover {
			cursor: pointer;
			background: #333;
		}
	}
</style>
