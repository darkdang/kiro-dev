package kr.re.kiro.utils;

import java.io.File;
import java.io.IOException;

public interface FileSaveStrategy {

	public void setRootDirectory(File rootDirectory) throws IOException;

	public File getRootDirectory();

	public File createNewFile() throws IOException;

	public File createNewFile(String name) throws IOException;
}
