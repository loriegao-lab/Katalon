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

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByHeadingText'), [('heading') : 'Injuries', ('btnName') : 'Add'], FailureHandling.STOP_ON_FAILURE)

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByLabelText', [('text') : 'driver passenger or pedestrain']), 3, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'driver passenger or pedestrain', ('option') : 'driver'], FailureHandling.STOP_ON_FAILURE)
	
	if(line == 'Commercial Auto') {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'vehicle', ('index') : '1'], FailureHandling.STOP_ON_FAILURE)
		
	} else {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'vehicle', ('index') : '1'], FailureHandling.STOP_ON_FAILURE)
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Phone Type', ('option') : 'Mobile', ('scroll') : 'top'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Primary Phone', ('value') : '214-920-0912', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)
}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByLabelContainsText', [('text') : 'injured person']), 3, FailureHandling.STOP_ON_FAILURE)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'injured person', ('option') : 'Automation'], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'injury description', ('value') : 'Automation Test', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)

if (line != 'Personal Auto' | line != 'Homeowners') {
	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsSpanText', [('text') : 'Show Additional Details']),
	FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Icon/arrowIconByClassAndTextAfter', [('text') : 'Show Additional Details', ('classText') : 'down']), FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanByContainsText'), [('text') : 'Show Additional Details'], FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'On-Going Responsibility for Medicals?']), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Save & Close'], FailureHandling.OPTIONAL)