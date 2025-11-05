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

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Tab/tabByContainsText', [('text') : 'CONDITIONS']), 2, FailureHandling.OPTIONAL))
    { 
        WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTabByContainsText'), [('text') : 'CONDITIONS', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)
    }

for (def condition : conditionList) {
	
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Add Conditions', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(3)
	
	if(WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'Search by Keyword']), 1, FailureHandling.OPTIONAL)) {
		
	} else {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Search by Keyword', ('value') : condition],
			FailureHandling.STOP_ON_FAILURE)
	
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSearchIconByTextBefore'), [('text') : 'Search by Keyword'
				, ('wait') : true], FailureHandling.STOP_ON_FAILURE)
		
	}

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByTextAfter'), [('text') : condition], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Save & Close', ('index') : 'last()'], FailureHandling.STOP_ON_FAILURE)
   
}