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
import encova.GW as GW

WebUI.callTestCase(findTestCase('Common_Portal/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsText', [('text') : 'Start a Quote']), 3, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Start a Quote'], FailureHandling.STOP_ON_FAILURE)

}

WebUI.waitForElementVisible(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'Effective Date']), 10)

//WebUI.callTestCase(findTestCase('Common/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Need Help Deciding?']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickXLink'), [:], FailureHandling.STOP_ON_FAILURE)
}

if (effectiveDate != '') {
	
effectiveDate = GW.getPolicyDate(effectiveDate)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Effective Date', ('value') : effectiveDate], 
    FailureHandling.STOP_ON_FAILURE)

}

if (lob != '') {

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickDivByContainsText_Middle'), [('text') : lob], FailureHandling.STOP_ON_FAILURE)
	
}

if (businessType != '' ) {
	
	if (businessType in ['General Liability','Commercial Property','Commercial Auto']) {
	
	
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickDivByContainsTextIndex'), [('text') : businessType, ('index') : 'last()',('scroll'):'false'], FailureHandling.STOP_ON_FAILURE)
	}
	
	else {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickDivByContainsTextIndex'), [('text') : businessType, ('index') : 'last()',('scroll'):'top'], FailureHandling.STOP_ON_FAILURE)
		
	}
}


if (additionalLOB != '') {
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickDivByContainsText'), [('text') : additionalLOB, ('scroll') : 'middle'],
		FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)

if (lob == 'Business Owners Policy (BOP)') {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Is this a physical Location for the business?', ('option') : 'Yes'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Business Type', ('option') : subBusinessType],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'next'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Continue'], FailureHandling.STOP_ON_FAILURE)
	
	if (clickNext) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
		
	}
	
}
