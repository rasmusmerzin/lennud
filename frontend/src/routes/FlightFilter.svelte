<script lang="ts">
	import type { FlightFilter } from "$lib/model";

	let {
		onFilter,
	}: {
		onFilter: (filter: FlightFilter) => any;
	} = $props();

	const airports = ["TLL", "RIX", "HEL", "WAW"];

	let departureLocation = $state("");
	let destinationLocation = $state("");
	let departureDate = $state("");
	let departureTimeFrom = $state("");
	let departureTimeUntil = $state("");
	let durationMinutesMin = $state("");
	let durationMinutesMax = $state("");
	let priceMin = $state("");
	let priceMax = $state("");

	let filter = $derived<FlightFilter>({
		departureLocation: departureLocation || undefined,
		destinationLocation: destinationLocation || undefined,
		departureTimeStart: departureDate
			? `${departureDate}T${departureTimeFrom || "00:00:00"}Z`
			: undefined,
		departureTimeEnd: departureDate
			? `${departureDate}T${departureTimeUntil || "23:59:59"}Z`
			: undefined,
		durationMinutesMin: durationMinutesMin
			? +durationMinutesMin
			: undefined,
		durationMinutesMax: durationMinutesMax
			? +durationMinutesMax
			: undefined,
		priceMin: priceMin ? +priceMin : undefined,
		priceMax: priceMax ? +priceMax : undefined,
	});

	$effect(() => {
		if (departureDate) return;
		departureTimeFrom = "";
		departureTimeUntil = "";
	});
</script>

<div class="my-8">
	<div class="flex items-center" class:font-bold={departureLocation}>
		<label class="w-48" for="from">From:</label>
		<select class="w-32 border-b" id="from" bind:value={departureLocation}>
			{#each ["", ...airports] as airport}
				<option value={airport}>{airport}</option>
			{/each}
		</select>
	</div>
	<div class="flex items-center" class:font-bold={destinationLocation}>
		<label class="w-48" for="to">To:</label>
		<select class="w-32 border-b" id="to" bind:value={destinationLocation}>
			{#each ["", ...airports] as airport}
				<option value={airport}>{airport}</option>
			{/each}
		</select>
	</div>
	<div class="flex items-center" class:font-bold={departureDate}>
		<label class="w-48" for="date">Date:</label>
		<input
			class="w-32 border-b"
			bind:value={departureDate}
			type="date"
			id="date"
		/>
	</div>
	<div class="flex items-center" class:font-bold={departureTimeFrom}>
		<label class="w-48" for="time-from">Time from:</label>
		<input
			class="w-32 border-b"
			bind:value={departureTimeFrom}
			type="time"
			id="time-from"
		/>
	</div>
	<div class="flex items-center" class:font-bold={departureTimeUntil}>
		<label class="w-48" for="time-until">Time until:</label>
		<input
			class="w-32 border-b"
			bind:value={departureTimeUntil}
			type="time"
			id="time-until"
		/>
	</div>
	<div class="flex items-center" class:font-bold={durationMinutesMin}>
		<label class="w-48" for="duration-min">Min duration (min):</label>
		<input
			class="w-32 border-b"
			bind:value={durationMinutesMin}
			type="number"
			id="duration-min"
		/>
	</div>
	<div class="flex items-center" class:font-bold={durationMinutesMax}>
		<label class="w-48" for="duration-max">Max duration (min):</label>
		<input
			class="w-32 border-b"
			bind:value={durationMinutesMax}
			type="number"
			id="duration-max"
		/>
	</div>
	<div class="flex items-center" class:font-bold={priceMin}>
		<label class="w-48" for="price-min">Min price (€):</label>
		<input
			class="w-32 border-b"
			bind:value={priceMin}
			type="number"
			id="price-min"
		/>
	</div>
	<div class="flex items-center" class:font-bold={priceMax}>
		<label class="w-48" for="price-max">Max price (€):</label>
		<input
			class="w-32 border-b"
			bind:value={priceMax}
			type="number"
			id="price-max"
		/>
	</div>
	<button
		class="mt-4 cursor-pointer rounded-md bg-black px-4 py-1 font-bold text-white hover:bg-neutral-800 active:opacity-50 disabled:opacity-50"
		onclick={() => onFilter(filter)}
	>
		Filter
	</button>
</div>
