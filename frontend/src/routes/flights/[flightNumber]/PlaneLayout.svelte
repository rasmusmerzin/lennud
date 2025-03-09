<script lang="ts">
	let {
		layout,
		bookedSeats,
		selectedSeats = $bindable([]),
	}: {
		layout: string;
		bookedSeats: number[];
		selectedSeats?: number[];
	} = $props();

	let [rows, maxSeats] = $derived.by(() => {
		const lines = layout.split("\n");
		let seat = 0;
		const rows: (number | null)[][] = [];
		for (const line of lines) {
			const row: (number | null)[] = [];
			for (const char of line) {
				if (char === "X") row.push(++seat);
				else row.push(null);
			}
			rows.push(row);
		}
		return [rows, seat];
	});
	let availableSeats = $derived(maxSeats - bookedSeats.length);

	function toggleSeat(seat: number) {
		if (selectedSeats.includes(seat))
			selectedSeats = selectedSeats.filter((s) => s !== seat);
		else selectedSeats = [...selectedSeats, seat];
	}
</script>

<div>
	<h2 class="text-lg font-bold">Seat layout</h2>
	<div class="mt-1 mb-2 italic">Available seats: {availableSeats}</div>
	{#each rows as row}
		<div class="flex" class:row>
			{#each row as seat}
				{#if seat === null}
					<div class="h-8 w-8"></div>
				{:else}
					<button
						class="flex h-8 w-8 items-center justify-center border border-gray-300"
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
