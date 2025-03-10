<script lang="ts">
	import type { LayoutRows } from "$lib/seats";

	let {
		rows,
		bookedSeats,
		selectedSeats = $bindable([]),
	}: {
		rows: LayoutRows;
		bookedSeats: number[];
		selectedSeats?: number[];
	} = $props();

	function toggleSeat(seat: number) {
		const index = selectedSeats.indexOf(seat);
		if (index < 0) selectedSeats.push(seat);
		else selectedSeats.splice(index, 1);
	}
</script>

<div>
	{#each rows as row}
		<div class="flex" class:row>
			{#each row as seat}
				{#if seat === null}
					<div class="h-10 w-10"></div>
				{:else}
					<button
						class="flex h-10 w-10 items-center justify-center border border-gray-300"
						class:selected={selectedSeats.includes(seat)}
						disabled={bookedSeats.includes(seat)}
						onclick={() => toggleSeat(seat)}
					>
						{seat}
					</button>
				{/if}
			{/each}
		</div>
	{/each}
</div>

<style>
	button {
		&.selected {
			background-color: #007bff;
			color: #fff;
			font-weight: bold;
		}
		&:not(:disabled) {
			cursor: pointer;
		}
		&:disabled {
			background-color: #ccc;
			color: #fff;
		}
	}
</style>
