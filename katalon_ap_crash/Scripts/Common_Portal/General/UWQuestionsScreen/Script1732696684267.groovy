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

level1_lob = ['PA', 'HO3', 'HO4', 'HO6', 'HO5', 'DP3', 'DP1', 'PU', 'BOP', 'Commercial Auto', 'Inland Marine', 'Crime','Encova', 'NNO']
level2_lob = ['General Liability', 'Commercial Package']
current_lob = WebUI.getText(findTestObject('AgencyPortal/General/h5_lob')).split('[ – | - ]')[0].trim()

println(current_lob)

//println current_lob

println('>current_lob: ' + current_lob)

//System.out.println('>>>>>>current_lob: ' + current_lob)

if (current_lob in level1_lob) {
	
	questions_count = WebUI.findWebElements(findTestObject('AgencyPortal/Dynamic/RadioButton/radioCountByOption', [('option') : option]), 2).size()
	
	for (i = 1; i <= questions_count; i++) {
		
		option_text = WebUI.getText(findTestObject('AgencyPortal/Dynamic/RadioButton/radioTextByIndex', [('index') : i])).trim()
		
		switch (option_text) {
			case 'Does the named insured(s) on the policy have at least 3 years of U.S. driving experience?':
			case 'Is the applicant’s primary residence within 60 miles from an agency office location?':
				option = 'Yes'
				break
			default:
				option = 'No'
		}
		
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByOptionIndex'), [('option') : option, ('index') : i], FailureHandling.STOP_ON_FAILURE)
			
	}
	
	input_count = WebUI.findWebElements(findTestObject('AgencyPortal/Dynamic/Input/inputCount'), 2).size()
	
	for (i = 1; i <= input_count; i++) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('index') : i, ('value') : 'Test Automation', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
		
	}
	
	checkbox_count = WebUI.findWebElements(findTestObject('Common/Dynamic/Table/tableCheckboxCount', [:]), 2).size()
	
	for (i = 1; i <= checkbox_count; i++) {
		
		WebUI.callTestCase(findTestCase('Common/Actions/ClickTableCheckboxByIndex'), [('index') : i], FailureHandling.STOP_ON_FAILURE)

	}
		
} else {
	
	tab_count = WebUI.findWebElements(findTestObject('Common/Dynamic/Tab/tabCountByTitle', [('title') : 'Underwriting Questions']), 2).size()
	
	for (j = 1; j <= tab_count; j++) {
		
		WebUI.callTestCase(findTestCase('Common/Actions/ClickTabByTitleIndex'), [('title') : 'Underwriting Questions', ('index') : j], FailureHandling.STOP_ON_FAILURE)
		
		layer_count = WebUI.findWebElements(findTestObject('Common/Dynamic/Layer/layerCountByTitle', [('title') : 'Underwriting Questions']), 2).size()
		
		deepLayer_tab_count = 1
		
		if (layer_count > 2) {
			
			deepLayer_tab_count = WebUI.findWebElements(findTestObject('Common/Dynamic/Tab/tabCountByTitleLayer', [('title') : 'Underwriting Questions', ('layer') : '3']), 2).size()
			
			println('>deepLayer_tab_count: ' + deepLayer_tab_count)
			
		}
		
		for (k = 1; k <= deepLayer_tab_count; k++) {
			
			if (k != 1) {
				
				WebUI.callTestCase(findTestCase('Common/Actions/ClickTabByTitleLayerIndex'), [('title') : 'Underwriting Questions', ('layer') : 'last()', ('index') : k], FailureHandling.STOP_ON_FAILURE)
				
			}
			
			questions_count = WebUI.findWebElements(findTestObject('Common/Dynamic/Table/tableOptionCountByOption', [('option') : option]), 2).size()
			
			for (i = 1; i <= questions_count; i++) {
				
				WebUI.callTestCase(findTestCase('Common/Actions/ClickTableOptionByOptionIndex'), [('option') : option, ('index') : i], FailureHandling.STOP_ON_FAILURE)
		
			}
			
			if (questions_count != 0) {
				
				WebUI.callTestCase(findTestCase('Common/Actions/ClickBtnByText'), [('text') : 'Review'], FailureHandling.STOP_ON_FAILURE)
				
				input_count = WebUI.findWebElements(findTestObject('Common/Dynamic/Table/tableInputCount'), 2).size()
				
				for (i = 1; i <= input_count; i++) {
					
					input_text = WebUI.getText(findTestObject('Common/Dynamic/Table/tableInputTextByIndex', [('index') : i]))
					
					switch (input_text) {
						case 'Date Business Established':
							input_value = '01/01/2020'
							break
						case 'Total Revenue/Sales':
						case 'Sales over Internet':
							input_value = '500000'
							break
						case 'Number of Full-Time Employees':
						case 'Number of Part-Time Employees':
							input_value = '30'
							break
						default:
							input_value = 'Test Automation'
					}
					
					WebUI.callTestCase(findTestCase('Common/Actions/InputTableTextBoxValueByIndex'), [('index') : i, ('value') : input_value], FailureHandling.STOP_ON_FAILURE)
			
				}
				
				dropdown_count = WebUI.findWebElements(findTestObject('Common/Dynamic/Table/tableDropdownCount'), 2).size()
				
				for (i = 1; i <= dropdown_count; i++) {
					
					WebUI.callTestCase(findTestCase('Common/Actions/SelectTableDropdownIndexByIndex'), [('index1') : i, ('index2') : 1], FailureHandling.STOP_ON_FAILURE)
			
				}
				
			}
				
		}
			
	}
	
}
WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Finalize Quote', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
//if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsText', [('text') : 'Finalize Quote']), 2, FailureHandling.OPTIONAL)) {
//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Finalize Quote'], FailureHandling.OPTIONAL)}

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Link/linkByText', [('text') : 'Acknowledge and Continue']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : 'Acknowledge and Continue'], FailureHandling.STOP_ON_FAILURE)
	
}
