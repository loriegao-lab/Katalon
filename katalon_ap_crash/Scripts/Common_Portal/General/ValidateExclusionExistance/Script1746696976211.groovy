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

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Tab/tabByContainsText', [('text') : 'EXCLUSIONS']), 2, FailureHandling.OPTIONAL))
	{
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTabByContainsText'), [('text') : 'EXCLUSIONS'], FailureHandling.STOP_ON_FAILURE)
	}
	
for (exclusionType in exclusionTypeMap) {
	
	switch (exclusionType.value) {
		
		case 'Required':
			WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h4ByText', [('text') : exclusionType.key]), 1)
			WebUI.verifyElementNotVisible(findTestObject('AgencyPortal/Dynamic/Checkbox/checkboxByTextAfter', [('text') : exclusionType.key]), FailureHandling.STOP_ON_FAILURE)
	
			break
			
		case 'Suggested':
			WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : exclusionType.key]), 1)
			WebUI.verifyElementAttributeValue(findTestObject('Common/Dynamic/Checkbox/checkboxByText', [('text') : exclusionType.key]), 'aria-checked', 'true', 1)
	
			break
			
		case 'Optional':
			WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : exclusionType.key]), 1)
			WebUI.verifyElementAttributeValue(findTestObject('Common/Dynamic/Checkbox/checkboxByText', [('text') : exclusionType.key]), 'aria-checked', 'false', 1)
	
			break
	
		default:
			WebUI.verifyElementNotPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : exclusionType.key]), 1)
			
		}
	
	
}