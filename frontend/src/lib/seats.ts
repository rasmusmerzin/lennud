export type LayoutRows = (number | null)[][];

export function getLayoutRows(layout: string): LayoutRows {
	const lines = layout.split("\n");
	const rows: LayoutRows = [];
	let seat = 0;
	for (const line of lines) {
		const row: (number | null)[] = [];
		for (const char of line) {
			if (char === "X") row.push(++seat);
			else row.push(null);
		}
		rows.push(row);
	}
	return rows;
}

export function getNextSeat(
	rows: LayoutRows,
	occupied: number[],
): number | null {
	for (const row of rows) {
		for (const seat of row) {
			if (seat !== null && !occupied.includes(seat)) return seat;
		}
	}
	return null;
}

export function getNextWindowSeat(
	rows: LayoutRows,
	occupied: number[],
): number | null {
	for (const row of rows) {
		const a = row[0];
		const b = row[row.length - 1];
		if (a !== null && !occupied.includes(a)) return a;
		if (b !== null && !occupied.includes(b)) return b;
	}
	return null;
}

export function getNextAisleSeat(
	rows: LayoutRows,
	occupied: number[],
): number | null {
	for (const row of rows) {
		for (let i = 1; i < row.length - 1; i++) {
			const seat = row[i];
			if (seat === null) continue;
			if (occupied.includes(seat)) continue;
			if (row[i - 1] === null || row[i + 1] === null) return seat;
		}
	}
	return null;
}

export function getNextLegspaceSeat(
	rows: LayoutRows,
	occupied: number[],
): number | null {
	for (let rowIndex = 1; rowIndex < rows.length; rowIndex++) {
		const row = rows[rowIndex];
		for (let i = 0; i < row.length; i++) {
			const seat = row[i];
			if (seat === null) continue;
			if (occupied.includes(seat)) continue;
			if (rows[rowIndex - 1][i] === null) return seat;
		}
	}
	return null;
}
