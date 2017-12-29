package comcast.custom;

import static utilities.PropertyFileReader.ObjRepoProp;
import static utilities.PropertyFileReader.TextProp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

public class CustomFun {

	private static final String TASKLIST = "tasklist";
	//private static final String KILL = "taskkill /IM ";

	public static Logger log = Logger.getLogger(CustomFun.class.getName());

	
	public static BigDecimal taxAmtGST;
	public static BigDecimal taxAmtPST;
	public static BigDecimal taxAmtQST;
	public static BigDecimal taxAmtHST;

	/**
	 * Method Name: isElementPresent Description:Method to verify the Element
	 * 
	 * @param by
	 *            :Element locator
	 * @param driver
	 *            :WebDriver
	 * @return true: if element is present, false: if element is not present
	 */
	public static boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Method Name: getRootDir Description: Method to get Root directory
	 * 
	 * @return :rootDir
	 */
	public static String getRootDir() {
		File path = new File("");
		String absPath = path.getAbsolutePath();
		File dir = new File(absPath);
		String rootDir = dir.getParent();
		return rootDir;

		// return absPath;
	}

	/**
	 * Method Name: refreshPage Description: Method to used refresh a page after
	 * doing some action (if required page refresh)
	 * 
	 * @param driver
	 *            :WebDriver
	 * @return driver
	 */
	public static WebDriver refreshPage(WebDriver driver) {

		driver.navigate().refresh();
		return (driver);
	}

	/**
	 * Method Name: switchToNewWindow Description: This function switches the
	 * browser control to new window and verifies title
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param pageTitle
	 *            : title of the page
	 * @return newWindow(driver)
	 */
	public static WebDriver switchToNewWindow(WebDriver driver, String pageTitle) {

		WebDriver newWindow = null;
		Set<String> windowIterator = driver.getWindowHandles();
		System.err.println("No of windows :  " + windowIterator.size());
		for (String s : windowIterator) {
			String windowHandle = s;
			newWindow = driver.switchTo().window(windowHandle);
			System.out.println("Window Title : " + newWindow.getTitle());
			System.out.println("Window Url : " + newWindow.getCurrentUrl());
			if (newWindow.getTitle().equals(pageTitle)) {
				System.out.println("Selected Window Title : "
						+ newWindow.getTitle());
				return newWindow;
			}

		}
		System.out.println("Window Title :" + newWindow.getTitle());
		System.out.println();
		return newWindow;
	}
	
