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

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.annotation.TearDownIfPassed
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class encova_listener {  
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
	
//		try {
//			
//			WebUI.callTestCase(findTestCase('Common/CSVFunctions/WriteTestData'), [('caseID') : testCaseContext.getTestCaseId().split('/').last(), ('targetColName') : 'TestResult', ('targetValue') : 'Failed'],
//				FailureHandling.STOP_ON_FAILURE)
//			
//			WebUI.callTestCase(findTestCase('Common/CSVFunctions/WriteTestData'), [('caseID') : testCaseContext.getTestCaseId().split('/').last(), ('targetColName') : 'ExecutionTime', ('targetValue') : GW.getDateTime()],
//				FailureHandling.STOP_ON_FAILURE)
//			
//		} catch(Exception e) {
//			
//			println('Exception when writing test data: ' + e)
//		}
		
	}

    @AfterTestCase  
    def afterTestCase(TestCaseContext testCaseContext) {  
		
    }  
}  
