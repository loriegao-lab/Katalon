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

'Get Claim Number'
claimText = ('| ' + line + ' Claim')

WebUI.delay(10)
	
claimNumText = WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Div/divByContainsText', [('text') : claimText]),
	1, FailureHandling.STOP_ON_FAILURE).getText()

claimNum = claimNumText.substring(6, 19)

'Get Policy Number'
policyText = ('| Policy ')

policyText = WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Div/divByContainsText', [('text') : policyText]),1, FailureHandling.STOP_ON_FAILURE).getText()

policyNum = policyText.split(' ').last()

'Policy Level Check'
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByHeadingText'), [('heading') : 'Helpful Links', ('text') : 'View Policy Details', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Div/divByText'), 3, FailureHandling.OPTIONAL)) {
}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Close']), 3, FailureHandling.OPTIONAL)) {


	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Close'], FailureHandling.STOP_ON_FAILURE)
}

'Account Level Check'

if(!phPortalLogin) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTabByContainsText'), [('text') : 'Claims'], FailureHandling.STOP_ON_FAILURE)
	
	if(WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Link/linkByText', [('text') : claimNum]), FailureHandling.STOP_ON_FAILURE)) {
	
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : claimNum, ('wait') : true], FailureHandling.STOP_ON_FAILURE)
	}
	
}

WebUI.scrollToElement(findTestObject('AgencyPortal/Dynamic/Label/aByTextAndIndex', [('text') :'View Account Details', ('index'): '2']), 3)

WebUI.delay(4)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByHeadingText'), [('heading') : 'Helpful Links', ('text') : 'View Account Details', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTabByContainsText'), [('text') : 'Claims'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Link/linkByText', [('text') : claimNum]), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : claimNum, ('wait') : true], FailureHandling.STOP_ON_FAILURE)