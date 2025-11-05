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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

msgType = ""

if (valMsgsMap) {
	
    for (def valMsg : valMsgsMap) {
		
		println(" valMsg >>>>>>> " + valMsg)
		
        match_found = false
		
		if(valMsg.key.toString().toLowerCase().contains('error')) {
			
			println('Enter Error >>>>>...')
        
			msgType = WebUI.getText(findTestObject('AgencyPortal/General/div_ErrorMsgType', [:])).replaceAll("#\\d{10} ", "")
		
		} else if (valMsg.key.toString().toLowerCase().contains('warning')) {
			
			println('Enter Warning >>>>>...')
			
			msgType = WebUI.getText(findTestObject('AgencyPortal/General/div_WarningMsgType', [:])).replaceAll("#\\d{10} ", "")
			
		} else {
			
			println('Enter Default >>>>>...')
			
			msgType = WebUI.getText(findTestObject('AgencyPortal/Dynamic/Div/divErrorMsgBody', [:])).replaceAll("#\\d{10} ", "")
			
		}
		
		expectMsgType = valMsg.key.toString().replaceAll("#\\d{10} ", "")
		
		println('expectMsgType >>>>>' + expectMsgType)
		
		println('msgType >>>>>>' + msgType)

        if (WebUI.verifyMatch(msgType, expectMsgType, true, FailureHandling.OPTIONAL)) {
			
			match_found = true
			
			if(payToIssue) {
				
				msg = WebUI.getText(findTestObject('AgencyPortal/General/div_MsgByIndex',[('index'): index]))
				
				if(!WebUI.verifyMatch(msg, valMsg.value, true, FailureHandling.OPTIONAL)) {
					
					match_found = false
				}
			}
			
        }
    }
    
    if (!(match_found)) {
        KeywordUtil.markFailedAndStop("!!! Message $valMsg not being triggered !!!")
    }
}