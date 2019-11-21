package Model;

import java.io.IOException;

public interface BlockModel {
		
		public void create() throws IOException;
		public String [] load(int NumBlock) throws IOException;
		public void store(String [] tab) throws IOException;
		
		}
