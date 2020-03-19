package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Surveys {

	public static By username = By.xpath("//input[@placeholder='Username']");
	public static By password = By.xpath("//input[@placeholder='Password'] ");
	public static By loginbutton = By.xpath("//button[@data-testid= 'submit-button']");
	public static By createSurveyBTTN = By.xpath("//button[@data-testid='create-survey-button']");
	public static By createQRBTTN = By.xpath("//button[@data-testid='create-qr']");
	public static By termUseLBL = By.xpath("//span[contains(text(),'Terms of use')]");
	public static By privacyLBL = By.xpath("//span[contains(text(),'Privacy policy')] ");
	public static By textTermAndUse = By.xpath("//span[@class='styles__Title-gr4wn0-1 dOUGOv']");
	public static By privacyPolicyText = By.xpath("//span[@class='styles__Title-sc-1kj6w7a-1 jaPlKg']");
	public static By DashBoard = By
			.xpath("//span[@class='styles__Title-sc-1si6g36-1 fWFRlj styles__StyledText-sc-1jx5wx9-0 hfgQUm']");
	public static By qrCode = By.xpath("//li[@title='QR Codes']");
	public static By SurveyBttn = By.xpath("//span[contains(text(),'Link to survey')]");
	public static By qrSaveBttn = By.xpath("//button[@data-testid='save']");
	public static By surveyBTTN = By.xpath("//span[contains(text(),'Link to survey')]");
	public static By uniqueName = By.xpath("//input[@name='uniqueName']");
	public static By firstName = By.xpath("//input[@name='name']");
	
	public static By targetOption = By.xpath("//div[@class='ant-select-selection__rendered']");
	public static By targetOptionList = By.xpath("//ul[@role='listbox']//li");
	public static By copyBttn = By.xpath("//div[@class='styles__CopyButton-sc-3r7fvw-7 hXtDXB']");
	public static By verifyQRList = By.xpath("//div[@class='styles__TitleWrapper-sc-2v8exd-2 gGsgBA']//div");
	public static By listVisible= By.xpath("//div[@class='ant-table-body']");

	
	//Third Test Case
	public static By surveyLabel= By.xpath("//span[contains(text(),'Surveys')]");
	public static By surveyNameField= By.xpath("//input[@name='name']");
	public static By addStep= By.xpath("//span[contains(text(), 'Add step')]");
	public static By stepField= By.xpath("(//INPUT[@class='ant-input styles__InputStyled-q82e0s-1 diwjpv'])[7]");
	public static By paymentTab= By.xpath("//div[contains(text(),'Payments')]");
	public static By payPal= By.xpath("(//SPAN[text()='Enable'][text()='Enable'])[1]");
	public static By giftCard= By.xpath("(//span[text()='Enable'][text()='Enable'])[2]");
	public static By ques1= By.xpath("//textarea[@data-testid='choose-one-question-text']");
	public static By ques2= By.xpath("(//TEXTAREA[@class='ant-input styles__InputStyled-sc-1bszpoc-1 cYiMca'])[3]");
	public static By productsTab= By.xpath("//div[contains(text(),'Products')]");
	public static By newProductBttn= By.xpath("//button[@data-testid='new-product-button']");
	public static By newProductName= By.xpath("//input[@name='name']");
	public static By newProductBrand= By.xpath("//input[@name='brand']");
	public static By screeningTab= By.xpath("//div[contains(text(),'Screening')]");
	public static By newStepSurveyBTTN= By.xpath("//button[@data-testid='new-step-button']");
	public static By screeningQuesList=By.xpath("//ul[@role='listbox']//li");
	public static By screeningQuesdropDwn=By.xpath("//div[contains(@class,'ant-col ant-col-md-24 ant-col-lg-16')]//div[contains(@class,'ant-select-selection__rendered')]");
	public static By screeningQuesField=By.xpath("//textarea[@name='prompt']");
	public static By ans1=By.xpath("//input[@name='0-label']");
	public static By ans1value=By.xpath("//input[@name='0-value']");
	public static By ans2=By.xpath("//input[@name='1-label']");
	public static By ans2value=By.xpath("//input[@name='1-value']");
	public static By chartTopicList=By.xpath("//ul[@role='listbox']//li");
	public static By screeningChartdropDwn=By.xpath("//div[contains(@class,'ant-col ant-col-md-12 ant-col-lg-8')]//div[contains(@class,'ant-select-selection__rendered')]");
	public static By chartTopic=By.xpath("//input[@name='chartTopic']");
	public static By chartTitle=By.xpath("//input[contains(@name,'chartTitle')]");
	public static By nextArrow=By.xpath("//span[@class='ant-tabs-tab-next-icon']");
	public static By tastingLoopTab=By.xpath("//div[contains(text(),'Tasting loop')]");
	public static By tastingLoopBttn= By.xpath("//button[@data-testid='new-step-button']");
	public static By tastingQuesDropSwn= By.xpath("//div[contains(@class,'ant-select-selection__placeholder')]");
	public static By tastingQuesList = By.xpath("//ul[@role='listbox']//li");
	public static By tastingQues = By.xpath("//textarea[contains(@name,'prompt')]");
	public static By tastingans1=By.xpath("//input[@name='0-label']");
	public static By tastingans1value=By.xpath("//input[@name='0-value']");
	public static By tastingans2=By.xpath("//input[@name='1-label']");
	public static By tastingans2value=By.xpath("//input[@name='1-value']");
	public static By afterTastingTab=By.xpath("//div[contains(text(),'After tasting')]");
	public static By atStepSurveyBTTN= By.xpath("//button[@data-testid='new-step-button']");
	public static By atargetOption = By.xpath("//div[@class='ant-select-selection__rendered']");
	public static By atastingQuesList = By.xpath("//ul[@role='listbox']//li");
	public static By atastingQues = By.xpath("//textarea[contains(@name,'prompt')]");
	public static By publishSurvey = By.xpath("//button[@data-testid='publish-survey-button']");
	public static By verifySurveyList = By.xpath("//div[@class='styles__SurveyNameContainer-sc-1r8hbz7-4 eKQpJY']");
	public static By table = By.xpath("//div[@class='ant-spin-container']");

	


	public static WebElement getWebElement(WebDriver driver, By Xpath) {

		WebElement webElement = driver.findElement(Xpath);

		return webElement;
	}


}
