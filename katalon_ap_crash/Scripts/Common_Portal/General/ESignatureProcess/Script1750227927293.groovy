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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import encova.GW as GW

eSignDocGenerate = false

// Step 1: Generate Document in PC
// Login PC
WebUI.callTestCase(findTestCase('Common/General/LoginPC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

// Go to Document Admin Page
WebUI.callTestCase(findTestCase('Common/Actions/ClickExpBtnByText'), [('text') : 'dministration'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/Actions/HoverOverByText'), [('text') : 'Utilities'], FailureHandling.STOP_ON_FAILURE) 

if(WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Document Admin Page']), 3, FailureHandling.STOP_ON_FAILURE)) {
	
	WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'Document Admin Page'], FailureHandling.STOP_ON_FAILURE)
	
	// Search Submission
	WebUI.callTestCase(findTestCase('Common/Actions/InputTextBoxValueByText'), [('text') : 'Submission Number', ('value') : submissionNumber], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'earch'], FailureHandling.STOP_ON_FAILURE)
	
	rowCount = WebUI.findWebElements(findTestObject('Common/Dynamic/Table/tableRowCountByTitle', [('title') : 'Documents']), 1, FailureHandling.STOP_ON_FAILURE).size()
	
	println('rowCount >> ' + rowCount)
	
	if(rowCount <= 0) {
		
		KeywordUtil.markFailedAndStop("!!! The $submissionNumber are not being found in PC !!!")
		
	} else {
		
		// Sort 'Uploaded' column as DESC
		WebUI.callTestCase(findTestCase('Common/Actions/ClickTableSortIconByText'), [('text') : 'Uploaded'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common/Actions/ClickTableSortIconByText'), [('text') : 'Uploaded'], FailureHandling.STOP_ON_FAILURE)
		
		// Regenerate Document
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Regenerate', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
		
		if (!WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Regenerate Document Generation XML']), 1, FailureHandling.STOP_ON_FAILURE)) {
			
			KeywordUtil.markFailedAndStop("!!! Regenerate document XML fail in PC!!!")
			
		} else {
			
			for (i = 1; i <= (max_refresh + 1); i++) {
				
				WebUI.delay(10)
				
				WebUI.click(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'pdate']))
				
				WebUI.acceptAlert()
				
				WebUI.callTestCase(findTestCase('Common/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
				
				if(WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'pdate']), 1, FailureHandling.OPTIONAL)) {
					
					WebUI.click(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'pdate']))
					
					WebUI.acceptAlert()
					
					WebUI.callTestCase(findTestCase('Common/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
					
				}
				
				if(WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Div/divByText', [('text') : 'Document Admin Page']), 1, FailureHandling.OPTIONAL)) {
					
					break
					
				} else {
					
					continue
				}
			}
			
			for (i = 1; i <= (max_refresh + 1); i++) {
				
				WebUI.delay(20)
				
				WebUI.callTestCase(findTestCase('Common/Actions/ClickDivByText'), [('text') : 'earch'], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('Common/Actions/ClickTableSortIconByText'), [('text') : 'Uploaded'], FailureHandling.STOP_ON_FAILURE)
		
				WebUI.callTestCase(findTestCase('Common/Actions/ClickTableSortIconByText'), [('text') : 'Uploaded'], FailureHandling.STOP_ON_FAILURE)
				
				if(WebUI.verifyElementPresent(findTestObject('Common/Dynamic/Table/tableBtnByTitleRowColText', [('title') : 'Documents', ('row') : '1', ('col') : '3', ('text') : 'View']), 1, FailureHandling.OPTIONAL)) {
					
					eSignDocGenerate = true
					
					break // View button present, document regeneration success.
					
				} else {
					
					continue
				}
				
			}
			
			if(!eSignDocGenerate) {
				
				KeywordUtil.markFailedAndStop("!!! Regenerate document fail in PC!!!")
				
			} else {
				
				// Step 2: Go to AP to Sign Document
				WebUI.callTestCase(findTestCase('Common_Portal/General/LoginPortal'), [:], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('Common_Portal/General/SearchQuote'), [('submissionNumber') : submissionNumber], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Do you wish to sign all documents using the Encova eSignature process?', ('option') : 'Yes'], FailureHandling.STOP_ON_FAILURE)
				
				if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Encova eSignature Details']), FailureHandling.STOP_ON_FAILURE)) {
					
					WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByIndex'), [('text') : 'SIGNING POLICYHOLDER', ('index') : '1'],
						FailureHandling.STOP_ON_FAILURE)
					
					timestamp = GW.getFEIN()
					policyHolderEmail = 'encovaqa+' + timestamp + '@gmail.com'
					
					WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'POLICYHOLDER EMAIL', ('value') : policyHolderEmail], FailureHandling.STOP_ON_FAILURE)
					
					WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'save'], FailureHandling.STOP_ON_FAILURE)
					
				}
			}
			
		}
		
	}
	
}




