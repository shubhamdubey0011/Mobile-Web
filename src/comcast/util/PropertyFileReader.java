package comcast.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import comcast.custom.CustomFun;

public class PropertyFileReader 
{

	/**
	 * Properties.
	 */
	public static Properties ObjRepoProp;
	public static Properties TextProp;
	public static String rootDir = CustomFun.getRootDir();
	
	/**
	 * Load Property File.
	 * 
	 **/
	public static void loadProprtyFile() {

		ObjRepoProp = new Properties();
		TextProp = new Properties();
		
		try {

			System.out.println("*****chotu*****"+rootDir);

			// Reading/loading the ObjectRepository/Text property files.

			if (rootDir.contains("webPortalActiTime")) {

				ObjRepoProp.load(new FileInputStream(rootDir
						+ "/WatchableMobileWeb/resources/ObjRepository.properties"));

				TextProp.load(new FileInputStream(rootDir
						+ "/WatchableMobileWeb/resources/Text.properties"));

			}

			else {
				ObjRepoProp
						.load(new FileInputStream(
								rootDir
										+ "/WatchableMobileWeb/resources/ObjRepository.properties"));
				TextProp.load(new FileInputStream(rootDir
						+ "/WatchableMobileWeb/resources/ObjRepository.properties"));

			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
