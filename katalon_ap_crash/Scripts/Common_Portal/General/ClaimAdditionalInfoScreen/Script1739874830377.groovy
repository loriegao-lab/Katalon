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

'Additional Info Screen'

if(addInjury == true) {
	
	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsHeadingAndLabelText', [('heading'): 'Injuries', ('btnName') : 'Add']), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimInjuriesScreen'), [('line') : line], FailureHandling.STOP_ON_FAILURE)
}


if(addProperties == true) {
	
	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsHeadingAndLabelText', [('heading'): 'Properties', ('btnName') : 'Add']), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimPropertyInfoScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
}

if(addContent == true) {
	
	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsHeadingAndLabelText', [('heading'): 'Contents', ('btnName') : 'Add']), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimContentScreen'), [:], FailureHandling.STOP_ON_FAILURE)
}

if(addVehicles == true) {
	
	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsHeadingAndLabelText', [('heading'): 'Vehicles', ('btnName') : 'Add']), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimVehicleScreen'), [('line'): line], FailureHandling.STOP_ON_FAILURE)
}

if(addOfficial == true) {
	
	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsHeadingAndLabelText', [('heading'): 'Officials', ('btnName') : 'Add']), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimOfficalScreen'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()'], FailureHandling.STOP_ON_FAILURE)