	/**
	 * This function switches back the handle to parent window.
	 * 
	 * @param driver
	 * @param winHandleBefore
	 */
	public static void switchBackToParentWindow(WebDriver driver, String winHandleBefore) {

		try {
			//Close opened browser
			driver.close();
			
			//Switch back to parent window 
			driver.switchTo().window(winHandleBefore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Method Name: isElementHighlighted Description: This function verifies
	 * whether the element is highlighted or not on rollover/mouseOver of the
	 * element based on the action specified
	 * 
	 * @param driver
	 *            : WebDriver instance
	 * 
	 * @param WebElement
	 *            : WebElement that needs to rollover or click to check element
	 *            is highlighted or not
	 * 
	 * @param isHighlight
	 *            : If true checks element is highlighted If false checks
	 *            element is not highlighted
	 * 
	 * @param action
	 *            : "rollOver" : mousehover / roll overs on specified element
	 *            "click" : clicks on specified element
	 * 
	 * @param eleName
	 *            : Name of the element
	 * 
	 * @param prop
	 *            : property of the element
	 * 
	 * @throws Exception
	 *             ,ElementNotHiglightedException, ElementHiglightedException
	 * 
	 */
	

	/**
	 * Method Name: waitObjectToLoad Description: This function waits until the
	 * specific element to load
	 * 
	 * @param driver
	 *            : WebDriver instance
	 * @param by
	 *            :Element locator
	 * @param timeSec
	 *            :time in seconds
	 */
	public static void waitObjectToLoad(WebDriver driver, By by, int timeSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeSec);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

	/**
	 * Method Name:isStringUpperCase Description:Verifies String is in uppercase
	 * or in lowercase
	 * 
	 * @param str
	 * @param isUpper
	 *            : true: if string needs to be checked for uppercase false:if
	 *            string needs to be checked for lowercase
	 * @return true,if string is in upper case false, if string is not in upper
	 *         case
	 * 
	 */
	public static boolean isStringUpperCase(String str, boolean isUpper) {

		String newStr = null;

		if (str.contains("&") || str.contains(",") || str.contains(">")) {
			// Remove special characters and spaces in the string
			newStr = str.replaceAll("[,&>]+", "").replaceAll("\\s+", "");

		} else {
			// Remove spaces present in the string
			newStr = str.replaceAll("\\s+", "");

		}

		if (isUpper) {
			// Check string is in upper case
			boolean isUpperCase = StringUtils.isAllUpperCase(newStr);

			if (isUpperCase) {
				log.info("Text is in uppercase: " + str);
				Reporter.log("Text is in uppercase: " + str);

				return true;

			}
			log.error("Text is not in uppercase: " + str);
			Reporter.log("Text is not in uppercase: " + str);
			return false;
		} else {
			boolean isLowerCase = StringUtils.isAllLowerCase(newStr);

			if (isLowerCase) {
				log.info("Text is in LowerCase: " + str);
				Reporter.log("Text is in LowerCase: " + str);

				return true;

			}
			log.error("Text is not in lowercase: " + str);
			Reporter.log("Text is not in lowercase: " + str);
			return false;

		}
	}

	/**
	 * Method name:verifyLinksPostion Descriptio:This function verifies links
	 * Position
	 * 
	 * @param driver
	 * @param breakPoint
	 */
	public static void verifyLinksPostion(WebDriver driver, String breakPoint,
			String linkText, String Previouslink, int pos) {
		if (breakPoint.equals("L") || breakPoint.equals("M")) {

			// Getting all link in to list
			List<WebElement> allElements = driver.findElements(By
					.xpath(ObjRepoProp.getProperty("footerLinkPanel_XPATHS")));
			int lnkCount = 0;
			ArrayList<String> lnkArray = new ArrayList<String>();
			// Adding link test in to an array
			for (WebElement element : allElements) {
				if (!element.getText().equals("")) {
					lnkArray.add(element.getText());
					lnkCount = lnkCount + 1;
				}
			}
			// Verifying the link order
			for (int i = 0; i < lnkCount;) {
				if (linkText.equals(lnkArray.get(pos))) {
					log.info("The " + linkText + " Link Present next to "
							+ Previouslink);
					Reporter.log("<p>The " + linkText
							+ " Link Present next to " + Previouslink);
					break;
				} else {
					log.info("The " + linkText + " Link not Present next to "
							+ Previouslink);
					Reporter.log("<p>The " + linkText
							+ " Link not Present next to " + Previouslink);
					break;
				}

			}

		}
	}

	/**
	 * MethodName: isObjectAlignedLeft Description: To check object is aligned
	 * left or not
	 * 
	 * @param ele
	 *            : WebElement
	 * @return
	 */
	public static boolean isObjectAlignedLeft(WebElement ele) {

		int eleOffsetLeft = Integer.parseInt(ele.getAttribute("offsetLeft"));

		/*
		 * check the eleOffsetLeft,if eleOffsetLeft is "0", then object is
		 * aligned left
		 */
		if (eleOffsetLeft == 0) {

			return true;

		}

		return false;
	}

	/**
	 * Method Name:verifyEqualSpaceBetweenElements Description: To verify equal
	 * space between elements (Ex: space between links,space between icons)
	 * 
	 * @param eleList
	 *            :List of elements for which space between elements need to be
	 *            checked
	 * @param Msg
	 *            : Customized message based on elements Ex:Equal space is
	 *            present b/w header main navigation links
	 * @return: true: if equal space is present b/w elements false:if equal
	 *          space is not present
	 */
	public static boolean verifyEqualSpaceBetweenElements(
			List<WebElement> eleList, String msg) {

		// Array list declaration
		List<Integer> eleLeft = new ArrayList<Integer>();
		List<Integer> eleRight = new ArrayList<Integer>();
		List<Integer> spaceDiff = new ArrayList<Integer>();
		int sum = 0;

		// Store each element left position and right position
		for (int i = 0; i < eleList.size(); i++) {
			int eleWidth;
			eleLeft.add(Integer.parseInt(eleList.get(i).getAttribute(
					"offsetLeft")));

			eleWidth = Integer.parseInt(eleList.get(i).getAttribute(
					"offsetWidth"));

			eleRight.add(eleLeft.get(i) + eleWidth);

		}

		// Calculate difference between two elements
		for (int j = 0; j < (eleList.size() - 1); j++) {

			spaceDiff.add(eleLeft.get(j + 1) - eleRight.get(j));

		}

		for (int k = 0; k < spaceDiff.size(); k++) {

			sum = sum + spaceDiff.get(k);

		}

		// Calculate average difference
		double average = sum / (eleList.size() - 1);

		// Check the average difference among all elements
		if ((average - (double) (spaceDiff.get(0))) <= 1) {

			// if it is <= 1, equal difference is present
			log.info(msg);
			Reporter.log("<p>" + msg);
			return true;

		} else {

			// if not, log error message
			log.error("No equal space present between the objects");
			Reporter.log("<p>No equal space present between the objects");
			return false;
		}

	}

	/**
	 * MethodName: isElementClickable Description: To check whether element is
	 * clickable or not
	 * 
	 * @param ele
	 *            : WebElement
	 * @param eleName
	 *            : Element for which Clickable need to be checked
	 * 
	 * 
	 * @return Boolean value
	 * 
	 * 
	 */
	public static boolean isElementClickable(WebElement ele, String eleName) {

		String eleCursor = ele.getCssValue("cursor");

		boolean match = false;

		// Check element is not clickable
		if (eleCursor.equals("auto") || eleCursor.equals("text")) {

			// If not clickable, log success message
			log.info(eleName + " is not clickable");
			Reporter.log("<p>" + eleName + " is not clickable");

			match = false;

		}
		// Check element is clickable
		else if (eleCursor.equals("pointer")) {
			// if element is clickable, log error message
			log.info(eleName + " is clickable");
			Reporter.log("<p>" + eleName + " is clickable");
			match = true;
		}

		return match;
	}

	/**
	 * Method checkObjectPositionOnScreen Description: To verify footer is at
	 * the bottom of the page. (Ex:Footer link Change location is at the bottom
	 * of the page )
	 * 
	 * @param element
	 *            : Web Element
	 * @param driver
	 *            : WebDriver Instance
	 * @param message
	 *            : Customized message based on element location Ex:Element is
	 *            not at the position as expected
	 */
	public static void checkObjectPositionOnScreen(WebElement element,
			WebDriver driver, String message) {

		Point eleLocation;
		Dimension eleSize;
		Dimension pageSize;

		eleLocation = element.getLocation();
		eleSize = element.getSize();
		pageSize = driver.findElement(By.className("page")).getSize();

		if (eleLocation.y + eleSize.height == pageSize.height) {
			log.info(message);
		} else {

			log.error("Object/Element is not aligned as expected.");
		}

	}

	/**
	 * Method isTextOverlapped Description: To verify text is overlapping
	 * between elements (Ex:Footer link Apps is overlapping on Help )
	 * 
	 * @param ele
	 *            : Customized message based on elements Ex:Footer link 3 is
	 *            overlapping on link 2
	 * @param msg
	 *            : Customized message based on elements Ex:Footer link 3 is not
	 *            overlapping link 2
	 * @return; true: Their is no overlapping of text false:if Their is
	 *          overlapping of text
	 */
	public static boolean isTextOverlapped(WebElement ele, String msg) {

		String eleMarginLeft = ele.getCssValue("margin-left").toString();

		int elePixel = Integer.parseInt(eleMarginLeft.replace("px", ""));

		// Check the text is overlapped
		if (elePixel < 0) {

			// if it is < 0, text is overlapped
			log.info(msg);
			Reporter.log("<p>" + msg);
			return false;

		} else {

			// if no, log error message
			log.info("Their is no overlapping of text");
			Reporter.log("<p>Their is no overlapping of text");
			return true;
		}

	}

	/**
	 * 
	 * @param eleList
	 *            : List of elements for which width and position one under
	 *            other to be checked
	 * @param driver
	 *            : WebDriver driver
	 * @param msg
	 *            : Customized message based on elements
	 * @return true: pushes are displayed one under other false: if pushes are
	 *         not displayed one under other
	 */
	public static boolean isPushesDisplayedOneUnderOther(
			List<WebElement> eleList, WebDriver driver, String msg) {
		// Width of the page on screen
		Dimension winPoint = driver.findElement(By.className("page")).getSize();
		int screenWidth = winPoint.width;
		boolean flag = false;
		int widthSecondPush = 0;
		int secondPushYCoordinate = 0;

		// Check the pushes location one under other with same width
		for (int i = 0; i < eleList.size(); i++) {
			Point eleLocation = eleList.get(i).getLocation();
			Dimension eleHeight = eleList.get(i).getSize();
			// Width of first push
			int widthFirstPush = eleList.get(i).getSize().width;
			int firstPushYCoordinate = eleLocation.y;
			int firstPushHeight = eleHeight.height;

			for (int j = 1; j < eleList.size(); j++) {
				Point eleLocation2 = eleList.get(j).getLocation();
				// Width of Second push
				widthSecondPush = eleList.get(j).getSize().width;
				secondPushYCoordinate = eleLocation2.y;
			}
			if ((secondPushYCoordinate
					- (firstPushYCoordinate + firstPushHeight) <= 1)
					&& ((widthFirstPush == screenWidth) && (screenWidth == widthSecondPush))) {

				flag = true;

			}

		}

		if (flag) {
			// pushes are displayed one under other
			log.info(msg);
			Reporter.log("<p>" + msg);
			return true;

		} else {

			// pushes are not displayed one under other
			log.info("pushes are not displayed one under other");
			Reporter.log("<p>pushes are not displayed one under other");
			return true;
		}

	}

	/**
	 * Check the given process is running or not return true -if exists else
	 * false.
	 * 
	 * @param serviceName
	 * @return
	 * @throws Exception
	 */
	public static boolean isProcessRunging(String serviceName)
			throws Exception {
		
			Process p = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				// Log the running processes
				log.info(line);
				if (line.contains(serviceName)) {
					return true;
				}
		}
		return false;

	}

	/**
	 * MethodName:calculateCardExpiryYear
	 * 
	 * Description:Calculates Credit Card Expiry Year
	 */
	public static String calculateCardExpiryYear() throws Exception {

		// To Select current year +4 in card expiration Year dropdown
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int expYear = year + 4;
		String expYearInString = String.valueOf(expYear);

		return expYearInString;
	}

	/**
	 * MethodName:isImgSelected Description: This function checks image is
	 * selected or not
	 * 
	 * @param ele
	 *            : WebElement
	 * @return
	 * @throws Exception
	 */
	public static boolean isImgSelected(WebElement ele) throws Exception {
		boolean match = false;
		if ((ele.getAttribute("class")).contains("selected")) {
			match = true;
		}
		return match;
	}

	/**
	 * MethodName:generateTimeStamp Description: This method generates timestamp
	 * 
	 * @return newDate
	 */
	public static String generateTimeStamp() {

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat stringDate = new SimpleDateFormat("ddMMyyhhmmss");

		String newDate = stringDate.format(date);

		return newDate;

	}

	

	/**
	 * MethodName:verifyDropdownValues
	 * 
	 * Description: This method verifies the dropdown options
	 * 
	 * @param Webelement
	 *            ele
	 * @param dropDownValuesArray
	 * @throws Exception
	 */
	public static boolean verifyDropdownValues(WebElement ele,
			String[] dropDownValuesArray) throws Exception {

		boolean match = false;

		try {
			Select dropDown = new Select(ele);

			List<WebElement> options = dropDown.getOptions();

			if (options.size() == dropDownValuesArray.length) {

				for (WebElement we : options) {

					for (int i = 0; i < dropDownValuesArray.length; i++) {

						String act = we.getText().replace("\n", "").trim();

						if (act.equalsIgnoreCase(dropDownValuesArray[i])) {

							match = true;
							Reporter.log("Dropdown options: " + we.getText());
							log.info("Dropdown options: " + we.getText());
							System.out.println("Dropdown options: "
									+ we.getText());
						}
					}

				}
			} else {
				log.error("Dropdown values size is not matching");
				Reporter.log("<p>Dropdown values size is not matching");
			}
		} catch (NoSuchElementException e) {
			log.error("Element to type data is not present " + e);
			Reporter.log("<p>Element to type data is not present");

		}
		return match;

	}

	/**
	 * MethodName:verifySelectedDropdownValue
	 * 
	 * Description: This method verifies the Selected dropdown value
	 * 
	 * @param Webelement
	 *            ele
	 * @param shippingmethodarray
	 * @throws Exception
	 */
	public static boolean verifySelectedDropdownValue(WebElement dropDown,
			String dropDownValue) throws Exception {

		boolean match = false;

		// Dropdown element initialization
		Select dropDownEle = new Select(dropDown);

		// Get Selected dropdown value
		String defaultoption = dropDownEle.getFirstSelectedOption().getText();

		defaultoption = defaultoption.replace("\n", "").trim();

		log.info("Default DropDown option: " + defaultoption);
		log.info("DropDown Value: " + dropDownValue);

		// Verify selected value
		if (defaultoption.equalsIgnoreCase(dropDownValue)) {
			match = true;
		}

		return match;
	}

	/**
	 * MethodName:verifyTitleDropdownValue
	 * 
	 * Description: This method verifies the Selected dropdown value
	 * 
	 * @param Webelement
	 *            ele
	 * @param shippingmethodarray
	 * @throws Exception
	 */
	public static boolean verifyTitleDropdownValue(String driverName,
			WebElement dropDown, String dropDownValue) throws Exception {

		boolean match = false;

		// Dropdown element initialization
		Select dropDownEle = new Select(dropDown);

		// Get Selected dropdown value
		String defaultoption = "";
		if (driverName.equalsIgnoreCase("CHROME")
				|| driverName.equalsIgnoreCase("ANDROID")) {
			defaultoption = dropDownEle.getFirstSelectedOption()
					.getAttribute("innerText").toString();
		} else {
			defaultoption = dropDownEle.getFirstSelectedOption().getText();
		}

		defaultoption = defaultoption.replace(" ", "").replace("\n", "");
		defaultoption = defaultoption.trim();

		// Verify selected value
		if (defaultoption.equalsIgnoreCase(dropDownValue)) {
			match = true;
		}

		return match;
	}

	/**
	 * MethodName:compareNumericValues
	 * 
	 * Description: This method compares the 2 values
	 * 
	 * @param int value1
	 * @param int value2
	 */
	public static boolean compareNumericValues(float value1, float value2)
			throws Exception {

		boolean match;

		if (value1 > value2) {

			match = true;
		} else {
			match = false;
		}

		return match;

	}

	

	/**
	 * MethodName:verifyDropdownAttributeValues
	 * 
	 * Description: This method verifies the dropdown attribute values
	 * 
	 * @param Webelement
	 *            ele
	 * @param dropDownValuesArray
	 * @throws Exception
	 */
	public static boolean verifyDropdownAttributeValues(WebElement ele,
			String[] dropDownValuesArray, String type, boolean lengthCheck)
			throws Exception {

		boolean match = false;

		try {
			Select dropDown = new Select(ele);

			List<WebElement> options = dropDown.getOptions();

			if (!lengthCheck) {
				int i = 0;
				for (WebElement we : options) {
					if (we.getText().trim()
							.equalsIgnoreCase(dropDownValuesArray[i])) {
						match = true;
					}
				}

			}

			else {
				if (options.size() == dropDownValuesArray.length) {

					int i = 0;

					for (WebElement we : options) {

						// for (int i = 0; i < dropDownValuesArray.length; i++)
						// {

						if (type.equalsIgnoreCase("value")) {
							if (we.getAttribute("value").equals(
									dropDownValuesArray[i])) {
								match = true;
								Reporter.log("Dropdown options: "
										+ we.getAttribute("value"));
								log.info("Dropdown options: "
										+ we.getAttribute("value"));
							}
						} else if (type.equalsIgnoreCase("text")) {

							if (we.getText().trim()
									.equals(dropDownValuesArray[i])) {
								match = true;
								Reporter.log("Dropdown options: "
										+ we.getText());

								log.info("Dropdown options: " + we.getText());
							}

						}
						i++;

						// }
					}
				} else {
					log.error("Dropdown values size is not matching");
					Reporter.log("<p>Dropdown values size is not matching");
				}
			}

		} catch (NoSuchElementException e) {
			log.error("Element to type data is not present " + e);
			Reporter.log("<p>Element to type data is not present");

		}
		return match;

	}
	
	
	/**
	 * MethodName:calculateTaxByZipCodeForCA
	 * 
	 * Description: This method calculates Tax By Zip Code For CA
	 * 
	 * @throws Exception
	 */
	public static void calculateCanadianTax(List<String> canadianStateList,
			List<String> priceList) throws Exception {

		taxAmtGST = new BigDecimal(0);
		taxAmtPST = new BigDecimal(0);
		taxAmtQST = new BigDecimal(0);
		taxAmtHST = new BigDecimal(0);

		// Calculate Tax for states
		for (int i = 0; i < canadianStateList.size(); i++) {

			BigDecimal pricevalue = parseCanadianPriceStringToBigDecimal(priceList
					.get(i));

			if (canadianStateList.get(i).equalsIgnoreCase("Alberta")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Northwest Territories")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Territoires du Nord-Ouest")
					|| canadianStateList.get(i).equalsIgnoreCase("Nunavut")
					|| canadianStateList.get(i).equalsIgnoreCase("Yukon")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"British Columbia")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Colombie-Britannique")
					|| canadianStateList.get(i).equalsIgnoreCase("Manitoba")
					|| canadianStateList.get(i)
							.equalsIgnoreCase("Saskatchewan")
					|| canadianStateList.get(i).equalsIgnoreCase("Quebec")
					|| canadianStateList.get(i).equalsIgnoreCase("Québec")) {

				taxAmtGST = taxAmtGST.add(pricevalue.multiply(BigDecimal
						.valueOf(0.05)));

			}
			if (canadianStateList.get(i).equalsIgnoreCase("British Columbia")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Colombie-Britannique")) {

				taxAmtPST = taxAmtPST.add(pricevalue.multiply(BigDecimal
						.valueOf(0.07)));

			}
			if (canadianStateList.get(i).equalsIgnoreCase("Manitoba")) {

				taxAmtPST = taxAmtPST.add(pricevalue.multiply(BigDecimal
						.valueOf(0.08)));
			}
			if (canadianStateList.get(i).equalsIgnoreCase("Saskatchewan")) {

				taxAmtPST = taxAmtPST.add(pricevalue.multiply(BigDecimal
						.valueOf(0.05)));
			}
			if (canadianStateList.get(i).equalsIgnoreCase("Quebec")
					|| canadianStateList.get(i).equalsIgnoreCase("Québec")) {

				taxAmtQST = taxAmtQST.add(pricevalue.multiply(BigDecimal
						.valueOf(0.09975)));
			}
			if (canadianStateList.get(i).equalsIgnoreCase("New Brunswick")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Nouveau-Brunswick")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Newfoundland and Labrador")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Terre-Neuve-et-Labrador")
					|| canadianStateList.get(i).equalsIgnoreCase("Ontario")) {

				taxAmtHST = taxAmtHST.add(pricevalue.multiply(BigDecimal
						.valueOf(0.13)));
			}

			if (canadianStateList.get(i).equalsIgnoreCase("Nova Scotia")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Nouvelle-Écosse")) {

				taxAmtHST = taxAmtHST.add(pricevalue.multiply(BigDecimal
						.valueOf(0.15)));
			}
			if (canadianStateList.get(i).equalsIgnoreCase(
					"Prince Edward Island")
					|| canadianStateList.get(i).equalsIgnoreCase(
							"Île-du-Prince-Édouard")) {

				taxAmtHST = taxAmtHST.add(pricevalue.multiply(BigDecimal
						.valueOf(0.14)));

			}
		}

