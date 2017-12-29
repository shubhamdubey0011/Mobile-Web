package comcast.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;
import comcast.config.BaseTest;
import comcast.custom.CustomFun;

public class Screenshot extends BaseTest
{


	// Get the root directory of the project
	public static String rootDir = CustomFun.getRootDir();
	public static File scrFile;
	static Date today = Calendar.getInstance().getTime();

	// For logging
	public Logger log = Logger.getLogger(this.getClass().getName());

	// create our "formatter" (our custom format)
	String pattern = "MM/dd/yyyy";

	static SimpleDateFormat formatter = new SimpleDateFormat(
			"dd_MMM_yyyy_hh_mm_ss");
	Date date = new Date();
	long a = date.getTime();
	String screenshots = null;

	public void onTestFailure(ITestResult result) {

		// Handling Android/IOS Appium server skipping at runtime.

		if ((result.getThrowable().toString()
					.contains("UnreachableBrowserException"))) {

				BaseTest.result = result;

				log.info("Appium server is skipped at runtime.");
				Reporter.log("<p>Appium server is skipped at runtime.");
			
		}

		if (result.getThrowable().toString().contains("IllegalStateException")) {

			Reporter.log("<br />"
					+ "<a href=\""+"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/"
					+ rootDir
					+ "/screenshots/"
					+ result.getName()
					+ result.getStartMillis()
					+ ".png\" class=\"highslide\" rel=\"highslide\">"
					+ " <img src=\""+"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/"
					+ rootDir
					+ "/screenshots/"
					+ result.getName()
					+ result.getStartMillis()
					+ ".png\"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a>"
					+ "<br/>");
			Reporter.log("<a href=\"" +"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/"+ rootDir + "/screenshots/"
					+ result.getName() + result.getStartMillis() + ".png\">"
					+ result.getName() + result.getStartMillis() + " </a>"
					+ "<br/>");

			// For RemoteWebDriver - Argument the RemoteWebDriver to WebDriver
			// to achieve the screenshot capturing.
			if (BaseTest.driver
					.getClass()
					.getName()
					.equalsIgnoreCase(
							"org.openqa.selenium.remote.RemoteWebDriver")) {
				WebDriver augmentedDriver = new Augmenter()
						.augment(BaseTest.driver);
				scrFile = ((TakesScreenshot) augmentedDriver)
						.getScreenshotAs(OutputType.FILE);
			} else {
				scrFile = ((TakesScreenshot) BaseTest.driver)
						.getScreenshotAs(OutputType.FILE);
			}
			try {
				FileUtils.copyFile(scrFile, new File(rootDir + "/screenshots/"
						+ result.getName() + result.getStartMillis() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			BaseTest.result = result;

			BaseTest.driver.quit();

		} else {
			if (!(result.getThrowable().toString()
					.contains("UnreachableBrowserException: "))
					&& !(result.getThrowable().toString()
							.contains("SessionNotFoundException"))) {
				Reporter.log("<br />"
						+ "<a href=\""+"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/"
						+ rootDir
						+ "/screenshots/"
						+ result.getName()
						+ result.getStartMillis()
						+ ".png\" class=\"highslide\" rel=\"highslide\">"
						+ " <img src=\""+"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/"
						+ rootDir
						+ "/screenshots/"
						+ result.getName()
						+ result.getStartMillis()
						+ ".png\"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a>"
						+ "<br/>");
				Reporter.log("<a href=\""+"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/" + rootDir + "/screenshots/"
						+ result.getName() + result.getStartMillis()
						+ ".png\">" + result.getName()
						+ result.getStartMillis() + " </a>" + "<br/>");
				// For RemoteWebDriver - Argument the RemoteWebDriver to
				// WebDriver
				// to achieve the screenshot capturing.
				if (BaseTest.driver
						.getClass()
						.getName()
						.equalsIgnoreCase(
								"org.openqa.selenium.remote.RemoteWebDriver")) {
					WebDriver augmentedDriver = new Augmenter()
							.augment(BaseTest.driver);
					scrFile = ((TakesScreenshot) augmentedDriver)
							.getScreenshotAs(OutputType.FILE);
				} else {
					scrFile = ((TakesScreenshot) BaseTest.driver)
							.getScreenshotAs(OutputType.FILE);
				}
				try {
					FileUtils.copyFile(
							scrFile,
							new File(rootDir + "/screenshots/"
									+ result.getName()
									+ result.getStartMillis() + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Skip");
		try {
			// Close all browsers
			BaseTest.driver.quit();

		} catch (NullPointerException e) {
			result.setThrowable(e);
			e.printStackTrace();

		}

	}

	public void onTestSuccess(ITestResult result) {
		try {

			Reporter.log("<br />"
					+ "<a href=\""+"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/"
					+ rootDir
					+ "/screenshots/"
					+ result.getName()
					+ result.getStartMillis()
					+ ".png\" class=\"highslide\" rel=\"highslide\">"
					+ " <img src=\""+"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/"
					+ rootDir
					+ "/screenshots/"
					+ result.getName()
					+ result.getStartMillis()
					+ ".png\"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a>"
					+ "<br/>");
			Reporter.log("<a href=\"" +"http://10.33.195.172:8080/job/LVC-Automation/3/HTML_Report/"+ rootDir + "/screenshots/"
					+ result.getName() + result.getStartMillis() + ".png\">"
					+ result.getName() + result.getStartMillis() + " </a>"
					+ "<br/>");

			// For RemoteWebDriver - Argument the RemoteWebDriver to WebDriver
			// to achieve the screenshot capturing.
			if (BaseTest.driver
					.getClass()
					.getName()
					.equalsIgnoreCase(
							"org.openqa.selenium.remote.RemoteWebDriver")) {
				WebDriver augmentedDriver = new Augmenter()
						.augment(BaseTest.driver);
				scrFile = ((TakesScreenshot) augmentedDriver)
						.getScreenshotAs(OutputType.FILE);
			} else {
				scrFile = ((TakesScreenshot) BaseTest.driver)
						.getScreenshotAs(OutputType.FILE);
			}
			FileUtils.copyFile(scrFile, new File(rootDir + "/screenshots/"
					+ result.getName() + result.getStartMillis() + ".png"));

			FileUtils.copyFile(scrFile, new File(rootDir + "/screenshots/"
					+ result.getName() + result.getStartMillis() + ".png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
