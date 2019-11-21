package Configuration;

import java.util.ArrayList;
import java.util.Collections;
/**
* TP n°4 V n°1 :
*
* Titre du TP : “Disk” Nested Loop Join
* 
* Date :15/11/2019
*
* Nom : GHOUAS
* Prénom : Abdelhak
* N° d'étudiant : 21707514
* email : ghouas.abdelhak@gmail.com
* 
* 
* Nom : OUHENIA
* Prénom : Nassim
* N° d'étudiant : 21703313
* email : nassim.ouhenia@gmail.com
*
* Remarques :
*/
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
