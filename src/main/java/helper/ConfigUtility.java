package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ConfigUtility {
	@Test
	public static String readProperty(String keyname) {
		
    File src = new File(System.getProperty("user.dir")+"/Configuration/config.properties");
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Could not find File" +e.getMessage());
		}
		
		Properties pro = new Properties();
		
		try {
			
			pro.load(fis);
			
		} catch (IOException e) {
			
		System.out.println("Could not read file" +e.getMessage());
			
		}
		
		String value = pro.getProperty(keyname);
				
		return value;
		
		
	}

}
