<script lang="ts">
	let {
		layout,
		bookedSeats,
	}: {
		layout: string;
		bookedSeats: number[];
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
</script>

<div>
	<div class="mb-2">
		<div>Available seats: {availableSeats}</div>
	</div>
	{#each rows as row}
		<div class="flex" class:row>
			{#each row as seat}
				{#if seat === null}
					<div class="h-8 w-8"></div>
				{:else}
					<button
						class="flex h-8 w-8 items-center justify-center border border-gray-300"
						disabled={bookedSeats.includes(seat)}
					>
						{seat}
					</button>
				{/if}
			{/each}
		</div>
	{/each}
</div>

<style>
	button:disabled {
		background-color: #ccc;
		color: #fff;
	}
</style>
