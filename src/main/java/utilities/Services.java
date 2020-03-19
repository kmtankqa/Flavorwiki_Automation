package utilities;

import static utilities.Constants.WAIT_EXPLICIT_SEC;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.Common;

public class Services {

	static ConfigFileReader config = new ConfigFileReader();
	public static String myText;
	public static WebDriver driver;
	public static WebElement survey;
	public static WebElement qrcodes;
	public static WebElement terms;
	public static WebElement privacy;

	// This method is to initialize the driver
	public static void driverInitialization() {
		System.setProperty("webdriver.chrome.driver", config.getDriverPath());

		driver = new ChromeDriver();
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driverInitialization();
		}
		return driver;
	}

	public static void initializeDriver() {

		getDriver();

	}

	public static void clickElement(WebElement webElement) {

		isElementDisplayed(webElement);
		waitForElementToBeClickable(webElement);
		webElement.click();

	}

	public static void clickElementByXPath(By Xpath) {

		waitForElementToBeClickable(Xpath);
		Common.getWebElement(driver, Xpath).click();

	}

	public static boolean isElementDisplayedByXpath(WebElement webElement) {

		return isElementDisplayed(webElement, WAIT_EXPLICIT_SEC);

	}

	public static boolean isElementPresent(By xpath) {
		try {
			waitForElementToBeClickable(xpath);
			driver.findElement(xpath);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementDisplayed(WebElement webElement) {

		return isElementDisplayed(webElement, WAIT_EXPLICIT_SEC);

	}

	public static void waitForElementToBeClickable(By Xpath) {

		WebDriverWait wait = new WebDriverWait(Services.getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));

	}

	public static void waitForElementToBeClickable(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));

	}

	public static boolean isElementDisplayed(WebElement webElement, int timeOut) {

		WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement.isDisplayed();

	}

	public static void login() throws InterruptedException {

		try {

			driver.manage().window().maximize();
			driver.get(config.getURL());
			Services.waitForElementToBeClickable(Common.username);

			System.out.println("try end");

		} catch (Exception e) {

			System.out.println("catch start");

			driver.navigate().refresh();
			Services.waitForElementToBeClickable(Common.username);

		} finally {

			driver.findElement(Common.username).sendKeys(config.getvalidUsername());
			driver.findElement(Common.password).sendKeys(config.getvalidPassword());
			driver.findElement(Common.loginbutton).click();
		}

	}

	public static void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitForVisibilityAll(WebElement list) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOfAllElements(list));

	}

	// This method is used to hold the list of elements
	public static void getDataFromList(By List, String Text, WebDriver driver) {

		waitForElementToBeClickable(Common.targetOption);
		driver.findElement(Common.targetOption).click();

		List<WebElement> list = driver.findElements(List);

		for (int i = 0; i < list.size(); i++)

		{
			list.get(0).click();

			break;
		}
	}

	public static void verifyDataFromList(By List, String Text, WebDriver driver) throws InterruptedException {

		List<WebElement> list = driver.findElements(List);
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().contentEquals(Text)) {
				/*
				 * System.out.println(list.get(i).getText());
				 */ Assert.assertEquals(Text, list.get(i).getText());

				break;

			}

		}
	}

	public static void selectDataFromList(By List, String Text, WebDriver driver, By dropdwn) {

		driver.findElement(dropdwn).click();

		List<WebElement> list = driver.findElements(List);

		for (int i = 0; i < list.size(); i++)

		{

			if (list.get(i).getText().contains(Text)) {

				list.get(i).click();

				break;

			}

		}

	}

	public static String getText(By xpath) {

		String text = driver.findElement(xpath).getText();

		return text;

	}

	public static String getTitle(String bringTheTitle) {

		bringTheTitle = driver.getTitle();

		return bringTheTitle;

	}

	public static void assert_element_present(By xpath) {

		if (driver.findElement(xpath) != null) {
			System.out.println("Element is Present");
		} else {
			System.out.println("Element is Absent");
		}

	}

	public static void assert_element_textPresent(String ExpectedText, By xpath) throws InterruptedException {
		{

			Services.waitForElementToBeClickable(xpath);

			Assert.assertEquals(ExpectedText, driver.findElement(xpath).getText());

		}

	}

	public static void sendKeys(WebElement webElement, CharSequence... keysToSend) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		webElement.clear();
		webElement.sendKeys(keysToSend);
	}

	public static void sendKeysbyXpath(By Xpath, CharSequence... keysToSend) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Xpath));
		WebElement wl = Common.getWebElement(driver, Xpath);
		wl.clear();
		wl.sendKeys(keysToSend);
	}

	public static void copyText(WebDriver driver, By Xpath)
			throws HeadlessException, UnsupportedFlavorException, IOException {

		waitForElementToBeClickable(Xpath);
		driver.findElement(Xpath).click();

		myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); // extracting

	}

	public static void handleWindow(String copyText, WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(copyText);
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(tabs.get(0));

	}

	public static void clickByAction(WebDriver driver, By Xpath) {

		WebElement element = Services.driver.findElement(Xpath);
		Actions actions = new Actions(Services.driver);
		actions.moveToElement(element).click().perform();

	}

	public static void moveTo(WebElement element) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("window.scrollBy(0,-100);", element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

	public static void closeBrowser() throws InterruptedException {

		if (driver == null) {
			return;
		}
		driver.quit();
		driver = null;

	}

}
