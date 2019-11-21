package Main;


import java.io.IOException;

import Configuration.Configurator;
import Configuration.Fichier;
import Configuration.InitDescriptor;
import FileDescriptor.Block;
import FileDescriptor.FileDesriptor;
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
public class Execution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Configurator config= new Configurator();
		Fichier fichier = new Fichier(config);
		
		FileDesriptor fdR = new FileDesriptor(config,fichier);
		FileDesriptor fdS = new FileDesriptor(config,fichier);
		
		fdR.create("R");
		fdS.create("S");
		
		InitDescriptor.initDescriptors(config, fichier, fdR, fdS);
		
	}

}
