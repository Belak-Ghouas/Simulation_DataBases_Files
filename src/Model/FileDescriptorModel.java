package Model;

import java.io.IOException;

import FileDescriptor.Block;

public interface FileDescriptorModel {

	public void create(String namefile ) throws IOException;
	public int getNextBlock() throws IOException;
	public void addBlock(Block block) throws IOException;
	public int removeBlock(Block block) throws IOException;
	
}
