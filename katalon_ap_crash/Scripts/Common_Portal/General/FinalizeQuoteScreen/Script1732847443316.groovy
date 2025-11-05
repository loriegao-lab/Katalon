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
import com.kms.katalon.core.exception.StepFailedException as StepFailedException

if (line in ['Personal Auto', 'Homeowners', 'Personal Umbrella','Encova Premier Homeowners']) {
	
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText_Middle'), [('text') : 'Payment Due Date'
            , ('option') : paymentDueDate], FailureHandling.STOP_ON_FAILURE)
	
	if(!eSignature) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Do you wish to sign all documents using the Encova eSignature process?'
			, ('option') : 'No'], FailureHandling.STOP_ON_FAILURE)

		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByTextAfter'), [('text') : 'I attest that all documents requiring a signature have been signed by a named insured and retained.'],
			FailureHandling.STOP_ON_FAILURE)
		
	} else {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ESignatureProcess'), [('submissionNumber') : submissionNumber], FailureHandling.STOP_ON_FAILURE)
		
	}

  
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'Email Address']),2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') :'Email Address',('value'): 'automationtest@test.com'], FailureHandling.STOP_ON_FAILURE)
	}
	
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickDivByContainsText'), [('text') : paymentMethod, ('scroll') : 'top'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Confirm Payment', ('wait') : true], 
        FailureHandling.STOP_ON_FAILURE)
	
	if(eSignature) {
		
		js = "arguments[0].click();"
		
		if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByTextAfterAndAttributeValue', [('text') : 'I agree to use electronic records and signatures.', ('attribute') : 'type', ('value') : 'checkbox']), 3, FailureHandling.OPTIONAL)) {
			
			WebUI.executeJavaScript(js, Arrays.asList(WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Input/inputByTextAfterAndAttributeValue', [('text') : 'I agree to use electronic records and signatures.', ('attribute') : 'type', ('value') : 'checkbox']), 1)), FailureHandling.STOP_ON_FAILURE)
			
			WebUI.delay(5)
			
			WebUI.executeJavaScript(js, Arrays.asList(WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Continue']), 1, FailureHandling.STOP_ON_FAILURE)))
			
			WebUI.delay(5)
		}
	
		WebUI.executeJavaScript(js, Arrays.asList(WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Start']), 1, FailureHandling.STOP_ON_FAILURE)))
		
		WebUI.delay(5)
		
		WebUI.executeJavaScript(js, Arrays.asList(WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Div/divByText', [('text') : 'Sign']), 1, FailureHandling.STOP_ON_FAILURE)))
		
		WebUI.delay(5)
		
		if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Adopt and Sign']), 3, FailureHandling.OPTIONAL)) {
			
			WebUI.executeJavaScript(js, Arrays.asList(WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Adopt and Sign']), 1, FailureHandling.STOP_ON_FAILURE)))
			
			WebUI.delay(5)
		}

		if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Sign']), 3, FailureHandling.OPTIONAL)) {
			
			WebUI.executeJavaScript(js, Arrays.asList(WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Sign']), 1, FailureHandling.STOP_ON_FAILURE)))
			
		}
	
		WebUI.executeJavaScript(js, Arrays.asList(WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsAttributeAndValue', [('attribute') : 'data-qa', ('value') : 'envelope-finish']), 1, FailureHandling.STOP_ON_FAILURE)))
		
	}
	
	WebUI.delay(5)
	
    WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h2ByText', [('text') : 'Your policy has been issued.']), 10) 
	
} else if (line in ['Businessowners', 'Commercial Auto', 'General Liability', 'Commercial Property', 'Crime', 'Inland Marine', 'Commercial Package', 'Umbrella']) {

    mainContactPresent = WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByTextAndIndex', [('text') : 'Main Contact'
                , ('index') : 'last()']), 2, FailureHandling.OPTIONAL)
	
	WebUI.delay(2)

    mainContactVisible = WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Span/spanByTextAndIndex', [('text') : 'Main Contact'
                , ('index') : 'last()']), FailureHandling.OPTIONAL)

    mainContactClickable = WebUI.verifyElementClickable(findTestObject('AgencyPortal/Dynamic/Span/spanByTextAndIndex', [
                ('text') : 'Main Contact', ('index') : 'last()']), FailureHandling.OPTIONAL)

    try {
		
        if (mainContactClickable) {
			
            WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanByTextAndIndex_Middle'), [('text') : 'Main Contact'
                    , ('index') : 'last()'], FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'First Name', ('value') : firstName], 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Last Name', ('value') : (lastName + 
                    '_') + GW.getFEIN()], FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Preferred Contact Method'
                    , ('option') : communicationPreference], FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Work Phone', ('value') : workPhone], 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Address Line 1'
                    , ('value') : address1], FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'State', ('option') : state], 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'City', ('value') : city], 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'County', ('value') : county], 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Postal Code', ('value') : zipCode], 
                FailureHandling.STOP_ON_FAILURE)

            if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 
                1, FailureHandling.OPTIONAL)) {
			
                WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Use Original'], FailureHandling.STOP_ON_FAILURE)
            }
            
            if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Recommended']), 
                1, FailureHandling.OPTIONAL)) {
			
                WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Use Recommended'], 
                    FailureHandling.STOP_ON_FAILURE)
            }
            
            WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Save & Close', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
        }
    } catch (StepFailedException e) {
		
        println('Main Contact is not Editable!')
    } 
    
    if (reselectPolicy) {
		
        if (WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Table/tableRadioByText', [('text') : 'Full Pay']), 
            1, FailureHandling.OPTIONAL)) {
		
            WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTableCheckboxByRowCol'), [('row') : '1', ('col') : '1'], 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTableCheckboxByRowCol'), [('row') : '1', ('col') : '1'], 
                FailureHandling.STOP_ON_FAILURE)
        }
    }
    
    try {
		
        if (WebUI.getAttribute(findTestObject('AgencyPortal/Dynamic/Table/tableRadioByText', [('text') : paymentPlan]), 'aria-checked') != 'true') {
		
            WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTableRadioByText'), [('text') : paymentPlan, ('scroll') : 'middle'], 
                FailureHandling.STOP_ON_FAILURE)
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickTableRadioByText'), [('text') : paymentPlan, ('scroll') : 'middle'],
				FailureHandling.STOP_ON_FAILURE)
        }
		
    } catch (StepFailedException e) {
        println('Payment Plan Radio Button Not Enable')
    } 
    
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickDivByContainsText'), [('text') : paymentMethod, ('scroll') : 'top'], 
        FailureHandling.STOP_ON_FAILURE)


    if (paymentMethod == 'agency sweep') {
		
        WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Confirm Payment', ('wait') : true], 
            FailureHandling.STOP_ON_FAILURE)

		if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Icon/warningIconByH3HeadingText', [('text') : 'Confirm Agency Sweep Payment']), 2, FailureHandling.OPTIONAL)) {
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Confirm Payment', ('wait') : true],
				FailureHandling.STOP_ON_FAILURE)
			
			if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Icon/warningIconByH3HeadingText', [('text') : 'Confirm Agency Sweep Payment']), 2, FailureHandling.OPTIONAL)) {
				
				WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Confirm Payment'],
					FailureHandling.STOP_ON_FAILURE)
			}
		}	
		
		if(valMsgsMap) {
			
			if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsText', [('text') : 'Confirm Payment']), 2, FailureHandling.STOP_ON_FAILURE)) {
				
				WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Cancel'],
					FailureHandling.STOP_ON_FAILURE)
				
			}
			
			WebUI.callTestCase(findTestCase('Common_Portal/General/ValidateValMsgs'), [('valMsgsMap') : valMsgsMap, ('payToIssue') : payToIssue], FailureHandling.STOP_ON_FAILURE)
			
		}
		
    } else if (paymentMethod == 'mail check') {
		
        WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanByText'), [('text') : 'Pay & Issue'], FailureHandling.STOP_ON_FAILURE)
		
    }
	
	if(payToIssue) {
		
		WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h2ByText', [('text') : 'Your policy(s) have been issued.']), 90)
	}
    
    
}