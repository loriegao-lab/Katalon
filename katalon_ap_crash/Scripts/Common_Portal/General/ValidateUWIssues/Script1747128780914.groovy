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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType

uw_count = WebUI.findWebElements(findTestObject('AgencyPortal/Dynamic/Table/tableRowCountByTitle', [('title') : 'Underwriting Issue']), 2).size() - 2

for(uwIssue in uwIssuesMap) {
	
	match_found = false
	
	for(i = 2; i < uw_count + 2; i++) {
		
		short_des = WebUI.getText(findTestObject('AgencyPortal/Dynamic/Table/tableCellByTitleRowCol', [('title') : 'Underwriting Issue', ('row') : i, ('col') : '2']))
		
		println("Full File Path: " + short_des)
		println("Full File Path: " + uwIssue.key)
		
		if (WebUI.verifyMatch(short_des, uwIssue.key, true, FailureHandling.OPTIONAL)) {
		
			match_found = true
			
			break
		}
		
	}
	
	if(!match_found) {
		
		KeywordUtil.markFailedAndStop("!!! UW Issue ${uwIssue} not being triggered !!!")
		
	}
	
}

