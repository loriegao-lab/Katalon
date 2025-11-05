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

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'ADD A NOTE TO THE UNDERWRITER (up to 400 characters)']), 10, FailureHandling.OPTIONAL)) {
	
	if(validateUWIssues) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ValidateUWIssues'), [('uwIssuesMap') : uwIssuesMap], FailureHandling.STOP_ON_FAILURE)
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ReferToUnderwriterScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/LoginPC'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/GoToSubmissionBySubmissionNo'), [('submissionNumber') : submissionNumber], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/GoToScreen'), [('screenTitle') : 'Risk Analysis'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/ApproveUWIssues'), [:], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementNotPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Release Loc']), 1, FailureHandling.OPTIONAL)) {
		
		if (WebUI.verifyElementVisible(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Lock for Review']), FailureHandling.STOP_ON_FAILURE)) {
			
			WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'Lock for Review'], FailureHandling.STOP_ON_FAILURE)
		}
		
		
	}
	
	WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'Release Loc'], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Release']), 1, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'Release'], FailureHandling.STOP_ON_FAILURE)
		
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/LoginPortal'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/SearchQuote'), [('submissionNumber') : submissionNumber], FailureHandling.STOP_ON_FAILURE)
	
}

if (line in ['Commercial Auto']) {
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Pay & Issue'], FailureHandling.STOP_ON_FAILURE)

}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/headingByText', [('text') : 'Quote Summary']), 3, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Next'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Finalize Quote', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
	
}

	
if (quotePolicy == 'No') {
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/FinalizeQuoteScreen'), [('line') : line, ('paymentDueDate') : paymentDueDate, ('paymentMethod') : paymentMethod],
		FailureHandling.STOP_ON_FAILURE)

	if (line in ['Personal Auto', 'Homeowners', 'Personal Umbrella']) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : submissionNumber], FailureHandling.STOP_ON_FAILURE)
		
		policyNumber = (WebUI.getText(findTestObject('AgencyPortal/General/h1_PolicyNo')).split(' ')[1]).trim()
		
	} else if (line in ['Businessowners', 'Commercial Auto', 'General Liability', 'Commercial Property', 'Crime', 'Inland Marine', 'Commercial Package']) {
		
		policyNumber = (WebUI.getText(findTestObject('AgencyPortal/General/p_PolicyNo')).split(' ')[-1]).trim()
	}
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/General/a_Close'),2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickXButton'), [:], FailureHandling.STOP_ON_FAILURE)}
		
	return policyNumber
	
}
	