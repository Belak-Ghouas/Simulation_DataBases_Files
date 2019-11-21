package Model;

import java.io.IOException;
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
public interface BlockModel {
		
		public void create() throws IOException;
		public String [] load(int NumBlock) throws IOException;
		public void store(String [] tab) throws IOException;
		String getNameFile();
		void setNumBlock(int numBlock);
		int getId();
		int getNumBlock();
		String[] getCharTab();
		int getPos();
		
		}
