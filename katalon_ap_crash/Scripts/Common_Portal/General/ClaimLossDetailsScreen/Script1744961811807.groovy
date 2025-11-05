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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Loss Details Screen'
WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'INCIDENT DESCRIPTION', ('value') : 'Automation Test'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'LOSS CAUSE', ('option') : 'Animal'], 
    FailureHandling.STOP_ON_FAILURE)

if (line != 'Homeowners') {
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'LOSS LOCATION', ('index') : '1'], 
		FailureHandling.STOP_ON_FAILURE)
}
WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'Address 1']), 1, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'City']), 1, FailureHandling.STOP_ON_FAILURE)

if (claimAdditionalInfo == 'true') {
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('addInjury') : true, ('addContent') : true, ('addVehicles') : true, ('line'): line], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()',('wait'):false], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsTextAbove'), [('title') : 'Are you sure you would like to submit the claim?', ('option') : 'Yes'], FailureHandling.STOP_ON_FAILURE)

