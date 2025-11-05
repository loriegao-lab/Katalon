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

'Reported by Screen'
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'addReportedByPop'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Reported by', ('option') : 'Automation'], FailureHandling.STOP_ON_FAILURE)

if(line in ['Businessowners']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Relation to insured', ('option') : 'Agent'], FailureHandling.STOP_ON_FAILURE)
	
} else {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Relation to insured', ('option') : 'Injured worker'], FailureHandling.STOP_ON_FAILURE)
	
}


if (line in ['Commercial Auto', 'Crime']) {
	
	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'On-Going Responsibility for Medicals?']), FailureHandling.STOP_ON_FAILURE)

}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Primary Phone', ('value') : '2015551234'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Save & Close'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
