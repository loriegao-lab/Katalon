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

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Incident Description', ('value') : 'Test Automation'],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Loss Cause', ('option') : 'Animal'],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'Incident Location', ('index') : '1'],
	FailureHandling.STOP_ON_FAILURE)

if (WebUI.getText(findTestObject('AgencyPortal/Dynamic/Span/spanByLabelText', [('text') : 'Incident Location'])) == 'New Location') {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Address 1', ('value') : address1], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Postal Code', ('value') : zipCode], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'City', ('value') : city], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'State', ('option') : state, ('scroll') : 'top'],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'County', ('value') : county], FailureHandling.STOP_ON_FAILURE)
	
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()'], FailureHandling.STOP_ON_FAILURE)