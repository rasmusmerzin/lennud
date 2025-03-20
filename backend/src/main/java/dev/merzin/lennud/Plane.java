package dev.merzin.lennud;

import lombok.Getter;

@Getter
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
}
