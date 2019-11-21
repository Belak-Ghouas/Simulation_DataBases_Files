package Configurator;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleString {

	private final static char alphabet[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final static char exposant[] = "ABCDEFGH".toCharArray();
	private static ArrayList<String> shuffle = new ArrayList<String>();

	public static ArrayList<String> shuffleChar() {
		String produit = "";

		for (char ca : alphabet) {
			for (char ce : exposant) {
				produit = ca + "" + ce;
				shuffle.add(produit);
			}
		}
		Collections.shuffle(shuffle);

		return shuffle;
	}

}
