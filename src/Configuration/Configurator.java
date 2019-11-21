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

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class Configurator {

	

	

		
		private final String size="MX_SIZE";
		private final String properties="ressources/.properties";
		private final String pathBlock="PathBlock";
		private final String pathdescriptor="pathdescriptor";
		private final String pathSdescriptor="pathSdescriptor";
		private final String pathRSdescriptor="pathRSdescriptor";
		
		private final int taille=10;
		private InputStream input ;
		private Properties prop = new Properties();
		private OutputStream output;
	    
		
		
		public  Configurator() throws IOException {
			
			input = new FileInputStream(properties) ;
			output = new FileOutputStream(properties) ;
			
			
					
			 prop.setProperty("MX_SIZE",String.valueOf(taille));
	         prop.setProperty(pathBlock,"Files/blocks/");
	         prop.setProperty(pathdescriptor,"Files/Result/");
	      /*   prop.setProperty(pathSdescriptor,"Files/Result/");
	         prop.setProperty(pathRSdescriptor,"Files/Result/");*/

	         // save properties to project root folder
	         prop.store(output, null);
	        
		}
		public int getMX_SIZE() throws IOException {
			prop.load(input);
			
			return Integer.parseInt(prop.getProperty(size));
		}
		
		
		public String getPathR() throws IOException {
			 prop.load(input);
			return prop.getProperty(pathdescriptor);	
		}
		
		public String getPathS() throws IOException {
			prop.load(input);
			return prop.getProperty(pathSdescriptor);
		}
		public String getPathRS() throws IOException {
			prop.load(input);
			return prop.getProperty(pathRSdescriptor);
		}
		
		public String getPathBlock() throws IOException {
			prop.load(input);
			return prop.getProperty(pathBlock);
		}
		
		
		
		public void setSize(int MX_SIZE) throws IOException {
			
			
			 prop.setProperty(size, String.valueOf(MX_SIZE));
	         prop.store(output, null);
		}
		
		
		
		public void setPathR(String pathR) throws IOException {

			prop.setProperty(pathdescriptor, pathR);
	        prop.store(output, null);
			
		}
		public void setPathBlock(String path) throws IOException {

			prop.setProperty(pathBlock, path);
	        prop.store(output, null);
			
		}
		public void setPathS(String pathS) throws IOException {

			prop.setProperty(pathSdescriptor, pathS);
	        prop.store(output, null);
			
		}
		
		public void setPathRS(String pathRS) throws IOException {

			prop.setProperty(pathRSdescriptor, pathRS);
	        prop.store(output, null);
			
		}
	}

	

