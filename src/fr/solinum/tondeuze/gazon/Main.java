package fr.solinum.tondeuze.gazon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static PositionPelouse verifierPositionPelouse(String ligne) {
		if (ligne.length() != 3) {
			throw new IllegalArgumentException(
					String.format("La position [%s] de la Pelouse n'est pas valide ", ligne));
		}
		try {
			Integer.parseInt(Character.toString(ligne.charAt(0)));
			Integer.parseInt(Character.toString(ligne.charAt(2)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		int positionPelouseX = Integer.parseInt(Character.toString(ligne.charAt(0)));
		int positionPelouseY = Integer.parseInt(Character.toString(ligne.charAt(2)));
		// Pelouse pelouse = new Pelouse(positionPelouseX, positionPelouseY);
		return new PositionPelouse(positionPelouseX, positionPelouseY);
	}

	public static PositionTondeuze verifierPositionTondeuze(String lignePositionTondeuse) {
		if (lignePositionTondeuse.length() != 5) {
			throw new IllegalArgumentException(
					String.format("La position [%s] de la tondeuze n'est pas valide ", lignePositionTondeuse));
		}
		try {
			Integer.parseInt(Character.toString(lignePositionTondeuse.charAt(0)));
			Integer.parseInt(Character.toString(lignePositionTondeuse.charAt(2)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		int positionTondeuzeX = Integer.parseInt(Character.toString(lignePositionTondeuse.charAt(0)));
		int positionTondeuzeY = Integer.parseInt(Character.toString(lignePositionTondeuse.charAt(2)));
		if (!isOrientationTondeuzeExiste(lignePositionTondeuse.charAt(4))) {
			throw new IllegalArgumentException(String.format("L'orientation [%s] de la tondeuze n'est pas valide",
					lignePositionTondeuse.charAt(4)));
		}
		String orien = showDirection(lignePositionTondeuse.charAt(4));
		Orientation orientation = Orientation.valueOf(orien);
		return new PositionTondeuze(positionTondeuzeX, positionTondeuzeY, orientation);
	}

	public static boolean isOrientationTondeuzeExiste(char c) {
		char[] orientationTab = new char[] { 'n', 'e', 'o', 's' };
		int val = 0;
		for (char d : orientationTab) {
			if (c == d) {
				val = 1;
				break;
			} else {
				val = 0;
			}
		}
		if (val == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static String showDirection(char orientation) {
		if (orientation == 'n') {
			return "Nord";
		}
		if (orientation == 's') {
			return "Sud";
		}
		if (orientation == 'e') {
			return "Est";
		} else {
			return "Ouest";
		}
	}

	public static void main(String[] args) {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(new File("src/ordres.txt"));
			InputStreamReader fileReader = new InputStreamReader(fileInput);
			BufferedReader lineReader = new BufferedReader(fileReader);
			if (fileInput.available() == 0) {
				throw new FileNotFoundException(String.format("Le fichier %s n'existe pas !", fileInput));
			}
			String ligne = lineReader.readLine();
			while (ligne.isEmpty()) {
				ligne = lineReader.readLine();
			}

			PositionPelouse positionPelouse = verifierPositionPelouse(ligne);
			Pelouse pelouse = new Pelouse(positionPelouse.getPositionPelouseX(), positionPelouse.getPositionPelouseY());

			ligne = lineReader.readLine();
			while (ligne != null) {
				PositionTondeuze positionTondeuze = verifierPositionTondeuze(ligne);
				Tondeuze tondeuze = new Tondeuze(positionTondeuze.getPositionTondeuzeX(),
						positionTondeuze.getPositionTondeuzeY(), positionTondeuze.getOrientationTondeuze());
				ligne = lineReader.readLine();
				tondeuze.moveTondeuze(ligne);
				ligne = lineReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}