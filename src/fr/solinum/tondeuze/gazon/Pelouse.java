package fr.solinum.tondeuze.gazon;

public class Pelouse {

	private int positionPelouseX;
	private int positionPelouseY;

	Pelouse(int positionPelouseX, int positionPelouseY) {
		this.positionPelouseX = positionPelouseX;
		this.positionPelouseY = positionPelouseY;
	}

	public int getPositionPelouseX() {
		return positionPelouseX;
	}

	public int getPositionPelouseY() {
		return positionPelouseY;
	}
}
