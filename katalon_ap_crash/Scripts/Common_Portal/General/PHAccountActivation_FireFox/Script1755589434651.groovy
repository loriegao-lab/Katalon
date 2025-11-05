import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.kms.katalon.util.CryptoUtil
import com.kms.katalon.core.configuration.RunConfiguration


userDir = System.getProperty("user.dir");

System.setProperty("webdriver.gecko.driver", userDir + "\\Drivers\\firefox_win64\\geckodriver.exe");

WebDriver firefoxDriver = new FirefoxDriver();

RunConfiguration.storeDriver(firefoxDriver);

DriverFactory.changeWebDriver(firefoxDriver);

WebUI.navigateToUrl(GlobalVariable.Gmail_URL)	

WebUI.maximizeWindow()

	
WebUI.setText(findTestObject('AgencyPortal/General/input_email_Gmail'), username)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text'): 'Next'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.setEncryptedText(findTestObject('AgencyPortal/General/input_password'), password)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text'): 'Next'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(6)

WebUI.setText(findTestObject('AgencyPortal/General/input_searchMail_Gmail'), mainContactPrimaryEmail)

WebUI.click(findTestObject('AgencyPortal/General/btn_searchIcon_Gmail', [:]))

WebUI.delay(10)

WebUI.click(findTestObject('AgencyPortal/Dynamic/Table/tableCellByTextAndIndex_Gmail', [('text'): 'Welcome to Dev Encova Insurance', ('index'): '1']))

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text'): '[ Account Activation Link ]'], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(1)

//Password setup
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByHeadingText'), [('heading') : 'Password', ('text'): 'Set up'], FailureHandling.STOP_ON_FAILURE)
		
WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsText'), [('text'): 'Enter password', ('value') : phAccountPassword], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsText'), [('text'): 'Re-enter password', ('value') : phAccountPassword], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AgencyPortal/Dynamic/Input/inputByValue', [('value') : 'Next']))

//Security Question setup
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByHeadingText'), [('heading') : 'Security Question', ('text'): 'Set up'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioBeforeText'), [('text') : securityQuestionType], FailureHandling.STOP_ON_FAILURE)

if(securityQuestionType == 'Choose a security question') {
	
	//WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Choose a security question', ('option') : securityQuestion], FailureHandling.STOP_ON_FAILURE)
	
}
else if (securityQuestionType == 'Create my own security question'){
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsText'), [('text'): 'Create my own security question', ('value') : securityQuestion], FailureHandling.STOP_ON_FAILURE)
	
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsText'), [('text'): 'Answer', ('value') : securityQuestionAnswer], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AgencyPortal/Dynamic/Input/inputByValue', [('value') : 'Verify']))

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text'): 'Continue'], FailureHandling.STOP_ON_FAILURE)
