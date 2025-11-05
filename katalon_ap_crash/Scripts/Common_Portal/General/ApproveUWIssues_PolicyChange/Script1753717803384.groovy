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

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'ADD A NOTE TO THE UNDERWRITER (up to 400 characters)']), 30, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ReferToUnderwriterScreen'), [('transactionSubmissionMsg'): 'THIS POLICY CHANGE TRANSACTION HAS BEEN SUBMITTED FOR REVIEW!'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/LoginPC'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/GoToSubmissionBySubmissionNo'), [('submissionNumber') : policyChangeTrxnNum], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/ApproveUWIssues'), [:], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementNotPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Release Loc']), 1, FailureHandling.OPTIONAL)) {
		
		if (WebUI.verifyElementVisible(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Lock for Review']), FailureHandling.OPTIONAL)) {
			
			WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'Lock for Review'], FailureHandling.STOP_ON_FAILURE)
		}	
	}
	
	WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'Release Loc'], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Release']), 1, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'Release'], FailureHandling.STOP_ON_FAILURE)
		
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/LoginPortal'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/SearchPolicy'), [('policyNumber') : policyNumber], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTabByContainsText'), [('text') : 'Transactions'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : policyChangeTrxnNum], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
	
}
