package com.flavorwiki.com.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
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

public class VerfiyCreateSurvey {

	static ConfigFileReader config = new ConfigFileReader();
	String random = RandomStringUtils.randomAlphabetic(3);
	String random2 = RandomStringUtils.randomAlphabetic(3);
	
	@Test(description= "Verify all Application is able to create a survey")
	@Description("Create survey with multiple availlable opton and validate the results in the table")
	@Epic("EP002")
	@Feature("Feature2: Create Survey work flow")
	@Story("Story:User is able to create survey")
	@Severity(SeverityLevel.CRITICAL)

	public void createSurvey() throws InterruptedException {

		Services.initializeDriver();
		Services.login();
		Services.clickElementByXPath(Locators.surveyLabel);
		Services.clickElementByXPath(Locators.createSurveyBTTN);
		Services.sendKeysbyXpath(Locators.surveyNameField, "SurveyName " + random);
		Services.clickByAction(Services.driver, Locators.addStep);
		Services.sendKeysbyXpath(Locators.stepField, "All the best ...!");
		Services.clickElementByXPath(Locators.paymentTab);
		Services.clickElementByXPath(Locators.payPal);
		Services.clickElementByXPath(Locators.giftCard);
		Services.clickByAction(Services.driver, Locators.ques1);
		Services.sendKeysbyXpath(Locators.ques1, "This is Ques 1");
		Services.clickByAction(Services.driver, Locators.ques2);
		Services.sendKeysbyXpath(Locators.ques2, "This is Ques 2");
		Services.clickElementByXPath(Locators.productsTab);
		Services.clickByAction(Services.driver, Locators.newProductBttn);
		Services.clickElementByXPath(Locators.newProductName);
		Services.sendKeysbyXpath(Locators.newProductName, "Test ProductName");
		Services.clickElementByXPath(Locators.newProductBrand);
		Services.sendKeysbyXpath(Locators.newProductBrand, "Brand");
		Services.clickElementByXPath(Locators.screeningTab);
		Services.clickByAction(Services.driver, Locators.newStepSurveyBTTN);
		Services.selectDataFromList(Locators.screeningQuesList, "Choose one", Services.driver,
				Locators.screeningQuesdropDwn);
		Services.sendKeysbyXpath(Locators.screeningQuesField, "QuesField");
		Services.clickByAction(Services.driver, Locators.ans1);
		Services.sendKeysbyXpath(Locators.ans1, random);
		Services.clickByAction(Services.driver, Locators.ans2);
		Services.sendKeysbyXpath(Locators.ans2, random2);
		Services.clickByAction(Services.driver, Locators.ans1value);
		Services.sendKeysbyXpath(Locators.ans1value, "89");
		Services.clickByAction(Services.driver, Locators.ans2value);
		Services.sendKeysbyXpath(Locators.ans2value, "15");

		WebElement eleChartTopic = Locators.getWebElement(Services.getDriver(), Locators.chartTopic);
		Services.moveTo(eleChartTopic);

		Services.sendKeysbyXpath(Locators.chartTopic, "This is Chart Topic");
		Services.sendKeysbyXpath(Locators.chartTitle, "This is Chart Title");
		Services.selectDataFromList(Locators.chartTopicList, "Pie", Services.getDriver(),
				Locators.screeningChartdropDwn);

		Services.clickElementByXPath(Locators.nextArrow);
		Services.clickElementByXPath(Locators.tastingLoopTab);
		Services.clickElementByXPath(Locators.tastingLoopBttn);

		Services.selectDataFromList(Locators.tastingQuesList, "Choose multiple", Services.driver,
				Locators.tastingQuesDropSwn);
		Services.sendKeysbyXpath(Locators.tastingQues, "Tasting Ques");
		Services.sendKeysbyXpath(Locators.tastingans1, random);
		Services.sendKeysbyXpath(Locators.tastingans2, random2);
		Services.sendKeysbyXpath(Locators.tastingans1value, "123");
		Services.sendKeysbyXpath(Locators.tastingans2value, "456");

		WebElement elChartTopic = Locators.getWebElement(Services.getDriver(), Locators.chartTopic);
		Services.moveTo(elChartTopic);

		Services.sendKeysbyXpath(Locators.chartTopic, "Chart Topic");
		Services.sendKeysbyXpath(Locators.chartTitle, "Chart Title");
		Services.clickElementByXPath(Locators.afterTastingTab);
		Services.clickElementByXPath(Locators.atStepSurveyBTTN);
		Services.selectDataFromList(Locators.atastingQuesList, "Email", Services.driver, Locators.atargetOption);
		Services.sendKeysbyXpath(Locators.atastingQues, "Tasting Ques");
		Services.clickElementByXPath(Locators.publishSurvey);

		Services.waitForElementToBeClickable(Locators.table);
		Services.verifyDataFromList(Locators.verifySurveyList, "SurveyName " + random, Services.getDriver());
		Services.closeBrowser();

	}

}
