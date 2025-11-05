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

'Incident Details Screen'
WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'Incident Location', ('index') : '1'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'Address 1']), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'City']), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Incident Description'
        , ('value') : 'Automation Test', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)

if (line in ['Crime']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Loss Cause', ('option') : 'Fraud'],
		FailureHandling.STOP_ON_FAILURE)
	
	}else if (line in ['Commercial Umbrella']) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Loss Cause', ('option') : 'Umbrella'],
			FailureHandling.STOP_ON_FAILURE)
		
		}else if (line in ['General Liability']) {
		
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Loss Cause', ('option') : 'Animal bite/scratch'],
				FailureHandling.STOP_ON_FAILURE)
		
			} else {
				WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Loss Cause', ('option') : 'Animal'],
					FailureHandling.STOP_ON_FAILURE)
}

if (line in ['Businessowners']) {
    if (lossType == 'Liability') {
        WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Select how you would like the claim to be categorized:']), 
            1, FailureHandling.STOP_ON_FAILURE)
    } else if (lossType == 'Property') {
        WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Select how you would like the claim to be categorized:']), 
            FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Category', ('option') : 'Contents Only'
                , ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)
    }
}

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Label/labelByText', [('text') : 'Category']), 1, FailureHandling.OPTIONAL)) {
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Category', ('option') : 'Contents Only'
		, ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsSpanText', [('text') : 'Show Additional Details']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()'], FailureHandling.STOP_ON_FAILURE)