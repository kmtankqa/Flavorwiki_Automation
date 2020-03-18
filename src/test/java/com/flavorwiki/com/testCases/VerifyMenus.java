package com.flavorwiki.com.testCases;


import org.testng.annotations.Listeners;
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


@Listeners({ScreenshotListener.class})

public class VerifyMenus {
	
	
	 ConfigFileReader config = new ConfigFileReader();

	
	@Test(description= "Verify all the menu Items of left side navigation panel")
	@Description("We willl verify all the menu Items")
	@Epic("EP001")
	@Feature("Feature1: FlavorWiki Menu's")
	@Story("Story:FlavorWiki Menu's should be in workable condition")
	@Severity(SeverityLevel.MINOR)

	void verifyMenuItems() throws InterruptedException {

		Services.initializeDriver();
		Services.login();
		Services.assert_element_textPresent(config.expectedTextDashBoard(), Locators.DashBoard);
		Services.clickElementByXPath(Locators.surveyLabel);
		Services.assert_element_present(Locators.createSurveyBTTN);
		Services.clickElementByXPath(Locators.qrCode);
		Services.assert_element_present(Locators.createQRBTTN);
		Services.clickElementByXPath(Locators.termUseLBL);
		Services.assert_element_textPresent(config.expectedTextTerms(), Locators.textTermAndUse);
		Services.clickElementByXPath(Locators.privacyLBL);
		Services.assert_element_textPresent(config.expectedTextPrivacy(), Locators.privacyPolicyText);
		Services.closeBrowser();

	}
}