package Configuration;

/**
* TP n°2 V n°1 :
*
* Titre du TP : HashLinearProbing
* 
* Date :08/11/2019
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Fichier {

	
	private Configurator config;
	
	
	public  Fichier(Configurator config) {
		
		this.config=config;
	}
	
	 public void ecrire(String [] rs , String path) throws IOException {
		 
		BufferedWriter writter = new BufferedWriter(new FileWriter(path));
		int i=0;
		 while ( i < rs.length && rs[i]!=null) {
			
			writter.write(rs[i]);
			writter.flush();
			writter.write('\n');
			writter.flush();
			i++;

		}
		 writter.close();
		 
	 }
	 
	 
	 public String[] lire(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
			int i=0;
			String [] tab= new String[config.getMX_SIZE()];
			
			String s;
			while ((s = reader.readLine()) != null) {
				tab[i] = s;
				i++;
				
			}
			
			reader.close();
			return tab;
			
			
		}
	
}
