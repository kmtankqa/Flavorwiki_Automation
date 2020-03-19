package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QRCodes {

	// QR Codes
	public static By qrCode = By.xpath("//li[@title='QR Codes']");
	public static By createQRBTTN = By.xpath("//button[@data-testid='create-qr']");
	public static By firstName = By.xpath("//input[@name='name']");
	public static By SurveyBttn = By.xpath("//span[contains(text(),'Link to survey')]");
	public static By targetOptionList = By.xpath("//ul[@role='listbox']//li");
	public static By qrSaveBttn = By.xpath("//button[@data-testid='save']");
	public static By copyBttn = By.xpath("//div[@class='styles__CopyButton-sc-3r7fvw-7 hXtDXB']");
	public static By table = By.xpath("//div[@class='ant-spin-container']");
	public static By verifyQRList = By.xpath("//div[@class='styles__TitleWrapper-sc-2v8exd-2 gGsgBA']//div");

	public static WebElement getWebElement(WebDriver driver, By Xpath) {

		WebElement webElement = driver.findElement(Xpath);

		return webElement;
	}

}
