package test.tek.sdet.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestFileUtility {
	//read each charator// now we want it to read yaml file
	// instead of using the meathod repeatily, we use this class
	public static FileInputStream getFileInputStream(String filePath) 
										throws FileNotFoundException {
		
		return new FileInputStream (new File (filePath));
		
	}
}
