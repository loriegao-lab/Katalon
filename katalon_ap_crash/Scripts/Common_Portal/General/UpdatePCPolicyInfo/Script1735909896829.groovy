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

WebUI.callTestCase(findTestCase('Common/General/LoginPC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/General/GoToSubmissionBySubmissionNo'), [('submissionNumber') : submissionNumber], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/General/GoToScreen'), [('screenTitle') : 'Policy Info'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/Actions/SelectDropDownLabelByText'), [('text') : 'Transaction Quoting Status'
	, ('value') : 'SBU Review'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/Actions/InputTextBoxValueByText'), [('text') : 'SIC Code', ('value') : sICCode],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/Actions/InputTextBoxValueByText'), [('text') : 'NAICS Code', ('value') : nAICSCode],
	FailureHandling.STOP_ON_FAILURE)

if (addCoverage) {
	WebUI.callTestCase(findTestCase('Common/General/GoToScreen'), [('screenTitle') : 'Coverages'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/SearchSelectCoverages'), [('searchCoverage') : addCoverage], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/Actions/InputTextBoxValueByText'), [('text') : 'Number of Tanks', ('value') : '1000'],
		FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'ave Draft'], FailureHandling.STOP_ON_FAILURE)
	
WebUI.callTestCase(findTestCase('Common_Portal/General/LoginPortal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/General/SearchQuote'), [('submissionNumber') : submissionNumber], FailureHandling.STOP_ON_FAILURE)
