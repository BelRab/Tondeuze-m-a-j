package fr.solinum.tondeuze.gazon;

public class PositionTondeuze {
	private int positionTondeuzeX;
	private int positionTondeuzeY;
	private Orientation orientationTondeuze;

	PositionTondeuze(int positionTondeuzeX, int positionTondeuzeY, Orientation orientationTondeuze) {
		this.positionTondeuzeX = positionTondeuzeX;
		this.positionTondeuzeY = positionTondeuzeY;
		this.orientationTondeuze = orientationTondeuze;
	}

	public int getPositionTondeuzeX() {
		return positionTondeuzeX;
	}

	public int getPositionTondeuzeY() {
		return positionTondeuzeY;
	}

	public Orientation getOrientationTondeuze() {
		return orientationTondeuze;
	}
}
