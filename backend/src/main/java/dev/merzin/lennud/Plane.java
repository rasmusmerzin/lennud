package dev.merzin.lennud;

public class Plane {
	private String planeNumber;
	private String layout;
	private Integer seats;

	public Plane(String planeNumber, String layout) {
		this.planeNumber = planeNumber;
		this.layout = layout;
		this.seats = 0;
		for (int i = 0; i < layout.length(); i++)
			if (layout.charAt(i) == 'X') seats++;
	}

	public String getPlaneNumber() {
		return planeNumber;
	}

	public void setPlaneNumber(String planeNumber) {
		this.planeNumber = planeNumber;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
}
