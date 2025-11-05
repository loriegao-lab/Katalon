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

'Basic Claim Info Screen'
if (lossType == 'Property') {
	
	if (WebUI.verifyElementAttributeValue(findTestObject('AgencyPortal/Dynamic/RadioButton/radioGroupByText', [('text') : 'Property']), 'aria-checked', 'false', 1, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioBeforeText'), [('text') : 'Property'], FailureHandling.STOP_ON_FAILURE)
		
	}
	
} else if (lossType == 'Liability') {
	
	if (WebUI.verifyElementAttributeValue(findTestObject('AgencyPortal/Dynamic/RadioButton/radioGroupByText', [('text') : 'Liability']), 'aria-checked', 'false', 1, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioBeforeText'), [('text') : 'Liability'], FailureHandling.STOP_ON_FAILURE)
		
	}
} else if (lossType == 'NoLossType') {
	
	if (line in ['Commercial Package']) {

		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'Line of Business', ('index') : index], FailureHandling.STOP_ON_FAILURE)
		
	}
	
}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/headingByText', [('text') : 'Involved Policy Location.']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByIndex'), [('index') : '1'], FailureHandling.STOP_ON_FAILURE)
	
}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Involved Policy Location']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxUnderSection'), [('text') : 'Involved Policy Location'], FailureHandling.STOP_ON_FAILURE)
}

//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnSpanByContainsText'), [('text') : 'Next'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()'], FailureHandling.STOP_ON_FAILURE)

if(WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Div/divByContainsClass', [('text') : 'alert-warning']), FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()'], FailureHandling.STOP_ON_FAILURE)
}