		taxAmtGST = priceValueRoundOffToTwoDigits(taxAmtGST);
		taxAmtPST = priceValueRoundOffToTwoDigits(taxAmtPST);
		taxAmtHST = priceValueRoundOffToTwoDigits(taxAmtHST);
		taxAmtQST = priceValueRoundOffToTwoDigits(taxAmtQST);

		log.info("GST:" + taxAmtGST);
		log.info("PST:" + taxAmtPST);
		log.info("HST:" + taxAmtHST);
		log.info("QST:" + taxAmtQST);

	}

	/**
	 * MethodName:verifyTextboxCursorFocus
	 * 
	 * Description: This method verifies Textbox Cursor Focus
	 * 
	 * @param: driver
	 * 
	 * @return boolean value
	 * 
	 * @throws Exception
	 */
	public static boolean verifyTextboxCursorFocus(WebDriver driver)
			throws Exception {

		boolean match = false;
		try {
			WebElement currentElement = driver.switchTo().activeElement();
			// Check that current element is Search field
			if ("text".equals(currentElement.getAttribute("type"))) {
				match = true;

				log.info("Cursor is focused on textbox\n");
				Reporter.log("<p> Cursor is focused on textbox");
			} else {
				log.error("Cursor is not focused on textbox\n");
				Reporter.log("<p> Cursor is not focused on textbox");
			}

		} catch (NoSuchElementException e) {
			log.error("exception" + e);

		}

		return match;

	}

	/**
	 * Verifies the element is editable
	 * 
	 * @param ele
	 * @return
	 * @throws Exception
	 */
	public static boolean isElementEditable(WebElement ele) throws Exception {

		boolean match = false;
		try {
			log.info("Property Editable : " + ele.getAttribute("readOnly"));

			if (!ele.getAttribute("readOnly").contains("true")) {

				match = true;
			} else {
				match = false;
			}

		} catch (NullPointerException e) {
			return match;
		}

		return match;
	}

	/**
	 * This function round offs price value to decimal point two digits
	 * 
	 * @param amt
	 * @return
	 * @throws Exception
	 */
	public static BigDecimal priceValueRoundOffToTwoDigits(BigDecimal amt)
			throws Exception {

		BigDecimal doundOffAmt = null;
		try {
			// Round off price value to decimal point two digits
			doundOffAmt = amt.setScale(2, RoundingMode.HALF_UP);

		} catch (Exception e) {
			log.error("Number format exception" + e);
		}

		return doundOffAmt;
	}

	/**
	 * This function Replaces "," , " ", ".", "\n" with null for canadian price
	 * 
	 * @param amt
	 * @return
	 * @throws Exception
	 */
	public static String replaceSymbolsInCandainPrice(String amt)
			throws Exception {
		String amtvalue = null;

		try {
			// Replace "," , " ", ".", "\n" with null
			amtvalue = amt.substring(1).replace(",", "").replace(" ", "")
					.replace(".", "").replace("\n", "").trim();
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return amtvalue;
	}

	/**
	 * This function parse Canadian Price String To Double
	 * 
	 * @param amt
	 * @return
	 * @throws Exception
	 */
	public static BigDecimal parseCanadianPriceStringToBigDecimal(String amt)
			throws Exception {
		BigDecimal amtvalue = null;

		try {
			// Parse Canadian Price String To Double
			amtvalue = BigDecimal.valueOf(Double.parseDouble(amt.substring(0,
					amt.length() - 2)
					+ "."
					+ amt.substring(amt.length() - 2, amt.length())));
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return amtvalue;
	}

	/**
	 * This element verifies element is displayed or not
	 * 
	 * @param ele
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static boolean isElementVisible(By ele, WebDriver driver)
			throws Exception {
		try {
			driver.findElement(ele).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * This Function Switches the WebDriver control to the provided iFrame.
	 * 
	 * @param frameName
	 *            : Name of the IFrame to which WebDriver need to be switched.
	 * @param driver
	 *            : WebDriver instance whose control should be shifted to
	 *            iFrame.
	 */

	public static void switchToFrame(String frameName, WebDriver driver) {

		try {
			driver.switchTo().frame(frameName);
		}

		catch (Exception e) {

			log.error("Exception while SwitchingFrame " + frameName + " : " + e);

		}
	}

	/**
	 * This Function Switches the WebDriver Control to main Window from an
	 * iFrame.
	 * 
	 * @param driver
	 *            : WebDriver instance.
	 */

	public static void switchToMainWindowFromIFrame(WebDriver driver) {

		try {
			driver.switchTo().defaultContent();
		}

		catch (Exception e) {

			log.error("Exception while Switching to Main Window : " + e);
		}

	}

	
	/**
	 * Verifies Currency with the locale
	 * 
	 * @param priceValue
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyCurrencyAgainstLocale(String priceValue,
			String locale) throws Exception {
		char[] price = priceValue.toCharArray();
		String currency = "";
		boolean match = false;
		for (int i = 0; i < price.length; i++) {
			if (price[i] != '.' && price[i] != ',' && price[i] != ' ') {
				try {
					Integer.parseInt(Character.toString(price[i]));
				} catch (NumberFormatException nfe) {
					currency = currency + price[i];
				}
			}
		}
		switch (locale) {
		case "UK":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;

		case "US":
		case "CA_ENG":
		case "CA_FR":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;

		case "JP":
		case "CN":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;

		case "BR":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;

		case "AU":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;

		case "FR":
		case "DE":
		case "ES":
		case "IT":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;

		case "TW":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;
		case "HK_TC":
		case "HK_ENG":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;
		case "KR":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;
		case "RU":
			Assert.assertEquals(TextProp.get("currency"), currency);
			match = true;
			break;
		}
		return match;
	}

	/**
	 * 
	 * This function generates String with max limit
	 * 
	 * @param locale
	 * @param maxLimit
	 * @return
	 * @throws Exception
	 */
	public static String generateStringWithMaxLimit(String locale, int maxLimit)
			throws Exception {

		String generatedString = "";

		// Generate String with mentioned max limit
		if (locale.equalsIgnoreCase("JP") || locale.equalsIgnoreCase("CN")
				|| locale.equalsIgnoreCase("TW")) {
			for (int i = 0; i < maxLimit / 2; i++) {
				generatedString = generatedString + "ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½";
			}

		} else {
			for (int i = 0; i < maxLimit; i++) {
				generatedString = generatedString + "a";
			}
		}

		return generatedString;
	}

	/**
	 * Method: This method will check whether the label is high lighted for
	 * error alerts (for the form filling)
	 * 
	 * 
	 * @param prop
	 * @param ele
	 * @return
	 * @throws Exception
	 */
	public static boolean isLableHighLightedOnErrorAlert(String prop,
			WebElement ele) throws Exception {
		boolean flag = false;
		try {
			log.info("Txt color : " + TextProp.getProperty("errorColor"));
			log.info("Lable color : " + ele.getCssValue(prop));
			if (ele.getCssValue(prop)
					.replace(" ", "")
					.equalsIgnoreCase(
							TextProp.getProperty("errorColor").replace(" ", ""))) {

				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return flag;
	}

	/**
	 * Method: This method will check whether the label is high lighted for
	 * error alerts (for the form filling) - Registration page
	 * 
	 * 
	 * @param prop
	 * @param ele
	 * @param breakPoint
	 * @return
	 * @throws Exception
	 */
	public static boolean isLableHighLightedOnErrorAlertRegPage(String prop,
			WebElement ele, String breakPoint) throws Exception {
		boolean flag = false;
		String expectedColor = null;
		//if (breakPoint.equals("L") || breakPoint.equals("M")) {

			expectedColor = TextProp.getProperty("errorColor");

		//} else if (breakPoint.equals("AS")) {

		//	expectedColor = TextProp.getProperty("errorColorAS");

		//}
		try {
			log.info("Txt color : " + expectedColor);
			log.info("Lable color : " + ele.getCssValue(prop));
			if (ele.getCssValue(prop).replace(" ", "")
					.equalsIgnoreCase(expectedColor.replace(" ", ""))) {

				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return flag;

	}

	/**
	 * This function triggers AJAX event
	 * 
	 * @param driver
	 * @param ele
	 * @throws Exception
	 */
	public static void triggerAJAXEvent(WebDriver driver, WebElement ele)
			throws Exception {

		try {
			// Triggering action
			JavascriptLibrary javascript = new JavascriptLibrary();

			javascript.callEmbeddedSelenium(driver, "triggerEvent", ele,
					"change");

			Thread.sleep(2000);

		} catch (Exception e) {
			log.error("exception" + e);
		}

	}

	/**
	 * Verifies the Tab is selected or not
	 * 
	 * @param ele
	 * @param eleName
	 * @return Boolean value
	 * @throws Exception
	 */
	public static boolean isTabSelected(WebElement ele, String eleName)
			throws Exception {

		boolean match = false;
		try {

			if (ele.getAttribute("class").contains("active")) {

				match = true;
				log.info(eleName + " is selected");
				Reporter.log(eleName + " is selected");
			} else {
				log.error(eleName + " is not selected");
				Reporter.log(eleName + " is not selected");
			}

		} catch (Exception e) {
			log.error("exception" + e);
		}

		return match;
	}

	/**
	 * Method Name:isAsteriskPresentWithLabel
	 * 
	 * Description: This method will return boolean Value True if the Label is
	 * containing "*" in it. else it will return a false.
	 * 
	 * @param driver
	 * @param by
	 * @param LabelName
	 * @return
	 * @throws Exception
	 */
	public static boolean isAsteriskPresentWithLabel(WebDriver driver, By by,
			String LabelName) throws Exception {

		boolean flag = false;
		flag = driver.findElement(by).getText().contains("*");
		if (flag == true) {
			log.info(LabelName + "contains Arstric sign at the end");
			Reporter.log("<p>" + LabelName + "contains Arstric sign at the end");
		} else {

			log.error(LabelName + " does not contain Arstric sign at the end");
			Reporter.log("<p>" + LabelName
					+ " does not contain Arstric sign at the end");
		}
		return flag;
	}

	/**
	 * 
	 * @param driver
	 * @param rootDir
	 * @param process
	 * @throws Exception
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	public static WebDriver initializeDriver(WebDriver driver, String rootDir, Process process)
			throws Exception, IOException, InterruptedException,
			MalformedURLException {
					// Kill the Appium/nodejs server process -if exists.

			if (CustomFun.isProcessRunging("node.exe")) {
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			}
			Thread.sleep(5000);
			// launching the appium server including the log file path parameter
			Runtime.getRuntime().exec(
					"cmd /c appium -g \"" + rootDir + "/log/appium.log" + "\"");
			Thread.sleep(5000);
			DesiredCapabilities capabilitiesAndroid = new DesiredCapabilities();
			
			Thread.sleep(1000);
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),
					capabilitiesAndroid);

			Thread.sleep(1000);
			driver.manage().deleteAllCookies();
			log.info("Appium/nodejs server is initated..!!");
			// Initializing Android driver
			// driver = new AndroidDriver();
			// log.info("AndroidDriver Started");
		
		return driver;
	}
	
	
	
	/**
	 * This function returns numerics from locale based currency
	 * 
	 * @param amt
	 * @return
	 * @throws Exception
	 */
	public static String getNumericsFromLocaleBasedCurrency(String locale, String value)
			throws Exception {
		String amtvalue = null;
		
        
		if (locale.startsWith("TW") || locale.startsWith("HK_TC") || locale.startsWith("HK_ENG") || locale.startsWith("AU"))
		{
		try {
			// Replace "," , " ", ".", "\n" and other symbols with null
			amtvalue = value.substring(3).replace(",", "").replace(" ", "")
					.replace(".", "").replace("\n", "").trim();
		} catch (Exception e) {
			log.error("exception" + e);
		}
		}
		else if(locale.startsWith("ES") || locale.startsWith("DE") || locale.startsWith("FR"))
		{
			try {
				// Replace "," , " ", ".", "\n" and other symbols with null
				amtvalue = value.substring(0, value.length()-1).replace(",", "").replace(" ", "")
						.replace(".", "").replace("\n", "").trim();
			} catch (Exception e) {
				log.error("exception" + e);
			}
		}
		else if(locale.startsWith("BR"))
		{
			try {
				// Replace "," , " ", ".", "\n" and other symbols with null
				amtvalue = value.substring(2).replace(",", "").replace(" ", "")
						.replace(".", "").replace("\n", "").trim();
			} catch (Exception e) {
				log.error("exception" + e);
			}
		}
		else if(locale.startsWith("RU"))
		{
			try {
				// Replace "," , " ", ".", "\n" and other symbols with null
				amtvalue = value.substring(0, value.length()-3).replace(",", "").replace(" ", "")
						.replace(".", "").replace("\n", "").trim();
			} catch (Exception e) {
				log.error("exception" + e);
				
			}
		}
		
		else{
			try {
				// Replace "," , " ", ".", "\n" and other symbols with null
				amtvalue = value.substring(1).replace(",", "").replace(" ", "")
						.replace(".", "").replace("\n", "").trim();
			} catch (Exception e) {
				log.error("exception" + e);
			}	
		}
       return amtvalue;
	}
	
	
	
	
	/**
	 * This function returns Numeric value of the month displayed
	 * 
	 * @param amt
	 * @return
	 * @throws Exception
	 */
	public static int getMonthNumericValueFromThumbnails(String locale, String value)
			{
		String dateValue = null;
			
		if (locale.startsWith("RU")|| locale.startsWith("UK")|| locale.startsWith("IT")|| locale.startsWith("ES")|| locale.startsWith("FR")|| locale.startsWith("BR")|| locale.equals("CA_FR")|| locale.equals("HK_ENG") || locale.startsWith("AU")|| locale.startsWith("INT_ENG"))
		{
		try {
			// Replace "," , " ", ".", "\n" and other symbols with null
			dateValue = value.substring(3,5).replace(",", "").replace(" ", "")
					.replace(".", "").replace("\n", "").trim();
		} catch (Exception e) {
			log.error("exception" + e);
		}
		}
		else if (locale.equals("CA_ENG")||locale.startsWith("CN")||locale.equals("HK_TC")||locale.startsWith("US")|| locale.startsWith("JP")|| locale.startsWith("KR")|| locale.startsWith("TW"))
		{
		try {
			// Replace "," , " ", ".", "\n" and other symbols with null
			dateValue = value.substring(0,2).replace(",", "").replace(" ", "")
					.replace(".", "").replace("\n", "").trim();
		} catch (Exception e) {
			log.error("exception" + e);
		}
		
		}
		else if(locale.startsWith("DE"))
		{
			try {
				// Replace "," , " ", ".", "\n" and other symbols with null
				dateValue = value.substring(4,6).replace(",", "").replace(" ", "")
						.replace(".", "").replace("\n", "").trim();
			} catch (Exception e) {
				log.error("exception" + e);
			}
		}
		int date=Integer.parseInt(dateValue);
		
		return date;
			}
	
	
	/**
	 * This checks the mouse pointer for roll over
	 * 
	 * @param ele
	 * @param eleName
	 * @return
	 */
	public static boolean rollOverElement(WebElement ele, String eleName) {

		String eleCursor = ele.getCssValue("cursor");

		boolean match = false;

		// Check mouse pointer is changed on roll over
		if (eleCursor.equals("pointer")) {
			
			log.info("On roll over " + eleName + " mouse pointer is changed");
			Reporter.log("<p>On roll over " + eleName + " mouse pointer is changed");
			match = true;
		}
		
		else if (eleCursor.equals("pointer")) {
			
			log.info("On roll over " + eleName + " mouse pointer is not changed");
			Reporter.log("<p>On roll over " + eleName + " mouse pointer is not changed");
			match = false;
		}


		return match;
	}	
	
	
	

	
	/**
	 * Method: This method will check whether the tab is high lighted
	 * After clicking on it
	 * 
	 * 
	 * @param prop
	 * @param ele
	 * @return
	 * @throws Exception
	 */
	public static boolean isTabLableHighLighted(String prop,
			WebElement ele) throws Exception {
		boolean flag = false;
		try {
			log.info("Txt color : " + TextProp.getProperty("tabLabelColor"));
			log.info("Lable color : " + ele.getCssValue(prop));
			if (ele.getCssValue(prop)
					.replace(" ", "")
					.equalsIgnoreCase(
							TextProp.getProperty("tabLabelColor").replace(" ", ""))) {

				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return flag;
	}
	
	
	
	/**
	 * This function gets Current Zone Time
	 * 
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public static int getCurrentZoneTime(String locale) throws Exception {
		int currentZoneTime = 0;
		
		try {
		
			TimeZone timeZone = null;
			
			//Based on locale get zone
			if(locale.equalsIgnoreCase("UK")){
			timeZone = TimeZone.getTimeZone("Europe/London");
			}
			Calendar calendar = new GregorianCalendar();
			
			//Based on locale set zone
			calendar.setTimeZone(timeZone);
			
			//Get zone current hour
			currentZoneTime=calendar.get(Calendar.HOUR_OF_DAY);
			
			log.info("Current Zone Time  = " + calendar.get(Calendar.HOUR_OF_DAY));
			
			
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return currentZoneTime;
	}
	
	/**
	 * 
	 * This function Calculates Estimated Prod Collection Date
	 * 
	 * @param locale
	 * @param noOfdays: to be added to current date
	 * @return
	 * @throws Exception
	 */
	public static String calculateEstimatedProdCollectionDate(String locale,int noOfdays) throws Exception {
		String estimatedDate="";
		
		try {
		
			TimeZone timeZone = null;
			
			//Based on locale get zone
			if(locale.equalsIgnoreCase("UK")){
			timeZone = TimeZone.getTimeZone("Europe/London");
			}
			Calendar calendar = new GregorianCalendar();
			
			//Based on locale set zone
			calendar.setTimeZone(timeZone);
			
			
			//If Friday, Calculate Estimated Prod Collection Date for Mon
			if(calendar.get(Calendar.DAY_OF_WEEK)==6){
				noOfdays=	noOfdays+2;
			}
			
			//Add days to calculate estimated delivery date
			calendar.add(Calendar.DATE, noOfdays);
			
			//Format date-"dd-MM-yyyy"
			Date date = calendar.getTime();             
			SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy"); 
			
			estimatedDate=format1.format(date);
			
			log.info("estimatedDate  -"+estimatedDate);
			
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return estimatedDate;
	}	
	
	
	
	
	/**
	 * This function verifies whether pushes are displayed one below another/one besides another
	 * allignment = "onebelowanother" for AS breakpoint/"onebesidesanother" for L and M breakpoint
	 * 
	 */
	public static boolean verifyPushesAllignment(WebDriver driver, List<WebElement> eleList, String allignment) {

		int xAxisPush1Value=0;
		int yAxisPush1Value=0;
		int xAxisPush2Value=0;
		int yAxisPush2Value=0;
		boolean flag=false;
		
		for(int i=0; i<eleList.size(); i++)
		{
			xAxisPush1Value=eleList.get(i).getLocation().x;
			yAxisPush1Value=eleList.get(i).getLocation().y;
		
		for(int j=1; j<eleList.size(); j++)
		{
			xAxisPush2Value=eleList.get(j).getLocation().x;
			yAxisPush2Value=eleList.get(j).getLocation().y;
		}

		if(allignment.equalsIgnoreCase("onebelowanother"))
		{
			if(xAxisPush1Value==xAxisPush2Value)
			{
				flag=true;
			}	
		}
		else if(allignment.equalsIgnoreCase("onebesidesanother"))
		{
			if(yAxisPush1Value==yAxisPush2Value)
			{
				flag=true;
			}	
		}
		}
		return flag;
		
		
	}
	
	
	
	
	
	
	
	

}
	
	

