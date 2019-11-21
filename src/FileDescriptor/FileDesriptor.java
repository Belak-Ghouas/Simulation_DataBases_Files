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
 * Nom : GHOUAS Prénom : Abdelhak N° d'étudiant : 21707514 email :
 * ghouas.abdelhak@gmail.com
 * 
 * 
 * Nom : OUHENIA Prénom : Nassim N° d'étudiant : 21703313 email :
 * nassim.ouhenia@gmail.com
 *
 * Remarques :
 */
public class FileDesriptor implements FileDescriptorModel {

	private Configurator config;
	private Fichier fichier;
	private int numBlock ;
	private String[] TabChar;
	private int pos=0;
	private String Namefile;

	public FileDesriptor(Configurator config, Fichier fichier) throws IOException {
		this.config = config;
		this.fichier = fichier;
		numBlock=0;
		TabChar = new String[config.getMX_SIZE()];
		for (int i=0;i<TabChar.length;i++) {
			if(TabChar[i]!=null)
				pos+=1;
		}
	}

	@Override
	public String[] getCharTab() {
		return this.TabChar;
	}

	@Override
	public void SetNumBlock(int s) {
		this.numBlock=s ;
	}

	@Override
	public int getNumBlock() {
		return numBlock;
	}
	
	@Override
	public int  getPos() {
		return pos;
	}
	
	@Override
	public String getNameFile() {
		return this.Namefile;
	}
	@Override
	public void create(String name) throws IOException {

		Namefile = config.getPathR() + name + ".txt";
		
		File file = new File(Namefile);
		if (file.createNewFile()) {
			System.out.println(Namefile + " : File Created");
		} else
			System.out.println("File " + Namefile + " already exists");

	}

	@Override
	public int getNextBlock() throws IOException {
		// TODO Auto-generated method stub

		TabChar = fichier.lire(Namefile);
		int tmp=0;
		if(numBlock<pos) {
			
			tmp=numBlock;
			numBlock++;
		}else {
			return -1;
		}
		return Integer.parseInt(TabChar[tmp]);
	}

	@Override
	public void addBlock(BlockModel block) throws IOException {
		int i = 0;
		
		if(pos<TabChar.length) {
			TabChar[pos] = String.valueOf(block.getId());
		}
		fichier.ecrire(TabChar, Namefile);
		this.pos++;
	}

	@Override
	public int removeBlock(BlockModel block) throws IOException {
		int i = 0;
		int pos = 0;
		boolean find = false;

		while (i < TabChar.length) {

			if (TabChar[i].equals(String.valueOf(block.getId()))) {

				TabChar[i] = null;
				pos = i;
				find = true;
				Files.delete(Paths.get(config.getPathBlock() + block.getNameFile()));
				break;
			}
			i++;
		}
		if (find) {
			int j = pos + 1;
			while (j < TabChar.length && TabChar[j] != null) {
				TabChar[pos] = TabChar[j];
				TabChar[j] = null;
				pos++;
				j++;
			}
			this.pos--;
			fichier.ecrire(TabChar, Namefile);
			return 1;
		}
		return -1;
	}

}
