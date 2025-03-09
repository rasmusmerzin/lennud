export interface Flight {
	flightNumber: string;
	departureLocation: string;
	destinationLocation: string;
	departureTime: string;
	durationMinutes: number;
	price: number;
	planeName: string;
}

export interface FlightFilter {
	departureLocation?: string;
	destinationLocation?: string;
	departureTimeStart?: string;
	departureTimeEnd?: string;
	durationMinutesMin?: number;
	durationMinutesMax?: number;
	priceMin?: number;
	priceMax?: number;
}

export interface Plane {
	planeNumber: string;
	layout: string;
	seats: number;
}

export interface FlightBookings {
	plane: Plane;
	bookedSeats: number[];
}
