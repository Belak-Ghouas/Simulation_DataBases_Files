package FileDescriptorTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Configuration.Configurator;
import Configuration.Fichier;
import FileDescriptor.Block;
import Model.BlockModel;
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
class BlockTest {
	BlockModel block;
	Configurator config;
	Fichier fichier;
	int Id=0;
	String [] exemple= {"AB","AC","AA","AZ","RE","NF","GV","XZ","EZ","HH"};
	@BeforeEach
	void setUp() throws Exception {
		config= new Configurator();
		 fichier = new Fichier(config);
		 block = new Block(config , fichier);
	}

	@Test
	void testCreate() throws IOException {
		
	}

	@Test
	void testLoad() throws IOException {
		block.create();
		block.store(exemple);
		String [] s=block.load(0);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i] +" "+exemple[i]);
		}
		assertArrayEquals(s,exemple);
		
	}

	@Test
	void testStore() {
		
	}

}
