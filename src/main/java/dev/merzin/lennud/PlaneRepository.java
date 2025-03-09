package dev.merzin.lennud;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PlaneRepository {
	private final List<Plane> planes = List.of(
		new Plane(
			"ES-AAC",
			"XX XX\n" +
			"XX XX\n" +
			"XX XX\n" +
			"XX   \n" +
			"XX XX\n" +
			"   XX\n" +
			"XX XX\n" +
			"XX XX\n" +
			"XX XX\n" +
			"XX XX"
		)
	);

	public Plane getPlane(String planeNumber) {
		return planes.stream()
			.filter(plane -> plane.getPlaneNumber().equals(planeNumber))
			.findFirst()
			.orElse(null);
	}
}
