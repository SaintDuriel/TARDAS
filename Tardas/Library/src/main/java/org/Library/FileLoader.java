package org.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileLoader {

	/**
	 * Returns a file object. 
	 * @param fileName - The Full path to the file, or if using java relative paths the relative path. 
	 * @return
	 */
	public static File loadFile(String fileName) { 
		File file = new File(fileName); 
		return file; 
	}
	
	public synchronized static FileInputStream loadFileInputStream(File file) { 
		try { 
			return new FileInputStream (file); 
		} catch (FileNotFoundException fnfE) { 
			fnfE.printStackTrace();
		}
		return null; 
	}
	
	public static File loadPropertyFile(String fileName) { 
		File file = loadFile(fileName); 
		return file; 
	}
	
	
}
