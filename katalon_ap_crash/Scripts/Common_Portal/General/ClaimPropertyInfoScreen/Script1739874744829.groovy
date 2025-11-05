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

'Property Info Screen'
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByHeadingText'), [('heading') : 'Properties', ('btnName') : 'Add'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'Property Location', ('index') : '1'], FailureHandling.STOP_ON_FAILURE)

if (WebUI.getText(findTestObject('AgencyPortal/Dynamic/Span/spanByLabelText', [('text') : 'Property Location'])) == 'New Address') {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Address 1', ('value') : address1], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 3, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Use Original', ('index') : '1'], FailureHandling.STOP_ON_FAILURE)
	
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'State', ('option') : state, ('scroll') : 'top'],FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Use Original', ('index') : '1'], FailureHandling.STOP_ON_FAILURE)
	
	}

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Postal Code', ('value') : zipCode, ('sendTab') : false], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 3, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Use Original', ('index') : '1'], FailureHandling.STOP_ON_FAILURE)
	
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'County', ('value') : county, ('sendTab') : false], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Use Original', ('index') : '2'], FailureHandling.STOP_ON_FAILURE)
	
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'City', ('value') : city], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 3, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Use Original', ('index') : '2'], FailureHandling.STOP_ON_FAILURE)
	
	}
	
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Damage Description', ('value') : 'Automation Test', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 2, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Use Original', ('index') : '1'], FailureHandling.STOP_ON_FAILURE)

}

WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsSpanText', [('text') : 'Show Additional Details']),FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Save & Close', ('wait') : true], FailureHandling.STOP_ON_FAILURE)

if (line in ['Commercial Package', 'Businessowners', 'Commercial Property']) {

	if(WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByJSNgClickText', [('text') : 'nextMain()']), FailureHandling.OPTIONAL)) {
	
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
	}
	
	if(WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Div/divByContainsClass', [('text') : 'alert-warning']), FailureHandling.OPTIONAL)) {
	
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
	}
}
