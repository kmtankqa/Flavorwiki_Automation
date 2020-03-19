package testCases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import locators.Common;
import utilities.ConfigFileReader;
import utilities.ScreenshotListener;
import utilities.Services;


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
		Services.assert_element_textPresent(config.expectedTextDashBoard(), Common.DashBoard);
		Services.clickElementByXPath(Common.surveyLabel);
		Services.assert_element_present(Common.createSurveyBTTN);
		Services.clickElementByXPath(Common.qrCode);
		Services.assert_element_present(Common.createQRBTTN);
		Services.clickElementByXPath(Common.termUseLBL);
		Services.assert_element_textPresent(config.expectedTextTerms(), Common.textTermAndUse);
		Services.clickElementByXPath(Common.privacyLBL);
		Services.assert_element_textPresent(config.expectedTextPrivacy(), Common.privacyPolicyText);
		Services.closeBrowser();

	}
}