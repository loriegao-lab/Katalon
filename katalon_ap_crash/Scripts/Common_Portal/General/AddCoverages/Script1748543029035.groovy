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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTabByContainsText'), [('text') : 'COVERAGES', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)

for (def coverage : coverageList) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Add'],
		FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByTextAfter'), [('text') : coverage], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByTextAndIndex'), [('text') : 'Save & Close', ('index') : 'last()'], FailureHandling.STOP_ON_FAILURE)
	
	switch(coverage) {
		case 'Blanket Coverage':
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Description', ('value') : 'Test'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Per Item limit', ('value') : '100000', ('wait') : true],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Any One Occurrence Limit', ('value') : '100000'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Deductible', ('option') : '1,000'],
			FailureHandling.STOP_ON_FAILURE)
		
		break
		
		case 'Machinery and Equipment Blanket Coverage':
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Description', ('value') : 'Test'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Risk Factor', ('option') : 'Low'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Per Item limit', ('value') : '100000', ('wait') : true],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Any One Occurrence Limit', ('value') : '100000'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByContainsText'), [('text') : 'Deductible', ('option') : '1,000'],
			FailureHandling.STOP_ON_FAILURE)
		break
		
		case 'Property In Transit':
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Limit', ('value') : '100000'],
			FailureHandling.STOP_ON_FAILURE)
		
		break
		
		case 'Property At Any One Unnamed Location':
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Limit', ('value') : '100000'],
			FailureHandling.STOP_ON_FAILURE)
		
		break
		
		case 'Property At Unnamed Processors':
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Limits of Insurance', ('value') : '100000'],
			FailureHandling.STOP_ON_FAILURE)
		
		break
		
		case 'Transportation For Hire  (Golf Cart Dealers Stock Floater - North Carolina)':

		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByHeadingAndText'), [('heading') : coverage, ('text') : 'Limit', ('option') : '100000'],
			FailureHandling.STOP_ON_FAILURE)		
		break
		
		case "Employee's Tools  (Golf Cart Dealers Stock Floater - North Carolina)":
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsCovAndText'), [('cov') : coverage, ('text') : 'Limit', ('value') : '100000'], FailureHandling.STOP_ON_FAILURE)

		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByHeadingAndText'), [('heading') : coverage, ('text') : 'Deductible', ('option') : '100'],
			FailureHandling.STOP_ON_FAILURE)
		break
		
		case 'False Pretense  (Golf Cart Dealers Stock Floater - North Carolina)':
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsCovAndText'), [('cov') : coverage, ('text') : 'Limit', ('value') : '100000'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Exclude False Pretense For Rented Equipment?', ('option') : 'No', ('middle') : true], FailureHandling.STOP_ON_FAILURE)
		
		break
		
		case 'Transportation For Hire  (Golf Cart Dealers Stock Floater - Maryland)':
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByHeadingAndText'), [('heading') : coverage, ('text') : 'Limit', ('option') : '100000'],
			FailureHandling.STOP_ON_FAILURE)
		break
		
		case "Employee's Tools  (Golf Cart Dealers Stock Floater - Maryland)":
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsCovAndText'), [('cov') : coverage, ('text') : 'Limit', ('value') : '100000'], FailureHandling.STOP_ON_FAILURE)

		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByHeadingAndText'), [('heading') : coverage, ('text') : 'Deductible', ('option') : '100'],
			FailureHandling.STOP_ON_FAILURE)
		break
		
		case 'False Pretense  (Golf Cart Dealers Stock Floater Coverage Form - Maryland)':
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsCovAndText'), [('cov') : coverage, ('text') : 'Limit', ('value') : '100000'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Exclude False Pretense For Rented Equipment?', ('option') : 'No', ('middle') : true], FailureHandling.STOP_ON_FAILURE)
		
		break
	}
}
