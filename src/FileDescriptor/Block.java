package FileDescriptor;
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
import java.io.File;
import java.io.IOException;

import Configuration.Configurator;
import Configuration.Fichier;
import Model.BlockModel;

public class Block implements BlockModel {
	
	private static int  NumBlock=0;
	private String [] TabChar;
	private int Id;
	private String Namefile;
	private Configurator config;
	private Fichier fichier;
	
	
	public Block (Configurator config , Fichier fichier) throws IOException {
		
		this.config=config;
		this.fichier=fichier;
		TabChar=new String[config.getMX_SIZE()];
		
	}
	
	

	public int getNumBlock() {
		return NumBlock;
	}
	
	public int getId() {
		return this.Id;
	}

	public void setNumBlock(int numBlock) {
		NumBlock = numBlock;
	}

	@Override
	public void create() throws IOException {
		// TODO Auto-generated method stub
		Namefile="B"+NumBlock+".txt";
		Id=NumBlock;
		
		 NumBlock++;
		 File file = new File(config.getPathBlock()+Namefile);
	        if(file.createNewFile()){
	            System.out.println(Namefile+" : File Created");
	           
	        }else System.out.println("File "+Namefile+" already exists");
	        
	}

	@Override
	public String [] load(int Id) throws IOException {
		Namefile="B"+Id+".txt";
		String path=config.getPathBlock()+Namefile;
		TabChar=fichier.lire(path);
		this.Id=Id;
		return TabChar;
		
	}

	@Override
	public void store(String [] tab) throws IOException {
		String path=config.getPathBlock()+Namefile;
		fichier.ecrire(tab, path);
		
	}
	
	public String getNameFile() {
		return this.Namefile;
	}
	

}
