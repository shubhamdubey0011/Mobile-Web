package comcast.config;

import static utilities.PropertyFileReader.TextProp;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utilities.PropertyFileReader;
import comcast.custom.CustomFun;



public class BaseTest {

	//public static WebDriver driver;
	public static WebDriver driver;
	//public AppiumDriver driver;
	public static Logger log;
	public String rootDir = CustomFun.getRootDir();
	public static ITestResult result;
	public static Process process;
	public static String driverName;
	

	@BeforeSuite
	public void suiteSetUp() throws Exception {
		// For logging
		log = Logger.getLogger(this.getClass().getName());
	}

	//@Parameters({"DRIVER"})
	@BeforeTest
	public void setUp() throws Exception {
		
		// Assigning default value to ITestResult variable 
		result = null;
/*
		//File appDir = new File("E:\\WK_Appium\\AppiumComcastProject\\app\\");
		//File appDir = new File(rootDir + "/AppiumComcastProject/app/");
		
		//File app = new File(appDir, "comcast.apk");
		//File app = new File(appDir, "Watchable.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();


		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

		// capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		//capabilities.setCapability(CapabilityType.PLATFORM, "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
		//capabilities.setCapability("app", app.getAbsolutePath());

		// capabilities.setCapability("app-package","com.deo.mobile1");
		//capabilities.setCapability("app-package","com.valtech.comcast");
		capabilities.setCapability("appPackage", "com.comcast.watchablephone");
	
		//capabilities.setCapability("app-package","com.valtech.comcast");
		 //Here we mention the activity name, which is invoked initially as app's first page.

		// capabilities.setCapability("app-activity",".StartupActivity");
		//capabilities.setCapability("app-activity","ComcastMainActivity");

		capabilities.setCapability("appActivity", ".activity.LoginActivity");



		//capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");*/

		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities); 
			
					


		// ************* Load Property File********************
		PropertyFileReader.loadProprtyFile();
		
		driverName= TextProp.getProperty("driverName");
		
		System.out.println("driverName=" + driverName);
		
		switch (driverName) {
		case "CHROME":
			
			
			// Chrome driver set up 
			System.setProperty("webdriver.chrome.driver", rootDir
					+ "/resources/chromedriver.exe");
			
			if (rootDir.contains("WatchableMobileWeb")) {

				System.setProperty("webdriver.chrome.driver", rootDir
						+ "/resources/chromedriver.exe");

			}

			else {
								
				System.setProperty("webdriver.chrome.driver", rootDir
						+ "/WatchableMobileWeb/resources/chromedriver.exe");

			}
				
			
			// Initiating the Chrome Driver.
			driver = new ChromeDriver();
			// Maximizing the webdriver browser window.
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			break;
		case "ANDROID":
			
			// Kill the Appium/nodejs server process -if exists.

						/*if (CustomFun.isProcessRunging("node.exe")) {
							Runtime.getRuntime().exec("taskkill /F /IM node.exe");
						}
						Thread.sleep(5000);
						// launching the appium server including the log file path parameter
						Runtime.getRuntime().exec(
								"cmd /c appium -g \"" + rootDir + "/logs/appium.log" + "\"");
						Thread.sleep(5000);*/
			DesiredCapabilities capabilitiesAndroid = new DesiredCapabilities();
			capabilitiesAndroid.setCapability("browserName", "Chrome");
			// capabilitiesAndroid.setCapability("device", "Android");
			capabilitiesAndroid.setCapability("deviceName", "Android");
			capabilitiesAndroid.setCapability("platformName", "Android");
			// capabilitiesAndroid.setCapability("app-activity",
			// "com.android.chrome.Main");
			Thread.sleep(1000);
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),
					capabilitiesAndroid);

			Thread.sleep(1000);
			driver.manage().deleteAllCookies();
						driver.manage().deleteAllCookies();
						log.info("Appium/nodejs server is initated..!!");
						break;
		}
		
		
		

		/*
		 * Select the relative drive as configured at BasicConfig.csv file using
		 * switch-case.
		 */
	//	driver = CustomFun.initializeDriver(driver, rootDir, process);
		
	}

	@AfterTest
	public  void tearDown() throws Exception {

		// Quitting the driver once the execution is finished.
		if (driver != null) {
			driver.quit();
		}
		
	}
	
	
	
	
}

	

