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
import com.kms.katalon.core.util.KeywordUtil

screenCount = 0
editBusinessownersLine = false
editLineExclusion = false
editLocations = false
editBuildings = false
editDwelDetailCov = false

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/General/a_Close'),2, FailureHandling.OPTIONAL)) {

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickXButton'), [:], FailureHandling.STOP_ON_FAILURE)
		
}

if (termType == 'Full') {
	
	WebUI.callTestCase(findTestCase('Common/General/LoginPC'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common/General/GoToPolicyByCaseID'), [('caseID') : caseID], FailureHandling.STOP_ON_FAILURE)
	
    effectiveDate = WebUI.callTestCase(findTestCase('Common/General/GetPolicyTermEffectiveDate'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/LoginPortal'), [:], FailureHandling.STOP_ON_FAILURE)
	
} else {
	
    effectiveDate = GW.getPolicyDate(effectiveDate)
}

WebUI.callTestCase(findTestCase('Common_Portal/General/GoToPolicyByCaseID'), [('caseID') : caseID], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByContainsText'), [('text') : 'Change Policy'], FailureHandling.STOP_ON_FAILURE)

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h2ByText', [('text') : 'Open Policy Change Already Exists']), 2, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Delete and Start New', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClearAndInputTextBoxValueByText'), [('text') : 'Change Effective Date', ('value') : effectiveDate, ('wait'):true], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsText'), [('text') : 'POLICY CHANGE DESCRIPTION', ('value') : 'Test Automation'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Next', ('wait') : true], FailureHandling.STOP_ON_FAILURE)

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Paragraph/paraByContainsText', [('text') : 'This out of sequence change will supercede any previous policy change. Do you want to continue?']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByClassAndText'), [('text') : 'OK'], FailureHandling.STOP_ON_FAILURE)
}

// Start Edit Policy Change based on different lines
policyChangeTrxnNum = WebUI.getText(findTestObject('AgencyPortal/General/div_SubNo'))

wizardStepsCount = WebUI.findWebElements(findTestObject('AgencyPortal/Dynamic/List/listItems'), 2, FailureHandling.STOP_ON_FAILURE).size()

switch(line) {
	
	case 'Umbrella':
		
		screenCount = wizardStepsCount - 2 // Exclude 'Supplement Info', 'Issue 'Change'
		
		println('screenCount >> ' + screenCount)
		
		WebUI.callTestCase(findTestCase('Common_Portal/LOB/CU/EditPolicyChangeScreens'), [('screenNextCount') : screenCount], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Finalize Quote'], FailureHandling.STOP_ON_FAILURE)
		
		break
		
	case 'Businessowners':
	
		screenCount = wizardStepsCount - 2 // Exclude 'Quote Summary', 'Issue 'Change'	
		
		println('screenCount >> ' + screenCount)
		
		if(lineCov.size() > 0 || lineAddCov.size() > 0  || lineAddExculsion.size() > 0) {
			
			editBusinessownersLine = true
		}
		
		if(locationAddCov.size() > 0) {
			
			editLocations = true
		}
		
		if(buildingAddCov.size() > 0 || buildingAddCond.size() > 0 || classificationAddCov.size() > 0) {
			
			editBuildings = true
		}
		
		WebUI.callTestCase(findTestCase('null'), [('screenNextCount') : screenCount, ('editBusinessownersLine') : editBusinessownersLine,
			 ('lineCov') : lineCov, ('lineAddCov') : lineAddCov, ('lineAddExculsion') : lineAddExculsion, ('editLocations') : editLocations, ('locationAddCov') : locationAddCov, ('editBuildings') : editBuildings, 
			 ('buildingAddCov') : buildingAddCov, ('buildingAddCond') : buildingAddCond, ('classificationAddCov') : classificationAddCov], FailureHandling.STOP_ON_FAILURE)
		
		if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsText', [('text') : 'Continue']), 1, FailureHandling.OPTIONAL)) {
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Continue', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
		}
		
		break
		
	case 'Package':
		
		screenCount = 5 // Initiate next count pages include Line Selection, Policy Info, Locations, Loss History, Policy Review
		
		println('screenCount >> ' + screenCount)
		
		KeywordUtil.logInfo('screenCount >> ' + screenCount)
		
		WebUI.callTestCase(findTestCase('Common_Portal/LOB/CPP/EditPolicyChangeScreens'), [('screenNextCount') : screenCount, ('lineSelections') : lineSelections, ('lineCov') : lineCov], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Continue'], FailureHandling.STOP_ON_FAILURE)
		
		
		break
		
	case 'Homeowners':
	
		screenCount = wizardStepsCount - 1 // Exclude 'Issue 'Change'
		
		println('screenCount >> ' + screenCount)
		
		if(dwellingCovList.size() > 0) {
			
			editDwelDetailCov = true
		}
		
		WebUI.callTestCase(findTestCase('Common_Portal/LOB/HO/EditPolicyChangeScreens'), [('screenNextCount') : screenCount, ('editDwelDetailCov') : editDwelDetailCov, ('dwellingCovList') : dwellingCovList, ('coverageTypeMap') : coverageTypeMap], FailureHandling.STOP_ON_FAILURE)
	
		break
		
	default:
	
		screenCount = 0
		
		break
}

return policyChangeTrxnNum