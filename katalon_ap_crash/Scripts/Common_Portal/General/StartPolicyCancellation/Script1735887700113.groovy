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
import encova.GW as GW

if (termType == 'Full') {
	
	WebUI.callTestCase(findTestCase('Common/General/LoginPC'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/GoToPolicyByCaseID'), [('caseID') : caseID], FailureHandling.STOP_ON_FAILURE)
	
	effectiveDate = WebUI.callTestCase(findTestCase('Common/General/GetPolicyTermEffectiveDate'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/LoginPortal'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
	
	effectiveDate = GW.getPolicyDate(effectiveDate)
}

WebUI.callTestCase(findTestCase('Common_Portal/General/GoToPolicyByCaseID'), [('caseID') : caseID], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByContainsText'), [('text') : 'Cancel Policy'], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Link/linkByContainsText', [('text') : 'Cancel Policy']), 1, FailureHandling.OPTIONAL)) {
	
	// WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkCancelPolicy'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByJSNgClick'), [('text') : 'createcancellation'], FailureHandling.STOP_ON_FAILURE)
	
}else {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByContainsText'), [('text') : 'Cancel Policy'], FailureHandling.STOP_ON_FAILURE)
		
}

if (policyType in ['Personal Auto']) {
	
	//for case AP.e.05_config_S9_Any state_PA_TC004
	WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/smallByContainsText', [('text') : policyType]), 5, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Label/pByText', [('text') : 'Required field ']), 1, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : policyType]), 1, FailureHandling.STOP_ON_FAILURE)
	
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Reason For Cancellation', ('option') : reason],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClearAndInputTextBoxValueByText'), [('text') : 'Description', ('value') : 'Automation Test'],
	FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'Cancellation Effective Date']), 1, FailureHandling.OPTIONAL)) {
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClearAndInputTextBoxValueByText'), [('text') : 'Cancellation Effective Date', ('value') : effectiveDate], 
        FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByTextAfter'), [('text') : 'I have obtained a signed cancellation request or a lost policy release for this cancellation ',('scroll'):'middle'],
	FailureHandling.STOP_ON_FAILURE)


WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : cancelType], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Link/linkByText', [('text') : 'Acknowledge and Continue']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : 'Acknowledge and Continue'], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCloseBtn'), [('text') : 'Close'], FailureHandling.STOP_ON_FAILURE)

