package dataConfigs;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader reader = new FileReader(".//src/test/resources/configs/application.properties");
		Properties props = new Properties();
		props.load(reader);
		reader.close();

		System.out.println("ChromeDriver\t: " + props.getProperty("ChromeDriver"));
		System.out.println("ChromeDriverLoc\t: " + props.getProperty("ChromeDriverLoc"));

	}

}
