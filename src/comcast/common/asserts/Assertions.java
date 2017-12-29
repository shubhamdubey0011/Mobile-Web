package comcast.common.asserts;

 
import  comcast.custom.CustomFun;
import comcast.uiFunctions.GUIFunctions;
import comcast.resources.*;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class Assertions {

	// For logging
	public static Logger log = Logger.getLogger(Assertions.class);

	/**
	 * Method name: verifyTitleInAddressSection Description: This function
	 * verifies title InAddressSection
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param locale
	 * @param title
	 *            : Selected Title to verify
	 * @throws Exception
	 */
	public static void verifyTitleInAddressSection(WebDriver driver,
			String driverName, String locale, String title) throws Exception {
		
	
					Boolean match = CustomFun.verifyTitleDropdownValue(driverName,
							driver.findElement(By.id(ObjRepoProp
									.getProperty("titleDropDown_ID"))), title);

					Assert.assertTrue(match,"Title is not selected");

	

	}

	/*
	 * Verifying the Credit Card Detaisl In My Profile Page It verifys Card
	 * Type, Card Image, Card Number, Experation Date, Expiry Month & Expiry
	 * Year
	 */

	public static void VerifyCreditCardDetails(WebDriver driver, String cardType) {

		log.info("Excel Reading Card Type = '" + cardType + "'");
		Reporter.log("Excel Reading Card Type = '" + cardType + "'");

		// Verify CardType
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardType_XPATH")),
				driver), "Credit Card Type is not displayed");

		// Verify Card Type image displayed
		switch (cardType) {
		case "VISA":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("visaMyProfileCardImg_XPATH")), driver));
			break;
		case "MASTER CARD":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("masterMyProfileCardImg_XPATH")), driver));
			break;
		case "AMERICAN EXPRESS":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("americanExpressMyProfileCardImg_XPATH")),
					driver));
			break;
		case "JCB":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("jcbMyProfileCardImg_XPATH")), driver));
			break;
		case "DISCOVER":

			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("discoverMyProfileCardImg_XPATH")), driver));
			break;
		case "DINERS CLUB":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("dinersClubMyProfileCardImg_XPATH")), driver));
			break;
		default:
			Assert.fail("No Credit Card Image is displayed");
			break;
		}

		

	


		// Get Last 4 digits from the Card Number
		// cardLength = (cardLength - 4);
		

		
		log.info("Card Number Displayed in Application as = "
				+ driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("creditCardNumber_XPATH")))
						.getText().replace(" ", ""));

		

		// Verify Credit card Exp Label
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpLable_XPATH")),
				driver));

		// Verify Credit card Exp Month
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpMonth_XPATH")),
				driver));

		// Verify Credit card Exp Year
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpYear_XPATH")),
				driver));

		// Verify Credit card Delete Button is Displayed
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardDeleteBtn_XPATH")),
				driver));
	}
	
	/*
	 * Verifying the Credit Card Details In Review Page It verifys Card
	 * Type, Card Image, Card Number, Experation Date, Expiry Month & Expiry
	 * Year
	 */

	public static void VerifyCreditCardDetailsReviewPage(WebDriver driver, String cardType) {

		log.info("Excel Reading Card Type = '" + cardType + "'");
		Reporter.log("Excel Reading Card Type = '" + cardType + "'");

		// Verify CardType
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardType_XPATH")),
				driver), "Credit Card Type is not displayed");

		// Verify Card Type image displayed
		switch (cardType) {
		case "VISA":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("visaMyProfileCardImg_XPATH")), driver));
			break;
		case "MASTER CARD":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("masterMyProfileCardImg_XPATH")), driver));
			break;
		case "AMERICAN EXPRESS":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("americanExpressMyProfileCardImg_XPATH")),
					driver));
			break;
		case "JCB":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("jcbMyProfileCardImg_XPATH")), driver));
			break;
		case "DISCOVER":

			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("discoverMyProfileCardImg_XPATH")), driver));
			break;
		case "DINERS CLUB":
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("dinersClubMyProfileCardImg_XPATH")), driver));
			break;
		default:
			Assert.fail("No Credit Card Image is displayed");
			break;
		}

	

		

		
		log.info("Card Number Displayed in Application as = "
				+ driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("creditCardNumber_XPATH")))
						.getText().replace(" ", ""));

		
		// Verify Credit card Exp Label
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpLable_XPATH")),
				driver));

		// Verify Credit card Exp Month
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpMonth_XPATH")),
				driver));

		// Verify Credit card Exp Year
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpYear_XPATH")),
				driver));

	}

	/**
	 * Verifying product details in the shopping bag form
	 * 
	 * @param count
	 * @param productType
	 *            should be "IHS" or "MOM" or "NORMAL"
	 * @param locale
	 * @param driver
	 * @throws Exception
	 */

	public static void verifyShoppingBagProductDetails(int count,
			String locale, WebDriver driver) throws Exception {

		log.info("ProductCount=" + count);

		for (int i = 1; i <= count; i++) {

			// verify the product image
			Assert.assertTrue(
					GUIFunctions.isElementPresent(
							By.xpath(ObjRepoProp
									.getProperty("shoppingBagTableForm_XPATH")
									+ "["
									+ i
									+ ObjRepoProp
											.getProperty("productImage_XPATH")),
							driver),
					"product image verification was unsuccessful for item " + i);

			// verify the product description
			Assert.assertTrue(
					GUIFunctions.isElementPresent(
							By.xpath(ObjRepoProp
									.getProperty("shoppingBagTableForm_XPATH")
									+ "["
									+ i
									+ ObjRepoProp
											.getProperty("productDesc_XPATH")),
							driver),
					"product description verification was unsuccessful for item "
							+ i);

			// verify the product Item reference
			Assert.assertTrue(
					GUIFunctions.isElementPresent(
							By.xpath(ObjRepoProp
									.getProperty("shoppingBagTableForm_XPATH")
									+ "["
									+ i
									+ ObjRepoProp
											.getProperty("shoppingBagItemReference_XPATH")),
							driver),
					"product reference verification was unsuccessful for item "
							+ i);

			// verify the product Item Price
			Assert.assertTrue(
					GUIFunctions.isElementPresent(
							By.xpath(ObjRepoProp
									.getProperty("shoppingBagTableForm_XPATH")
									+ "["
									+ i
									+ ObjRepoProp
											.getProperty("shoppingBagItemPrice_XPATH")),
							driver),
					"product price verification was unsuccessful for item " + i);

			// verify the product Edit button
			Assert.assertTrue(
					GUIFunctions.isElementPresent(
							By.xpath(ObjRepoProp
									.getProperty("shoppingBagTableForm_XPATH")
									+ "["
									+ i
									+ ObjRepoProp
											.getProperty("shoppingBagItemEditBtn_XPATH")),
							driver),
					"product edit button verification was unsuccessful for item "
							+ i);

			// get the currency value
			String priceValue = driver
					.findElement(
							By.xpath(ObjRepoProp
									.getProperty("shoppingBagTableForm_XPATH")
									+ "["
									+ i
									+ ObjRepoProp
											.getProperty("shoppingBagItemPrice_XPATH")))
					.getText().replace(" ", "");

			log.info("Price" + priceValue);

			// Verify the currency value with respect to locale

			Assert.assertTrue(
					CustomFun.verifyCurrencyAgainstLocale(priceValue, locale),
					"Successfully verified the currency value for item " + i);

			log.info("Successfully verified the currency value is correct\n");
			Reporter.log("<p>Successfully verified the currency value is correct");

			WebElement ele = driver.findElement(By.xpath(ObjRepoProp
					.getProperty("shoppingBagTableForm_XPATH")
					+ "["
					+ i
					+ ObjRepoProp
							.getProperty("shoppingBagItemQtyDropdown_XPATH")));
			// Verify the quantity field is disabled

			Assert.assertFalse(CustomFun.isElementEditable(ele),
					"quantity field was not disabled for item " + i);

			log.info("Successfully verified qty field is disabled\n");
			Reporter.log("<p>Successfully verified qty field is disabled");

			// Verify the quantity field value selected

			Assert.assertEquals(
					Integer.parseInt(driver
							.findElement(
									By.xpath(ObjRepoProp
											.getProperty("shoppingBagTableForm_XPATH")
											+ "["
											+ i
											+ ObjRepoProp
													.getProperty("shoppingBagItemQtyDropdown_XPATH")))
							.getText()), 1,
					"product quantity field value verification was unsuccessful for item "
							+ i);

			log.info("Successfully verified qty field value is correct\n");
			Reporter.log("<p>Successfully verified qty field value is correct");

			boolean ihsProduct = GUIFunctions
					.isElementPresent(
							By.xpath(ObjRepoProp
									.getProperty("shoppingBagTableForm_XPATH")
									+ "["
									+ i
									+ "]"
									+ ObjRepoProp
											.getProperty("ihsProductPresence_Part2_XPATH")),
							driver);

			if (ihsProduct) {
				// Verify Product Properties viz., Initials,Color
				List<WebElement> ihsLst = driver
						.findElements(By.xpath(ObjRepoProp
								.getProperty("shoppingBagTableForm_XPATH")
								+ "["
								+ i
								+ "]"
								+ ObjRepoProp
										.getProperty("shippingPageIHSProdPropertyCount_XPATH")));

				if (ihsLst != null) {

					Assert.assertTrue(ihsLst.size() % 2 == 0,
							"Initials are not available");

					log.info("IHS Initials,Color properties of the Product are Available \n");
					Reporter.log("<p>IHS Initials,Color properties of the Product are Available");
				}

				// Verify Initial Color block Presence
				Assert.assertTrue(
						GUIFunctions.isElementPresent(
								By.xpath(ObjRepoProp
										.getProperty("shoppingBagTableForm_XPATH")
										+ "["
										+ i
										+ "]"
										+ ObjRepoProp
												.getProperty("shippingPageIHSProdColor_XPATH")),
								driver), "Initial color block is not available");
				log.info("IHS Initial Color Block Property Present \n");
				Reporter.log("<p>IHS Initial Color Block Property Present");

			}

			boolean momProduct = GUIFunctions
					.isElementPresent(
							By.xpath(ObjRepoProp
									.getProperty("shoppingBagTableForm_XPATH")
									+ "["
									+ i
									+ "]"
									+ ObjRepoProp
											.getProperty("momProductPresence_Part2_XPATH")),
							driver);

			if (momProduct) {
				// Verify Product Properties viz., Initials,Color
				List<WebElement> momLst = driver
						.findElements(By.xpath(ObjRepoProp
								.getProperty("shoppingBagTableForm_XPATH")
								+ "["
								+ i
								+ "]"
								+ ObjRepoProp
										.getProperty("shippingPageMOMProdPropertyCount_XPATH")));

				if (momLst != null) {

					Assert.assertTrue(momLst.size() % 2 == 0,
							"Verfication of Color, inside color properties was Unsuccessful");

					log.info("MOM Initials,Color properties of the MOM Product are Available \n");
					Reporter.log("<p>MOM Initials,Color properties of the MOM Product are Available");
				}

				// Verify Initials are available
				Assert.assertTrue(
						GUIFunctions.isElementPresent(
								By.xpath(ObjRepoProp
										.getProperty("shoppingBagTableForm_XPATH")
										+ "["
										+ i
										+ "]"
										+ ObjRepoProp
												.getProperty("shippingPageMOMProdInitial_XPATH")),
								driver),
						"Verfication of MOM Intials was Unsuccessful");
				log.info("MOM Initials are Present \n");
				Reporter.log("<p>MOM Initials are Present");

				// Verify Color and Inside Color blocks are available
				Assert.assertTrue(
						GUIFunctions.isElementPresent(
								By.xpath(ObjRepoProp
										.getProperty("shoppingBagTableForm_XPATH")
										+ "["
										+ i
										+ "]"
										+ ObjRepoProp
												.getProperty("shippingPageMONProdColorPropertyCount_XPATH")),
								driver),
						"Verification of Color and Inside Color blocks was Unsuccessful");
				log.info("MOM Color and Inside Color Block Property Present \n");
				Reporter.log("<p>MOM Color and Inside Color Block Property Present");
			}

			log.info("Successfully verified the product details for" + i
					+ " product\n");
			Reporter.log("<p>Successfully verified the product details for" + i
					+ " product");
		}
	}

	/**
	 * 
	 * Description: This method verifies shipping method selected
	 * 
	 * @return retunr SKU for specific locales
	 * 
	 */

	public static void verifyShippingMethodSelected(WebDriver driver,
			String value, int Product) throws Exception {

		int i = Product - 1;
		// Dropdown element initialization
		Select dropDownEle = new Select(driver.findElement(By.xpath(ObjRepoProp
				.getProperty("multipleShippingMethodDropDown_Part1_XPATH")
				+ i
				+ "')]")));

		String appValue = dropDownEle.getFirstSelectedOption().getText().trim();
		log.info("appAddressValue = '" + appValue + "'");
		log.info("Expected value = '" + value + "'");

		Assert.assertEquals(appValue, value,
				"Actual and Expected value are not matching");
	}

	/**
	 * 
	 * Description: This method verifies shipping Address selected
	 * 
	 * @return return SKU for specific locales
	 * 
	 */

	public static void verifyShippingAddressSelected(WebDriver driver,
			String value, int Product) throws Exception {

		int i = Product - 1;
		// Dropdown element initialization
		GUIFunctions
				.mouseOverElement(
						driver,
						driver.findElement(By.xpath(ObjRepoProp
								.getProperty("multipleShippingAddressDropDown_Part1_XPATH")
								+ i + "')]")));

		Select dropDownEle = new Select(driver.findElement(By.xpath(ObjRepoProp
				.getProperty("multipleShippingAddressDropDown_Part1_XPATH")
				+ i
				+ "')]")));

		String appAddressValue = dropDownEle.getFirstSelectedOption().getText()
				.trim();

		log.info("appAddressValue = " + appAddressValue + "'");
		log.info("Expected value = '" + value + "'");

		Assert.assertEquals(appAddressValue, value,
				"Actual and Expected value are not matching");
	}

	/**
	 * 
	 * Description: This method verifies shipping method selected from the drop
	 * down
	 * 
	 * @return
	 * 
	 * @return retunr SKU for specific locales
	 * 
	 */

	public static void verifyShippingMethodList(WebDriver driver,
			String locale, int Product, String Premium) throws Exception {

		int i = Product - 1;
		int shippingMethodCount = driver
				.findElements(
						By.xpath(ObjRepoProp
								.getProperty("multipleShippingMethodDropDown_Part1_XPATH")
								+ i + "')]/option")).size();
		log.info("shippingMethodCount = '" + shippingMethodCount + "'");

		if (locale.equals("FR") || locale.equals("DE") || locale.equals("ES")

		|| locale.equals("IT") || locale.equals("UK"))
			if (Premium == "Yes") {
				log.info("Premium = '" + Premium + "'");

				// Verify the 3 shipping method options is the dropdown for EU
				String[] shippingMethods = {
						TextProp.getProperty("shippingMethodCompStd"),
						TextProp.getProperty("shippingMethodExpress"),
						TextProp.getProperty("shippingMethodPremiumLabel") };

				if (shippingMethodCount > 2) {

					CustomFun
							.verifyDropdownValues(
									driver.findElement(By.xpath(ObjRepoProp
											.getProperty("multipleShippingMethodDropDown_Part1_XPATH")
											+ i + "')]")), shippingMethods);
					log.info("Complimentary Standard, Express & Premium shipping method are present for EU location\n");
					Reporter.log("<p>Complimentary Standard, Express & Premium shipping method are present for EU location");

				}

			} else {
				log.info("Premium = '" + Premium + "'");
				// Verify the 3 shipping method options is the dropdown for EU
				String[] shippingMethods = {
						TextProp.getProperty("shippingMethodCompStd"),
						TextProp.getProperty("shippingMethodExpress") };

				if (shippingMethodCount == 2) {
					CustomFun
							.verifyDropdownValues(
									driver.findElement(By.xpath(ObjRepoProp
											.getProperty("multipleShippingMethodDropDown_Part1_XPATH")
											+ i + "')]")), shippingMethods);
					log.info("Complimentary Standard, Express method are present for EU location\n");
					Reporter.log("<p>Complimentary Standard, Express method are present for EU location");

				}
			}
		if (locale.equalsIgnoreCase("US")) {

			// Verify the 3 shipping method options is the dropdown for USA
			String[] shippingMethods = {
					TextProp.getProperty("shippingMethodCompStd"),
					TextProp.getProperty("shippingMethodExpress"),
					TextProp.getProperty("shippingMethodOvernight") };

			CustomFun
					.verifyDropdownValues(
							driver.findElement(By.xpath(ObjRepoProp
									.getProperty("multipleShippingMethodDropDown_Part1_XPATH")
									+ i + "')]")), shippingMethods);

			log.info("Complimentary Standard, Express & Overnigh shipping method are present for US location\n");
			Reporter.log("<p>Complimentary Standard, Express & Overnigh shipping method are present for US location");

		}
		
		
		if (locale.equalsIgnoreCase("AU")) {

			// Verify the 3 shipping method options is the dropdown for AU
			String[] shippingMethods = {
					TextProp.getProperty("shippingMethodCompStd"),
					TextProp.getProperty("shippingMethodNextBusinessDay"),
					TextProp.getProperty("shippingMethodSameDay") };

			CustomFun
					.verifyDropdownValues(
							driver.findElement(By.xpath(ObjRepoProp
									.getProperty("multipleShippingMethodDropDown_Part1_XPATH")
									+ i + "')]")), shippingMethods);

			log.info("Complimentary Standard, Next Day & Same Day shipping method are present for US location\n");
			Reporter.log("<p>Complimentary Standard, Next Day & Same Day shipping method are present for US location");

		}

	}

	/**
	 * 
	 * Description: This method verifies shipping method selected
	 * 
	 * @return retunr SKU for specific locales
	 * 
	 */

	public static void verifyShippingMethodSelectedReviewPage(WebDriver driver,
			String ShippingMethod, int Product) throws Exception {
		int i = Product;

		log.info(ObjRepoProp.getProperty("multipleShippingMethod_Part1_XPATH")
				+ i
				+ ObjRepoProp.getProperty("multipleShippingMethod_Part2_XPATH"));
		String appValue = driver
				.findElement(
						By.xpath(ObjRepoProp
								.getProperty("multipleShippingMethod_Part1_XPATH")
								+ i
								+ ObjRepoProp
										.getProperty("multipleShippingMethod_Part2_XPATH")))
				.getText();
		log.info("Value displayed in application ='" + appValue + "'");
		log.info("Expected value = '" + ShippingMethod + "'");

		Assert.assertEquals(appValue, ShippingMethod,
				"Shipping method is not displayed correctly");

	}
	
	
	
	
	/**
	 * 
	 * Description: This method verifies shipping address selected
	 * 
	 * @return retunr SKU for specific locales
	 * 
	 */

	public static void verifyShippingAddressSelectedReviewPage(WebDriver driver,
			String ShippingAddress, int Product) throws Exception {
		int i = Product;

		log.info(ObjRepoProp.getProperty("reviewPageShippingAddress_Part1_XPATH")
				+ i
				+ ObjRepoProp.getProperty("shippingAddress_Part2_XPATH"));
		String appValue = driver
				.findElement(
						By.xpath(ObjRepoProp
								.getProperty("reviewPageShippingAddress_Part1_XPATH")
								+ i
								+ ObjRepoProp
										.getProperty("shippingAddress_Part2_XPATH")))
				.getText();
		log.info("Value displayed in application ='" + appValue + "'");
		log.info("Expected value = '" + ShippingAddress + "'");

		Assert.assertEquals(appValue.trim(), ShippingAddress.trim(),
				"Shipping address is not displayed correctly");

	}

	

	/**
	 * 
	 * Description: This method verifies whether ThreeD Error Message is
	 * displaying or not
	 * 
	 */
	public static void verifyThreeDErrorMsg(WebDriver driver) throws Exception {

		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("ThreeDErrorMsg")), driver),
				" ThreeD Error Message is not Present");
		log.info("3D Error MEssage is displayed\n");
		Reporter.log("<p>3D Error MEssage is displayed\n");
	}

	/**
	 * 
	 * Description: This Method Verifies the Credit Card Highlighted
	 * 
	 * @returns : nothing
	 * 
	 */

	public static void verifyCreditCardHighlighted(WebDriver driver,
			String cardSelected, String expectedCardType) throws Exception {

		log.info("Expected Value = '" + expectedCardType + "' Actual Value = '"
				+ cardSelected + "'");
		Reporter.log("Expected Value = '" + expectedCardType
				+ "' Actual Value = '" + cardSelected + "'");

		switch (expectedCardType) {
		case "visa":
			Assert.assertEquals(cardSelected, expectedCardType,
					"VISA Credit Card image is not highlighted");
			log.info("VISA Credit Card image is highlighted");
			Reporter.log("VISA Credit Card image is highlighted");

			break;
		case "masterCard":
			Assert.assertEquals(cardSelected, expectedCardType,
					"Master Credit Card image is not highlighted");
			log.info("Master Credit Card image is highlighted");
			Reporter.log("Master Credit Card image is highlighted");
			break;
		case "americanExpress":
			Assert.assertEquals(cardSelected, expectedCardType,
					"American Express Credit Card image is not highlighted");
			log.info("American Express Credit Card image is highlighted");
			Reporter.log("American Express Credit Card image is highlighted");
			break;
		case "jcb":
			Assert.assertEquals(cardSelected, expectedCardType,
					"JCB Credit Card image is not highlighted");
			log.info("JCB Credit Card image is highlighted");
			Reporter.log("JCB Credit Card image is highlighted");
			break;
		case "discover":
			Assert.assertEquals(cardSelected, expectedCardType,
					"DISCOVER Credit Card image is not highlighted");
			log.info("DISCOVER Credit Card image is highlighted");
			Reporter.log("DISCOVER Credit Card image is highlighted");
			break;
		case "dinersClub":
			Assert.assertEquals(cardSelected, expectedCardType,
					"DINERS CLUB Credit Card image is not highlighted");
			log.info("DINERS CLUB Credit Card image is highlighted");
			Reporter.log("DINERS CLUB Credit Card image is highlighted");
			break;
		default:
			log.error("No Credit Card image is highlighted");
			Reporter.log("No Credit Card image is highlighted");
			break;
		}

	}

	/**
	 * 
	 * @param driver
	 * @param locale
	 * @param breakPoint
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static void verifyWelcomeMessageNameDisplay(WebDriver driver,
			String locale, String breakPoint, String title, String firstName,
			String lastName) {

		if (locale.equalsIgnoreCase("TW") || (locale.equalsIgnoreCase("HK_TC"))) {

			Assert.assertTrue(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("welcomeMessageUserFullName_JP_CN_KR_TW_HKCN_XPATH")))
							.getText().replace(" ", "")
							.contains(firstName + lastName + title),
					"name displayed in welcome message is wrong");
			/*
			 * driver.findElement( By.xpath(ObjRepoProp
			 * .getProperty("welcomeMessageName_XPATH")))
			 * .getText().replace(" ", "").toUpperCase()
			 * .contains(lastName.toUpperCase() + firstName.toUpperCase());
			 */

		}

		else if (locale.equalsIgnoreCase("JP")) {

			Assert.assertTrue(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("welcomeMessageUserFullName_JP_CN_KR_TW_HKCN_XPATH")))
							.getText().replace(" ", "")
							.contains(lastName + firstName),
					"name displayed in welcome message is wrong");

		}

		else if (locale.equalsIgnoreCase("KR")) {

			Assert.assertTrue(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("welcomeMessageUserFullName_JP_CN_KR_TW_HKCN_XPATH")))
							.getText().replace(" ", "")
							.contains(lastName.toUpperCase() + firstName.toUpperCase()),
					"name displayed in welcome message is wrong");

		}

		else if (locale.equalsIgnoreCase("CN")) {

			Assert.assertTrue(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("welcomeMessageUserFullName_JP_CN_KR_TW_HKCN_XPATH")))
							.getText().replace(" ", "")
							.contains(lastName + firstName + title),
					"name displayed in welcome message is wrong");

		}

		else {
			
		Assert.assertTrue(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("welcomeMessageUserFullName_XPATH")))
							.getText().replace(" ", "")
							.equalsIgnoreCase(title + firstName + lastName),
					"name displayed in welcome message is wrong");

		}
	}

	/*
	 * Verifying the Credit Card Detaisl In My Profile Page It verifys Card
	 * Type, Card Image, Card Number, Experation Date, Expiry Month & Expiry
	 * Year
	 */

	public static void VerifyCreditCardDetailsReviewPage(WebDriver driver) {

		// Verify Credit card Type
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardType_XPATH")),
				driver), "Card Type is not displayed");

		// Verify Credit card Number
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardNumber_XPATH")),
				driver), "Card Number is not displayed");

		// Verify Credit card Exp Label
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpLable_XPATH")),
				driver), "Card Expiry label is not displayed");

		// Verify Credit card Exp Month
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpMonth_XPATH")),
				driver), "Card Expiry Month is not displayed");

		// Verify Credit card Exp Year
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("creditCardExpYear_XPATH")),
				driver), "Card Expiry Year is not displayed");
	}

	/**
	 * 
	 * Description: This method verifies the First Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	/**
	 * 
	 * Description: This method verifies the First Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyFirstNameErrMsg(WebDriver driver, String page)
			throws Exception {

		if (page.equals("MyLV")) {
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("myLvFirstNameErrorMsg_XPATH")))
							.getText(), "",
					"First Name Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("myLvFirstNameLabel_XPATH")))),
					"First Name label is not highlighted");

		} else {

			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("firstNameErrorMsg_XPATH")))
							.getText(), "",
					"First Name Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("firstNameLabel_XPATH")))),
					"First Name label is not highlighted");
		}

		log.info("First Name Error message is displayed");
		Reporter.log("First Name Error message is displayed");
	}

	/**
	 * 
	 * Description: This method verifies the Last Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	/**
	 * 
	 * Description: This method verifies the Last Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyLastNameErrMsg(WebDriver driver, String page)
			throws Exception {
		if (page.equals("MyLV")) {
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("myLvLastNameErrorMsg_XPATH")))
							.getText(), "",
					"Last Name Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("myLvLastNameLabel_XPATH")))),
					"Last Name label is not highlighted");

		} else {

			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("lastNameErrorMsg_XPATH")))
							.getText(), "",
					"Last Name Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("lastNameLabel_XPATH")))),
					"Last Name label is not highlighted");
		}

		log.info("Last Name Error message is displayed");
		Reporter.log("Last Name Error message is displayed");
	}

	/**
	 * 
	 * Description: This method verifies the Second First Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifySecondFirstNameErrMsg(WebDriver driver, String page)
			throws Exception {
		if (page.equals("MyLV")) {
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("myLvSecondFirstNameErrorMsg_XPATH")))
							.getText(), "",
					"Last Name Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("myLvSecondFirstNameLabel_XPATH")))),
					"Last Name label is not highlighted");

		} else {

			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("secondFirstNameErrorMsg_XPATH")))
							.getText(), "",
					"Second First Name Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("secondFirstNameLabel_XPATH")))),
					"Second First Name label is not highlighted");
		}

		log.info("Second First Name Error message is displayed");
		Reporter.log("Second First Name Error message is displayed");
	}

	/**
	 * 
	 * Description: This method verifies the Second Last Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifySecondLastNameErrMsg(WebDriver driver, String page)
			throws Exception {

		if (page.equals("MyLV")) {
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("myLvSecondLastNameErrorMsg_XPATH")))
							.getText(), "",
					"Last Name Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("myLvSecondLastNameLabel_XPATH")))),
					"Last Name label is not highlighted");

		} else {

			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("secondLastNameErrorMsg_XPATH")))
							.getText(), "",
					"Second Last Name Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("secondLastNameLabel_XPATH")))),
					"Second Last Name label is not highlighted");
		}
		log.info("Second Last Name Error message is displayed");
		Reporter.log("Second Last Name Error message is displayed");
	}

	/**
	 * 
	 * Description: This method verifies the Address Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyAddressErrMsg(WebDriver driver, String locale)
			throws Exception {
		if (locale.equals("BR")) {
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("address2ErrorMsg_XPATH")))
							.getText(), "",
					"Address Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("address2Label_XPATH")))),
					"Address label is not highlighted");
		} else {
			log.info("Address 1 field error message = '"
					+ driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("address1ErrorMsg_XPATH")))
							.getText() + "'");
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("address1ErrorMsg_XPATH")))
							.getText(), "",
					"Address Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("address1Label_XPATH")))),
					"Address label is not highlighted");
		}
		log.info("Address Error message is displayed");
		Reporter.log("Address Error message is displayed");
	}
	
	
	
	/**
	 * 
	 * Description: This method verifies the Address Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyAddressErrMsgNewAddressForm(WebDriver driver, String locale)
			throws Exception {
		if (locale.equals("BR")) {
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("newAddressFormAddress2ErrorMsg_XPATH")))
							.getText(), "",
					"Address Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("newAddressFormAddress2Label_XPATH")))),
					"Address label is not highlighted");
		} else {
			log.info("Address 1 field error message = '"
					+ driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("newAddressFormAddress1ErrorMsg_XPATH")))
							.getText() + "'");
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("newAddressFormAddress1ErrorMsg_XPATH")))
							.getText(), "",
					"Address Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("newAddressFormAddress1Label_XPATH")))),
					"Address label is not highlighted");
		}
		log.info("Address Error message is displayed");
		Reporter.log("Address Error message is displayed");
	}
	
	
	
	
	
	
	

	/**
	 * 
	 * Description: This method verifies the Street Number Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyStreetNumberErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("streetNumberErrorMsg_XPATH")))
						.getText(), "",
				"Street Number Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("streetNumberLabel_XPATH")))),
				"Street Number label is not highlighted");

		log.info("Street Number Error message is displayed");
		Reporter.log("Street Number Error message is displayed");
	}

	/**
	 * 
	 * Description: This method verifies the Street Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyStreetNameErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("streetNameErrorMsg_XPATH")))
						.getText(), "",
				"Street Name Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("streetNameLabel_XPATH")))),
				"Street Name label is not highlighted");

		log.info("Street Name Error message is displayed");
		Reporter.log("Street Name Error message is displayed");
	}

	
	
	/**
	 * 
	 * Description: This method verifies the Street Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void newAddressFormVerifyStreetNameErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("newAddressFormStreetNameErrorMsg_XPATH")))
						.getText(), "",
				"Street Name Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("newAddressFormStreetNameLabel_XPATH")))),
				"Street Name label is not highlighted");

		log.info("Street Name Error message is displayed");
		Reporter.log("Street Name Error message is displayed");
	}
	
	/**
	 * 
	 * Description: This method verifies the Street Name Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void newAddressFormVerifyStreetNumberErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("newAddressFormStreetNumberErrorMsg_XPATH")))
						.getText(), "",
				"Street Name Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("newAddressFormStreetNumberLabel_XPATH")))),
				"Street Name label is not highlighted");

		log.info("Street Name Error message is displayed");
		Reporter.log("Street Name Error message is displayed");
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * Description: This method verifies the Postal Code Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyPostalCodeErrMsg(WebDriver driver, String page)
			throws Exception {

		if (page.equals("MyLV")) {
			
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp
									.getProperty("newAddressFormPostalCodeLabel_XPATH")))
							.getText(), "",
					"Postal Code Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("newAddressFormPostalCodeErrorMsg_XPATH")))),
					"Postal Code label is not highlighted");

			log.info("Postal Code Error message is displayed");
			Reporter.log("Postal Code Error message is displayed");
			
		}
		
		else{
		
		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("postalCodeErrorMsg_XPATH")))
						.getText(), "",
				"Postal Code Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("postalCodeLabel_XPATH")))),
				"Postal Code label is not highlighted");

		log.info("Postal Code Error message is displayed");
		Reporter.log("Postal Code Error message is displayed");
		}
		}

	/**
	 * 
	 * Description: This method verifies the City Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyCityErrMsg(WebDriver driver,String page) throws Exception {

		if (page.equals("MyLV")) {
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp.getProperty("newAddressFormCityErrorMsg_XPATH")))
							.getText(), "", "City Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("newAddressFormCityLabel_XPATH")))),
					"City label is not highlighted");

			log.info("City Error message is displayed");
			Reporter.log("City Error message is displayed");
			
			
			
		}
		else{
		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp.getProperty("cityErrorMsg_XPATH")))
						.getText(), "", "City Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("cityLabel_XPATH")))),
				"City label is not highlighted");

		log.info("City Error message is displayed");
		Reporter.log("City Error message is displayed");
		}
		}

	/**
	 * 
	 * Description: This method verifies the State Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyStateErrMsg(WebDriver driver,String page) throws Exception {

		if (page.equals("MyLV")) {
		
			Assert.assertNotEquals(
					driver.findElement(
							By.xpath(ObjRepoProp.getProperty("newAddressFormStateErrorMsg_XPATH")))
							.getText(), "", "State Error message is not displayed");

			Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
					driver.findElement(By.xpath(ObjRepoProp
							.getProperty("newAddressFormStateLabel_XPATH")))),
					"State label is not highlighted");

			log.info("State Error message is displayed");
			Reporter.log("Sate Error message is displayed");
			
		}
		else{
		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp.getProperty("stateErrorMsg_XPATH")))
						.getText(), "", "State Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("stateLabel_XPATH")))),
				"State label is not highlighted");

		log.info("State Error message is displayed");
		Reporter.log("Sate Error message is displayed");
		}
		}

	/**
	 * 
	 * Description: This method verifies the Phone Number Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyPhoneNumberErrMsg(WebDriver driver,String page)
			throws Exception {

if (page.equals("MyLV")) {
			
	Assert.assertNotEquals(
			driver.findElement(
					By.xpath(ObjRepoProp
							.getProperty("newAddressFormPhoneNumberErrorMsg_XPATH")))
					.getText(), "",
			"Phone Number Error message is not displayed");

	Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
			driver.findElement(By.xpath(ObjRepoProp
					.getProperty("newAddressFormPhoneNumb1Label_XPATH")))),
			"Phone Number label is not highlighted");

	log.info("Phone Number Error message is displayed");
	Reporter.log("Phone Number Error message is displayed");
	
		}
		
else{
			
		
		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("phoneNumberErrorMsg_XPATH")))
						.getText(), "",
				"Phone Number Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("phoneNumberLabel_XPATH")))),
				"Phone Number label is not highlighted");

		log.info("Phone Number Error message is displayed");
		Reporter.log("Phone Number Error message is displayed");
}	
}

	/**
	 * 
	 * Description: This method verifies the Email Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyEmailErrMsg(WebDriver driver) throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp.getProperty("emailErrorMsg_XPATH")))
						.getText(), "", "Email Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("emailLabel_XPATH")))),
				"Email label is not highlighted");

		log.info("Email Error message is displayed");
		Reporter.log("Email Error message is displayed");
	}

	/**
	 * 
	 * Description: This method verifies the Phone Number2 Error Message in add a new address form in billing/shipping page
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyPhoneNumber2ErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("phoneNumber2ErrorMsg_XPATH")))
						.getText(), "",
				"Phone Number Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("phoneNumber2Label_XPATH")))),
				"Phone Number 2 label is not highlighted");

		log.info("Phone Number 2 Error message is displayed");
		Reporter.log("Phone Number 2 Error message is displayed");
	}

	
	/**
	 * 
	 * Description: This method verifies the Phone Number2 Error Message in add a new address form in MyLV page
	 * 
	 * @return nothing
	 * 
	 */

	public static void newAddressFormVerifyPhoneNumber2ErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("newAddressFormPhoneNumb2ErrMessage_XPATH")))
						.getText(), "",
				"Phone Number Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("newAddressFormPhoneNumb2Label_XPATH")))),
				"Phone Number 2 label is not highlighted");

		log.info("Phone Number 2 Error message is displayed");
		Reporter.log("Phone Number 2 Error message is displayed");
	}
	
	
	/**
	 * 
	 * Description: This method verifies the Phone Number3 Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyPhoneNumber3ErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("phoneNumber3ErrorMsg_XPATH")))
						.getText(), "",
				"Phone Number Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("phoneNumber3Label_XPATH")))),
				"Phone Number 3 label is not highlighted");

		log.info("Phone Number 3 Error message is displayed");
		Reporter.log("Phone Number 3 Error message is displayed");
	}
	
	
	
	
	/*
	 * @param driver : WebDriver
	 * 
	 * @param locale
	 * 
	 * @param title : Selected Title to verify
	 * 
	 * @throws Exception
	 */
	public static void verifyTitlePresentInAccountCreationForm(
			WebDriver driver, String driverName, String locale)
			throws Exception {

		

			Assert.assertTrue(
					CustomFun.isElementPresent(
							By.id(ObjRepoProp.getProperty("titleDropDown_ID")),
							driver), "Title selection option is not present");


	}

	/**
	 * 
	 * Description: This method verifies Privacy Policy Checkbox
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyPricacyPolicyErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("privacyPolicyErrMsg_XPATH")))
						.getText(), "",
				"Privacy Policy Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("privacyPolicyLabel_XPATH")))),
				"Privacy Policy label is not highlighted");

		log.info("Privacy Policy Error message is displayed");
		Reporter.log("Privacy Policy Error message is displayed");
	}

	/**
	 * 
	 * Description: This method verifies Fiscal Code Error Msg
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyFiscalCodeErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("fiscalCodeErrMsg_XPATH")))
						.getText(), "",
				"Fiscal Code Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("fiscalCodeLabel_XPATH")))),
				"Fiscal Code label is not highlighted");

		log.info("Fiscal Code Error message is displayed");
		Reporter.log("Fiscal Code Error message is displayed");
	}

	/**
	 * 
	 * Description: This method verifies Privacy Policy Checkbox
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyAddressFormDisplayEditMode(WebDriver driver,
			String locale) throws Exception {

		// Verify First Name
		log.info("firstName = "
				+ driver.findElement(
						By.id(ObjRepoProp.getProperty("firstNameTxtBox_ID")))
						.getAttribute("value"));
		Assert.assertNotEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("firstNameTxtBox_ID")))
						.getAttribute("value"), "",
				"First Name is not prefilled");

		// Verify Last Name
		Assert.assertNotEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("lastNameTxtBox_ID")))
						.getAttribute("value"), "",
				"last Name is not prefilled");
		if (locale.equals("JP")) {

			// Verify Second First Name
			Assert.assertNotEquals(
					driver.findElement(
							By.id(ObjRepoProp
									.getProperty("secondFirstNameTxtBox_JP_ID")))
							.getAttribute("value"), "",
					"Second First Name is not prefilled");

			// Verify Second Last Name
			Assert.assertNotEquals(
					driver.findElement(
							By.id(ObjRepoProp
									.getProperty("secondLastNameTxtBox_JP_ID")))
							.getAttribute("value"), "",
					"Second Last Name is not prefilled");

		}
		if (locale.equals("BR")) {

			// Verify Street Number
			Assert.assertNotEquals(
					driver.findElement(
							By.id(ObjRepoProp.getProperty("streetNumber_BR_ID")))
							.getAttribute("value"), "",
					"Street Number is not prefilled");

			// Verify Complement Address
			Assert.assertNotEquals(
					driver.findElement(
							By.id(ObjRepoProp
									.getProperty("complementAddressTxtBox_BR_ID")))
							.getAttribute("value"), "",
					"Complement Address is not prefilled");

			// Verify Address2
			Assert.assertNotEquals(
					driver.findElement(
							By.id(ObjRepoProp.getProperty("address2TxtBox_ID")))
							.getAttribute("value"), "",
					"Address2 is not prefilled");
		} else {

			// Verify Address1
			Assert.assertNotEquals(
					driver.findElement(
							By.id(ObjRepoProp.getProperty("address1TxtBox_ID")))
							.getAttribute("value"), "",
					"Address1 is not prefilled");
		}

		// Verify Postal Code
		Assert.assertNotEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("postalCodeTxtBox_ID")))
						.getAttribute("value"), "",
				"Postal Code is not prefilled");

		// Verify City
		Assert.assertNotEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("cityTxtBox_ID")))
						.getAttribute("value"), "", "City is not prefilled");

		// Verify Phone Number
		Assert.assertNotEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("phoneNumberTxtBox_ID")))
						.getAttribute("value"), "",
				"Phone Number is not prefilled");

		// Verify Save button
		Assert.assertTrue(CustomFun.isElementVisible(
				By.xpath(ObjRepoProp.getProperty("saveAddressBtn_XPATH")),
				driver), "Save button is not displayed");

		// Verify Close icon
		Assert.assertTrue(CustomFun.isElementVisible(By.xpath(ObjRepoProp
				.getProperty("addAddressFormCloseBtn_XPATH")), driver),
				"Close button is not displayed");

		log.info("Successfully verified all the details of edit address popin");
		Reporter.log("Successfully verified all the details of edit address popin");
	}

	/**
	 * 
	 * Description: This method verifies Privacy Policy Checkbox
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyNewAddressForm(WebDriver driver, String locale)
			throws Exception {

		// Verify First Name
		Assert.assertTrue(CustomFun.isElementPresent(
				By.id(ObjRepoProp.getProperty("firstNameTxtBox_ID")), driver),
				"First Name field is not displayed");

		// Verify Last Name
		Assert.assertTrue(CustomFun.isElementPresent(
				By.id(ObjRepoProp.getProperty("lastNameTxtBox_ID")), driver),
				"last Name field is not displayed");

		if (locale.equals("JP")) {

			// Verify Second First Name
			Assert.assertTrue(CustomFun.isElementPresent(By.id(ObjRepoProp
					.getProperty("secondFirstNameTxtBox_JP_ID")), driver),
					"Second First Name field is not displayed");

			// Verify Second Last Name
			Assert.assertTrue(CustomFun.isElementPresent(By.id(ObjRepoProp
					.getProperty("secondLastNameTxtBox_JP_ID")), driver),
					"Second last Name field is not displayed");

		}
		if (locale.equals("BR")) {

			// Verify Street Number
			Assert.assertTrue(CustomFun.isElementPresent(
					By.id(ObjRepoProp.getProperty("streetNumber_BR_ID")),
					driver), "Street Number field is not displayed");

			// Verify Complement Address
			Assert.assertTrue(CustomFun.isElementPresent(By.id(ObjRepoProp
					.getProperty("complementAddressTxtBox_BR_ID")), driver),
					"Complement Address field is not displayed");

			// Verify Address2
			Assert.assertTrue(
					CustomFun.isElementPresent(
							By.id(ObjRepoProp.getProperty("address2TxtBox_ID")),
							driver), "Address2 field is not displayed");
		} else {

			// Verify Address1
			Assert.assertTrue(
					CustomFun.isElementPresent(
							By.id(ObjRepoProp.getProperty("address1TxtBox_ID")),
							driver), "Address1 field is not displayed");
		}

		// Verify Postal Code
		Assert.assertTrue(CustomFun.isElementPresent(
				By.id(ObjRepoProp.getProperty("postalCodeTxtBox_ID")), driver),
				"Postal Code field is not displayed");

		// Verify City
		Assert.assertTrue(CustomFun.isElementPresent(
				By.id(ObjRepoProp.getProperty("cityTxtBox_ID")), driver),
				"City field is not displayed");

		// Verify Phone Number
		Assert.assertTrue(
				CustomFun.isElementPresent(
						By.id(ObjRepoProp.getProperty("phoneNumberTxtBox_ID")),
						driver), "Phone Number field is not displayed");

		// Verify Save button
		GUIFunctions.mouseOverElement(driver, driver.findElement(By
				.xpath(ObjRepoProp.getProperty("saveAdressButton_XPATH"))));
		Assert.assertTrue(CustomFun.isElementPresent(
				By.xpath(ObjRepoProp.getProperty("saveAdressButton_XPATH")),
				driver), "Save button field is not displayed");

		// Verify Close icon
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
				.getProperty("addAddressFormCloseBtn_XPATH")), driver),
				"Close button field is not displayed");

		log.info("Successfully verified all the details of address popin");
		Reporter.log("Successfully verified all the details of address popin");
	}

	/**
	 * 
	 * Description: This method verifies the Date Of Birth Error Message
	 * 
	 * @return nothing
	 * 
	 */

	public static void verifyInvalidDateOfBirthErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("dateOfBirthErrorMsg_XPATH")))
						.getText(), "",
				"Date Of Birth Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("personalInfoDOBLabel_XPATH")))),
				"Date Of Birth Label is not highlighted");

		log.info("Date Of Birth Error message is displayed");
		Reporter.log("Date Of Birth Error message is displayed");
	}

	/**
	 * Description: This method verifies the Fiscal Code Field Error Message
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyFiscalCodeFieldErrMsg(WebDriver driver)
			throws Exception {

		Assert.assertNotEquals(
				driver.findElement(
						By.xpath(ObjRepoProp
								.getProperty("fiscalCodeErrMsg_XPATH")))
						.getText(), "",
				"Fiscal Code Field Error message is not displayed");

		Assert.assertTrue(CustomFun.isLableHighLightedOnErrorAlert("color",
				driver.findElement(By.xpath(ObjRepoProp
						.getProperty("fiscalCodeLabel_XPATH")))),
				"Fiscal Code label is not highlighted");

		log.info("Fiscal Code Field Error message is displayed");
		Reporter.log("Fiscal Code Field Error message is displayed");
	}
	
	/**
	 * 
	 * This function Verifies address form field values
	 * 
	 * @param driver
	 * @param driverName
	 * @param locale
	 * @param isE_Commerce
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param secondFirstName
	 * @param secondLastName
	 * @param address1
	 * @param streetNumber
	 * @param address2
	 * @param postalCode
	 * @param city
	 * @param state
	 * @param phoneNumber
	 * @throws Exception
	 */
	public static void verifyAddressFormDetails(WebDriver driver,
			String driverName, String locale, boolean isE_Commerce,
			String title, String firstName, String lastName,
			String secondFirstName, String secondLastName, String address1,
			String streetNumber, String address2, String postalCode,
			String city, String state, String phoneNumber) throws Exception {

		// Verify selected title
		Assertions.verifyTitleInAddressSection(driver, driverName, locale,
				title);

		// Verify entered First Name value
		Assert.assertEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("firstNameTxtBox_ID")))
						.getAttribute("value"), firstName, "First Name value is not displayed");

		// Verify entered Last Name value
		Assert.assertEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("lastNameTxtBox_ID")))
						.getAttribute("value"),
						lastName,
				"Last Name value is not displayed");

		if (locale.equalsIgnoreCase("JP")) {

			// Verify entered second first Name value
			Assert.assertEquals(
					driver.findElement(
							By.id(ObjRepoProp
									.getProperty("secondFirstNameTxtBox_JP_ID")))
							.getAttribute("value"), secondFirstName,
					"Second first Name value is not displayed");

			// Verify entered second Last Name value
			Assert.assertEquals(
					driver.findElement(
							By.id(ObjRepoProp
									.getProperty("secondLastNameTxtBox_JP_ID")))
							.getAttribute("value"), secondLastName,
					"Second Last Name value is not displayed");

		}
		
		if (locale.equalsIgnoreCase("US") || locale.equalsIgnoreCase("JP")) {

			
		} 

		if (isE_Commerce && !locale.equalsIgnoreCase("BR")
				&& !locale.equalsIgnoreCase("JP")) {

			// Verify entered address1 value
			Assert.assertEquals(
					driver.findElement(
							By.id(ObjRepoProp.getProperty("address1TxtBox_ID")))
							.getAttribute("value"), address1, "Address value is not displayed");
		}

		if (locale.equalsIgnoreCase("BR")) {

			
			// Verify Neighborhood
			Assert.assertEquals(
					driver.findElement(
							By.id(ObjRepoProp.getProperty("address2TxtBox_ID")))
							.getAttribute("value"), address2);

			
		}
			
		
		// Verify entered address2 value
		Assert.assertEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("address2TxtBox_ID")))
						.getAttribute("value"), address2, "Address2 value is not displayed");

		// Verify entered zipcode value
		Assert.assertEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("postalCodeTxtBox_ID")))
						.getAttribute("value"), postalCode, "Zipcode value is not displayed");

		// Verify entered phone number field value
		Assert.assertEquals(
				driver.findElement(
						By.id(ObjRepoProp.getProperty("phoneNumberTxtBox_ID")))
						.getAttribute("value").replace(" ", "").trim(),
						phoneNumber.replace(" ", "").trim(),
				"Phone number value is not displayed");

	}
	
	
	

	/**
	 * 
	 * Verify confirmation popin displayed after adding product to cart 
	 *
	 * 
	 *           
	 * @throws Exception
	 */
	public static void verifyAddToCartConfirmationPopIn(WebDriver driver) throws Exception {
		

		// Verify confirmation popin
				Assert.assertTrue(CustomFun.isElementPresent(
						By.xpath(ObjRepoProp
								.getProperty("addToBagSuccMsg_XPATH")), driver));	
				log.info("Add to cart confirmation popin is displayed\n");
				Reporter.log("<p>Add to cart confirmation popin is displayed");

	

	}
	
	
	/**
	 * 
	 * Description: This method verifies  the Shipping method displayed under shipping address blocn
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyShippingmethod(
			WebDriver driver, String locale) throws Exception {
		//For US locale
		if (locale.equals("US")) {
			
			// Verify Shipping method Complimentary Standard is present
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("shippingMethodStandardRadioBtn_XPATH")),
					driver));

			// Verify Shipping method Express is present
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
					.getProperty("shippingMethodExpressRadioBtn_XPATH")),
					driver));
			//Verify Shipping method Overnight is present
			Assert.assertTrue(CustomFun.isElementPresent(By.id(ObjRepoProp
					.getProperty("shippingMethodOvernightRadioBtn_ID")),
					driver));
			log.info("Shipping methods are verified\n");
			Reporter.log("<p>Shipping methods are verified");
			

		}
		// For EU Locale: 
				else if (locale.equals("FR") || locale.equals("DE")
						|| locale.equals("ES")

						|| locale.equals("IT") || locale.equals("UK"))

				{
					// Verify Shipping method Complimentary Standard is present
					Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
							.getProperty("shippingMethodStandardRadioBtn_XPATH")),
							driver));

					// Verify Shipping method Express is present
					Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
							.getProperty("shippingMethodExpressRadioBtn_XPATH")),
							driver));
					log.info("Shipping methods are verified\n");
					Reporter.log("<p>Shipping methods are verified");
				}
		//For JP locale
				else if (locale.equals("JP") )

						

				{
					// Verify Shipping method Complimentary Standard is present
					Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
							.getProperty("shippingMethodStandardRadioBtn_XPATH")),
							driver));
					
					//Verify delivery date 
					Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
							.getProperty("deliveryDate_XPATH")),
							driver));
					//Verify the Delivery time
					Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
							.getProperty("deliveryTime_XPATH")),
							driver));
				}
		//For CA,BR and AU locales
				else if (locale.equals("CA") || locale.equals("BR")
						|| locale.equals("AU"))						

				{
					// Verify Shipping method Complimentary Standard is present
					Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp
							.getProperty("shippingMethodStandardRadioBtn_XPATH")),
							driver));
				}
		
	}
	
	
}
