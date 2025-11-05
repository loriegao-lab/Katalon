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

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanByText'), [('text') : 'Search'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Search by keyword', ('value') : accountNumber, ('wait') : true], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextBefore'), [('text') : 'Search by keyword', ('wait') : true], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextBefore'), [('text') : 'Search by keyword', ('wait') : true], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Search by keyword', ('value') : accountNumber, ('wait') : true], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextBefore'), [('text') : 'Search by keyword', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanByText'), [('text') : 'Accounts'], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementAttributeValue(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'Search by keyword']), 'aria-expanded', 'true', 2, FailureHandling.OPTIONAL)) {
	
	// Input text expand
	println('>>>Input Account Expanded>>>...')
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanOptionByText'), [('text') : 'Accounts'], FailureHandling.STOP_ON_FAILURE)
	
} 

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickHeadingByText'), [('headingType') : 'h1', ('text') : 'Search'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'View Account', ('wait') : true], FailureHandling.STOP_ON_FAILURE)

