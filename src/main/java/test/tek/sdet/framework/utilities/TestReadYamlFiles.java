package test.tek.sdet.framework.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import org.yaml.snakeyaml.Yaml;

public class TestReadYamlFiles {

	// singleton pattern: we make the constructor private, then we create a
	// static reference to this class. every time we create obj of this class
	// this will check if an obj created will return that not create new one
	// we dont create obj of one class more them one time, for saving memory
	// how to use the instance of a class deficiently
	// this class use signgleton

	private static TestReadYamlFiles readYamlFiles;
	private HashMap propertyMap;

	private TestReadYamlFiles(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = TestFileUtility.getFileInputStream(filePath);
		Yaml yaml = new Yaml();
		this.propertyMap = yaml.load(fileInputStream);
	}

	public HashMap getYamlProperty(String key) {
		return (HashMap) this.propertyMap.get(key);
	}

	// this method checks if there is an instance of a class or not
	public static TestReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if (readYamlFiles == null)
			readYamlFiles = new TestReadYamlFiles(filePath);
		return readYamlFiles;
	}
}