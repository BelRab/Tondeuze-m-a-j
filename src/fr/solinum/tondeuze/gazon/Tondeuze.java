package fr.solinum.tondeuze.gazon;
public class Tondeuze {

	private int positionTondeuseX;
	private int positionTondeuseY;
	private Orientation orientation;
	Tondeuze(int positionTondeuseX, int positionTondeuseY, Orientation orientation) {
		this.positionTondeuseX = positionTondeuseX;
		this.positionTondeuseY = positionTondeuseY;
		this.orientation = orientation;
	}

	public int getPositionXTondeuze() {
		return this.positionTondeuseX;
	}

	public int getPositionYTondeuze() {
		return this.positionTondeuseY;
	}

	public Orientation getOrientationTondeuze() {
		return this.orientation;
	}

	public boolean ordresIsExiste(String ordre) {
		int val=0;
		for (char c : ordre.toCharArray()) {
			if(c!='a') {
				if(c!='g') {
					if(c!='d') {
						val=1;
					}
				}
			}
		}if(val==0) {
			return true;
		}else {
			return false;
		}
	}
	public void moveTondeuze(String ordreMouvement) {

		if(!ordresIsExiste(ordreMouvement)) {
			throw new IllegalArgumentException(String.format("L'ordre [ %s ] entrée n'est pas valide !", ordreMouvement));
		}
		for (char ordre : ordreMouvement.toCharArray()) {
			if (this.orientation.getOrientation() == 'n') {
				if (ordre == 'a') {
					this.positionTondeuseY++;
				} else if (ordre == 'g') {
					this.orientation.setOrientation('w');
				} else if (ordre == 'd') {
					this.orientation.setOrientation('e');
				}
			} else if (this.orientation.getOrientation() == 'e') {
				if (ordre == 'a') {
					this.positionTondeuseX++;
				} else if (ordre == 'g') {
					this.orientation.setOrientation('n');
				} else if (ordre == 'd') {
					this.orientation.setOrientation('s');
				}
			} else if (this.orientation.getOrientation() == 's') {
				if (ordre == 'a') {
					this.positionTondeuseY--;
				} else if (ordre == 'g') {
					this.orientation.setOrientation('e');
				} else if (ordre == 'd') {
					this.orientation.setOrientation('w');
				}
			} else if (this.orientation.getOrientation() == 'w') {
				if (ordre == 'a') {
					this.positionTondeuseX--;
				} else if (ordre == 'g') {
					this.orientation.setOrientation('s');
				} else if (ordre == 'd') {
					this.orientation.setOrientation('n');
				}

			}
		}
		System.out.println("La nouvelle position de la tondeuse est : X= " + this.positionTondeuseX + ",Y= "
				+ this.positionTondeuseY + " ,et l'orientation est : " + this.orientation.orientationToString());

	}

}
