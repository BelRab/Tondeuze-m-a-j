package fr.solinum.tondeuze.gazon;

public enum Orientation {

	Nord('n'),Sud('s'),Est('e'),Ouest('o');
	
	private char orientation;
	
	Orientation(char orientation){//constructeur
		this.orientation=orientation;
	}
	//getter
	public char getOrientation() {
		return orientation;
	}
	//setter
	public void setOrientation(char orientation) {
		this.orientation=orientation;
	}
	public String orientationToString() {
		if(this.orientation=='n') {
			return "Nord";
		}else if(this.orientation=='s') {
			return "Sud";
		}else if(this.orientation=='e') {
			return "Est";
		}else {
			return "Ouest";
		}
	}
}
