package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import locators.Common;
import utilities.ConfigFileReader;
import utilities.Services;

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
		Services.clickElementByXPath(Common.surveyLabel);
		Services.clickElementByXPath(Common.createSurveyBTTN);
		Services.sendKeysbyXpath(Common.surveyNameField, "SurveyName " + random);
		Services.clickByAction(Services.driver, Common.addStep);
		Services.sendKeysbyXpath(Common.stepField, "All the best ...!");
		Services.clickElementByXPath(Common.paymentTab);
		Services.clickElementByXPath(Common.payPal);
		Services.clickElementByXPath(Common.giftCard);
		Services.clickByAction(Services.driver, Common.ques1);
		Services.sendKeysbyXpath(Common.ques1, "This is Ques 1");
		Services.clickByAction(Services.driver, Common.ques2);
		Services.sendKeysbyXpath(Common.ques2, "This is Ques 2");
		Services.clickElementByXPath(Common.productsTab);
		Services.clickByAction(Services.driver, Common.newProductBttn);
		Services.clickElementByXPath(Common.newProductName);
		Services.sendKeysbyXpath(Common.newProductName, "Test ProductName");
		Services.clickElementByXPath(Common.newProductBrand);
		Services.sendKeysbyXpath(Common.newProductBrand, "Brand");
		Services.clickElementByXPath(Common.screeningTab);
		Services.clickByAction(Services.driver, Common.newStepSurveyBTTN);
		Services.selectDataFromList(Common.screeningQuesList, "Choose one", Services.driver,
				Common.screeningQuesdropDwn);
		Services.sendKeysbyXpath(Common.screeningQuesField, "QuesField");
		Services.clickByAction(Services.driver, Common.ans1);
		Services.sendKeysbyXpath(Common.ans1, random);
		Services.clickByAction(Services.driver, Common.ans2);
		Services.sendKeysbyXpath(Common.ans2, random2);
		Services.clickByAction(Services.driver, Common.ans1value);
		Services.sendKeysbyXpath(Common.ans1value, "89");
		Services.clickByAction(Services.driver, Common.ans2value);
		Services.sendKeysbyXpath(Common.ans2value, "15");

		WebElement eleChartTopic = Common.getWebElement(Services.getDriver(), Common.chartTopic);
		Services.moveTo(eleChartTopic);

		Services.sendKeysbyXpath(Common.chartTopic, "This is Chart Topic");
		Services.sendKeysbyXpath(Common.chartTitle, "This is Chart Title");
		Services.selectDataFromList(Common.chartTopicList, "Pie", Services.getDriver(),
				Common.screeningChartdropDwn);

		Services.clickElementByXPath(Common.nextArrow);
		Services.clickElementByXPath(Common.tastingLoopTab);
		Services.clickElementByXPath(Common.tastingLoopBttn);

		Services.selectDataFromList(Common.tastingQuesList, "Choose multiple", Services.driver,
				Common.tastingQuesDropSwn);
		Services.sendKeysbyXpath(Common.tastingQues, "Tasting Ques");
		Services.sendKeysbyXpath(Common.tastingans1, random);
		Services.sendKeysbyXpath(Common.tastingans2, random2);
		Services.sendKeysbyXpath(Common.tastingans1value, "123");
		Services.sendKeysbyXpath(Common.tastingans2value, "456");

		WebElement elChartTopic = Common.getWebElement(Services.getDriver(), Common.chartTopic);
		Services.moveTo(elChartTopic);

		Services.sendKeysbyXpath(Common.chartTopic, "Chart Topic");
		Services.sendKeysbyXpath(Common.chartTitle, "Chart Title");
		Services.clickElementByXPath(Common.afterTastingTab);
		Services.clickElementByXPath(Common.atStepSurveyBTTN);
		Services.selectDataFromList(Common.atastingQuesList, "Email", Services.driver, Common.atargetOption);
		Services.sendKeysbyXpath(Common.atastingQues, "Tasting Ques");
		Services.clickElementByXPath(Common.publishSurvey);

		Services.waitForElementToBeClickable(Common.table);
		Services.verifyDataFromList(Common.verifySurveyList, "SurveyName " + random, Services.getDriver());
		Services.closeBrowser();

	}

}
