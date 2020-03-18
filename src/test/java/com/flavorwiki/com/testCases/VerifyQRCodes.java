package com.flavorwiki.com.testCases;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utils.ConfigFileReader;
import utils.Locators;
import utils.Services;

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
		Services.waitForElementToBeClickable(Locators.qrCode);
		Services.clickElementByXPath(Locators.qrCode);
		Services.clickElementByXPath(Locators.createQRBTTN);
		Services.sendKeysbyXpath(Locators.firstName, "QRCODE "+random);
		Services.clickElementByXPath(Locators.SurveyBttn);
		Services.getDataFromList(Locators.targetOptionList, "TEST", Services.getDriver());
		Services.clickElementByXPath(Locators.qrSaveBttn);
		Services.copyText(Services.getDriver(), Locators.copyBttn);
		Services.handleWindow(Services.myText, Services.getDriver());
		Services.clickElementByXPath(Locators.qrCode);
		Services.waitForElementToBeClickable(Locators.table);
		Services.verifyDataFromList(Locators.verifyQRList, "QRCODE "+random, Services.getDriver());
		Services.closeBrowser();

	}
}
