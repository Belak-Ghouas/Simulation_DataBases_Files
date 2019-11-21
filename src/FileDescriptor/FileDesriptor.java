package FileDescriptor;
import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Configuration.Configurator;
import Configuration.Fichier;
import Model.BlockModel;
import Model.FileDescriptorModel;
import javafx.scene.control.Tab;
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
public class FileDesriptor implements FileDescriptorModel {

	
	private Configurator config;
	private Fichier fichier;
	
	private String numBlock="";
	private String [] TabChar;
	private String Namefile;
	
	 public FileDesriptor(Configurator config ,Fichier fichier) throws IOException {
			this.config=config;
			this.fichier=fichier;
			TabChar=new String[config.getMX_SIZE()];
	}
	 
	 
	@Override
	public void create(String name ) throws IOException {
		
		Namefile=config.getPathR()+name+".txt";
		
		 File file = new File(Namefile);
	        if(file.createNewFile()){
	            System.out.println(Namefile+" : File Created");
	        }else System.out.println("File "+Namefile+" already exists");
	       
		
	}

	@Override
	public int getNextBlock() throws IOException {
		// TODO Auto-generated method stub
		
	
		TabChar=fichier.lire(Namefile);
		
		if(numBlock.equals("")) {
			
			numBlock="0";
			return 0 ;
			
		}
		
		int i=0;
		while(i<TabChar.length && TabChar[i]!=null) {
			
			
			if(numBlock.equals(TabChar[i]) ) {
				
				if(i+1<TabChar.length && TabChar[i]!=null) {
					
					numBlock=TabChar[i+1];
					return Integer.parseInt(TabChar[i+1]);
				}else return -1;
			}
			i++;
		}
		
		return -1;
	}

	@Override
	public void addBlock(Block block) throws IOException {
		int i=0;
		int pos=-1;
		
		while (i<TabChar.length) {
			if(TabChar[i]==(null) ) {
				pos=i;
				break;
			}	
			i++;
		}
		
		TabChar[pos]=String.valueOf(block.getId());
		fichier.ecrire(TabChar, Namefile);
	}

	@Override
	public int removeBlock(Block block) throws IOException {
		int i=0;
		int pos=0;
		boolean find =false;
		
		while (i< TabChar.length) {
			
			if(TabChar[i].equals(String.valueOf(block.getId()))) {
				
				TabChar[i]=null;
				pos=i;
				find=true;
				Files.delete(Paths.get(config.getPathBlock()+block.getNameFile()));
				break;
			}
			i++;
		}
		if(find) {
		int j=pos+1;
		while(j<TabChar.length && TabChar[j]!=null) {
			TabChar[pos]=TabChar[j];
			TabChar[j]=null;
			pos++;
			j++;
		}
		fichier.ecrire(TabChar, Namefile);
		return 1;
		}
		return -1;
	}

}
