package Model;

import java.io.IOException;

import FileDescriptor.Block;
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
public interface FileDescriptorModel {

	public void create(String namefile ) throws IOException;
	public int getNextBlock() throws IOException;
	public void addBlock(Block block) throws IOException;
	public int removeBlock(Block block) throws IOException;
	
}
