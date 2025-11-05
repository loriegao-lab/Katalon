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

//if Location screen is displayed ('x' icon is displayed), close it.
if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Label/aByText', [('text') : 'x']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.click(findTestObject('AgencyPortal/Dynamic/Label/aByText', [('text') : 'x']))
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
}
//navigate to Policy Info screen
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLeftMenuByDataName'), [('dataName') : 'cpPolicyInfo'], FailureHandling.STOP_ON_FAILURE)

//verify 'Other Organization Type' field is not displayed when 'Other' is not selcted for Organization Type
WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Organization Type', ('option') : 'Corporation'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByTextIndex', [('text') : 'Other Organization type']), 1, FailureHandling.STOP_ON_FAILURE)

//verify when 'Other' is selected for 'Organization Type' that the field 'Other Organization Type' is displayed.
WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Organization Type', ('option') : 'Other'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByText', [('text') : 'Other Organization type']), 1, FailureHandling.STOP_ON_FAILURE)

//Enter in 256 characters
WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Other Organization type',
	('value') : 'GklwjakljklajhkjaljhklajnjjankaknlkalknlkaknakuiowgjkwjkljsdksjgjsdjgkjgjlkdjsgjkdjkjslkgjkdjkgjkdsjjgkldswjgjlkdslgjksdjgjslkjgjsklgjksdjjgjdjklsGklwjakljklajhkjaljhklajnjjankaknlkalknlkaknakuiowgjkwjkljsdksjgjsdjgkjgjlkdjsgjkdjkjslkgjkdjkgjkdsjjjhgghytrf'],
 FailureHandling.STOP_ON_FAILURE)

//verify that the length of text in text field is equal to 255. (256 characters were entered but only 255 should be displayed.)

otherOrgTypeValue = WebUI.getAttribute(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'Other Organization type']), 'value')

int expectedLength = 255
//assert otherOrgTypeValue.length() == expectedLength : "Other Organization Type Field Length is as expected"
WebUI.verifyEqual(otherOrgTypeValue.length(), expectedLength, FailureHandling.STOP_ON_FAILURE)