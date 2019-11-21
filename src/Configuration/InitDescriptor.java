package Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import FileDescriptor.Block;
import Model.BlockModel;
import Model.FileDescriptorModel;
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

public class InitDescriptor {

	static int index = 0;
	static int i = 0;
	static int lenR = 96;
	static int lenS = 44;
	
	public InitDescriptor(int lenR, int lenS) {
		index = 0;
		i = 0;
		this.lenR = lenR;
		this.lenS = lenS;
	}

	public static void initDescriptors(Configurator config, Fichier fichier, FileDescriptorModel fdR, FileDescriptorModel fdS) throws IOException {
		
		int max_size = config.getMX_SIZE();
		
		System.out.println(max_size);
		
		ArrayList<String> shuffleString = ShuffleString.shuffleChar();

		BlockModel block = new Block(config, fichier);

		String tab[] = new String[max_size];

		while (i < lenR) {

			tab[index] = shuffleString.get(i);
			i++;
			index = i % max_size;

			if (index == 0) {
				block.create();
				block.store(tab);
				fdR.addBlock(block);
				tab = new String[max_size];
			}
		}
		
		block.create();
		block.store(tab);
		fdR.addBlock(block);

		Collections.shuffle(shuffleString);

		i = 0;
		index = 0;
		tab = new String[max_size];
		while (i < lenS) {

			tab[index] = shuffleString.get(i);
			i++;
			index = i % max_size;

			if (index == 0) {
				block.create();
				block.store(tab);
				fdS.addBlock(block);
				tab = new String[max_size];
			}
		}
		block.create();
		block.store(tab);
		fdS.addBlock(block);
	}
}
