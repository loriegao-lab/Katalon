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

//level1_lob = ['HO3']
//level2_lob = ['PA']
//current_lob = WebUI.getText(findTestObject('AgencyPortal/General/h5_lob')).split('[ – | - ]')[0].trim()
//
////Basic info page

//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
//
//if (current_lob in level1_lob) {WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanByText'), [('text') : 'Quote'], FailureHandling.STOP_ON_FAILURE)}
//
//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
//
//if (current_lob in level2_lob) {
//
//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
//
//}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByContainsText', [('text') : 'Loss History']),2, FailureHandling.OPTIONAL)) {
	
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanByContainsText'), [('text') : 'Loss History', ('wait') : false], FailureHandling.OPTIONAL)}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Label/pByText', [('text') : 'This will invalidate the current quote and may require re-approval by underwriting. Are you sure you want to continue?']), 1, FailureHandling.OPTIONAL)) {
	
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text'): 'OK', ('wait') : false], FailureHandling.OPTIONAL)}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/General/btn_Next', [:]), 1, FailureHandling.OPTIONAL)) {
	
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [('wait') : 8, ('scroll') : 'middle', ('waitForRefresh') : true], FailureHandling.STOP_ON_FAILURE)

}

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/headingByText', [('text') : 'Review Policy Changes']), 1, FailureHandling.OPTIONAL)) {

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text'): 'Next', ('wait') : false], FailureHandling.OPTIONAL)
	
	oosNotification = 'One or more policy changes have been processed for this coverage with a later effective date. Do you want this change to apply from this policy change effective date through the end of the term? If you do not, this will not apply to transactions which have already been processed with a future effective date.'
	
	if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Paragraph/paraByContainsText', [('text') : oosNotification]), 2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Yes', ('index') : 'last()'], FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
	}
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Link/linkByText', [('text') : 'Acknowledge and Continue']), 2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : 'Acknowledge and Continue'], FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Yes', ('index') : 'last()'], FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
	}
}

WebUI.callTestCase(findTestCase('Common_Portal/General/ApproveUWIssues_PolicyChange'), [('policyChangeTrxnNum'): policyChangeTrxnNum, ('policyNumber') : policyNumber], FailureHandling.STOP_ON_FAILURE)


if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/headingByText', [('text') : 'Policy Change Summary']), 1, FailureHandling.OPTIONAL)) {
	
    if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Continue']), 3, FailureHandling.OPTIONAL)) {
		
        WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Continue', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
		
    } else if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/General/btn_Next', [:]), 3, FailureHandling.OPTIONAL)) {
		
        WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
		
    } else {
		
        WebUI.comment('Neither "Continue" nor "Next" button was found.')
		
    }
}

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/headingByText', [('text') : 'Supplemental Info']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/LOB/GL/SupplementaryInfoScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
} 

WebUI.callTestCase(findTestCase('Common_Portal/General/ApproveUWIssues_PolicyChange'), [('policyChangeTrxnNum'): policyChangeTrxnNum, ('policyNumber') : policyNumber], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/headingByText', [('text') : 'Policy Change Summary']), 1, FailureHandling.OPTIONAL)) {
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Continue']), 3, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Continue', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
		
	} else if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/General/btn_Next', [:]), 3, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
		
	} else {
		
		WebUI.comment('Neither "Continue" nor "Next" button was found.')
		
	}
}

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsText', [('text') : 'Finalize Quote']), 1, FailureHandling.OPTIONAL)) {
	
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Finalize Quote'], FailureHandling.STOP_ON_FAILURE)
	
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Issue Change'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h2ByText', [('text') : 'Your policy change has been issued.']), 5,
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickXButton'), [:], FailureHandling.STOP_ON_FAILURE)