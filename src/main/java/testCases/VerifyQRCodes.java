package testCases;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import locators.QRCodes;
import utilities.ConfigFileReader;
import utilities.Services;

public class VerifyQRCodes {

	static ConfigFileReader config = new ConfigFileReader();
	String random = RandomStringUtils.randomAlphabetic(3);

	@Test(description = "Verify QR code is generated")
	@Description("QR code should get generated with recent and added survey")
	@Epic("EP003")
	@Feature("Feature3:QR Code Feature")
	@Story("Story: Validate the entire work flow of Create QR Code")
	@Severity(SeverityLevel.CRITICAL)

	void verifyQRCodeGenrated()
			throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {

		Services.initializeDriver();
		Services.login();
		Services.waitForElementToBeClickable(QRCodes.qrCode);
		Services.clickElementByXPath(QRCodes.qrCode);
		Services.clickElementByXPath(QRCodes.createQRBTTN);
		Services.sendKeysbyXpath(QRCodes.firstName, "QRCODE "+random);
		Services.clickElementByXPath(QRCodes.SurveyBttn);
		Services.getDataFromList(QRCodes.targetOptionList, "TEST", Services.getDriver());
		Services.clickElementByXPath(QRCodes.qrSaveBttn);
		Services.copyText(Services.getDriver(), QRCodes.copyBttn);
		Services.handleWindow(Services.myText, Services.getDriver());
		Services.clickElementByXPath(QRCodes.qrCode);
		Services.waitForElementToBeClickable(QRCodes.table);
		Services.verifyDataFromList(QRCodes.verifyQRList, "QRCODE "+random, Services.getDriver());
		Services.closeBrowser();

	}
}
