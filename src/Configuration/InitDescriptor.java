package Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import FileDescriptor.Block;
import FileDescriptor.FileDesriptor;
import Model.BlockModel;


public class InitDescriptor {

	static int index = 0;
	static int i = 0;
	static int len = 96;

	public static void initDescriptors(Configurator config, Fichier fichier, FileDesriptor fdR, FileDesriptor fdS) throws IOException {
		
		int max_size = config.getMX_SIZE();
		
		ArrayList<String> shuffleString = ShuffleString.shuffleChar();

		BlockModel block = new Block(config, fichier);

		String tab[] = new String[max_size];

		while (i < len) {

			tab[index] = shuffleString.get(i);
			i++;
			index = i % max_size;

			if (index == 0) {
				block.create();
				block.store(tab);
				fdR.addBlock(block);
			}
		}

		Collections.shuffle(shuffleString);

		i = 0;
		index = 0;
		len = 44;

		while (i < len) {

			tab[index] = shuffleString.get(i);
			i++;
			index = i % max_size;

			if (index == 0) {
				block.create();
				block.store(tab);
				fdR.addBlock(block);
			}
		}
	}
}
