package Main;


import java.io.IOException;

import Configuration.Configurator;
import Configuration.Fichier;
import FileDescriptor.Block;
import FileDescriptor.FileDesriptor;
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
public class Execution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Configurator config= new Configurator();
		Fichier fichier = new Fichier(config);
		BlockModel block = new Block(config , fichier);
		FileDesriptor desc = new FileDesriptor(config,fichier);
		
		desc.create("R");
		
		block.create();
		String []tab= {"helo","abdelhak","tu vas bien"};
		String []tab2= {"oui ","merci","et toi"};
		block.store(tab);
		desc.addBlock(block);
		block.create();
		block.store(tab2);
		desc.addBlock(block);
		
		desc.removeBlock(block);
		
		block.load(desc.getNextBlock());
		System.out.println(block.getPos());
		
	}

}
