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

if (line in ['Crime', 'Inland Marine', 'Commercial Umbrella']) {
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByHeadingText'), [('heading') : 'Vehicles', ('btnName') : 'Add'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'Style', ('index') : '1', ('scroll') : 'top'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Loss Party', ('option') : "Insured's loss", ('scroll') : 'top'],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Was the vehicle parked?', ('option') : "No"],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'First Name', ('value') : 'Automation Test'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Last Name', ('value') : 'Test'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Is the driver listed in policy?', ('option') : "Yes"],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'Reason For Use', ('index') : '1', ('scroll') : 'top'], FailureHandling.STOP_ON_FAILURE)
	
//	WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Label/labelByClassNameText', [('label') : "Driver's Relation to Owner", ('className') : 'required']), 1, FailureHandling.OPTIONAL)
//	
//	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : "Driver's Relation to Owner", ('index') : '1'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Save & Close'], FailureHandling.STOP_ON_FAILURE)
	
} else if (line in ['Businessowners']) {
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByHeadingText'), [('heading') : 'Vehicles', ('btnName') : 'Add'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Loss Party', ('option') : "Insured's loss", ('scroll') : 'top', ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Style', ('option') : "Passenger car", ('scroll') : 'middle', ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Was the vehicle parked?', ('option') : "No", ('scroll') : 'middle'],
		FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'First Name', ('value') : 'Automation Test'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Last Name', ('value') : 'Test'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Is the driver listed in policy?', ('option') : "Yes", ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Save & Close'], FailureHandling.STOP_ON_FAILURE)
	
	
} else if (line in ['Commercial Auto']){
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimNonPolicyVehicle'), [:], FailureHandling.OPTIONAL)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByRowH5TextAfter'), [('label'):'Damage Details', ('text'): 'Add'], FailureHandling.OPTIONAL)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Damage Description', ('value') : 'Test Automation'],
		FailureHandling.OPTIONAL)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Save & Close'], FailureHandling.OPTIONAL)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimInvolvedPolicyVehicle'), [:], FailureHandling.OPTIONAL)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()'], FailureHandling.STOP_ON_FAILURE)
	
}  else if(line in ['General Liability']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByHeadingText'), [('heading') : 'Vehicles', ('btnName') : 'Add'], FailureHandling.STOP_ON_FAILURE)
	
	if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByLabelText', [('text') : 'Style']), 2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'Style', ('index') : '1', ('scroll') : 'top'], FailureHandling.STOP_ON_FAILURE)
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Loss Party', ('option') : "Insured's loss", ('scroll') : 'top'],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Was the vehicle parked?', ('option') : "No", ('scroll') : 'middle'],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'First Name', ('value') : 'Automation Test'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Last Name', ('value') : 'Test'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Is the driver listed in policy?', ('option') : "Yes", ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Save & Close'], FailureHandling.STOP_ON_FAILURE)
	
} else if(line in ['Commercial Property']) {
	
} else if (line in ['Homeowners']) {
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByHeadingText'), [('heading') : 'Vehicles', ('btnName') : 'Add'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Loss Party', ('option') : "Insured's loss", ('scroll') : 'top', ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Style', ('option') : "Passenger car", ('scroll') : 'middle', ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Was the vehicle parked?', ('option') : "No", ('scroll') : 'middle'],
		FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Is the driver listed in policy?', ('option') : "Yes", ('scroll') : 'middle'],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Driver Name', ('option') : "Automation", ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Home Phone', ('value') : '214-920-0912', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Reason For Use', ('option') : "Pleasure", ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Relation To Owner', ('option') : "Employee", ('wait') : true],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Save & Close'], FailureHandling.STOP_ON_FAILURE)
}
