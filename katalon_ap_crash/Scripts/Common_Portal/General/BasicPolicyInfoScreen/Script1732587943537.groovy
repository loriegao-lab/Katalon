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

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Continue']), 2, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Continue'], FailureHandling.STOP_ON_FAILURE)

}

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'close']), 2, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'close'], FailureHandling.STOP_ON_FAILURE)

}

acctNum = WebUI.getText(findTestObject('AgencyPortal/General/h3_AcctNo')).split(' ')[1].trim()
subNum = WebUI.getText(findTestObject('AgencyPortal/General/div_SubNo')).split(' ')[-1].trim()

if (line in ['Homeowners']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText_Middle'), [('text') : 'Policy Type', ('option') : policyType],
		FailureHandling.STOP_ON_FAILURE)
	
}

if (line in ['Personal Auto']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText_Middle'), [('text') : 'Term Type', ('option') : termType],
		FailureHandling.STOP_ON_FAILURE)
	
} else if (line in ['Homeowners', 'Personal Umbrella'] && !(termType in ['Annual','12 months'])) {
			
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByText'), [('text') : termType], FailureHandling.STOP_ON_FAILURE)
	
}

if (effectiveDate != '') {
    effectiveDate = GW.getPolicyDate(effectiveDate)

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClearAndInputTextBoxValueByText'), [('text') : 'Effective Date', ('value') : effectiveDate], 
        FailureHandling.STOP_ON_FAILURE)
}

if (termType == 'Other') {
    expirationDate = GW.getPolicyDate(expirationDate)

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClearAndInputTextBoxValueByText'), [('text') : 'Expiration Date', ('value') : expirationDate], 
        FailureHandling.STOP_ON_FAILURE)

//    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClearAndInputTextBoxValueByText'), [('text') : 'Expiration Date', ('value') : expirationDate], 
//        FailureHandling.STOP_ON_FAILURE)
}

if (line in ['Personal Auto', 'Homeowners', 'Personal Umbrella']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText_Middle'), [('text') : 'Payment Plan', ('option') : paymentPlan],
		FailureHandling.STOP_ON_FAILURE)
	
}

if (line in ['Personal Auto', 'Homeowners']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickEditIconByTitle'), [('title') : 'Prior Carriers'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Coverage In Force?', ('option') : 'Yes'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Prior Carrier Name', ('option') : priorCarrierName],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Reason For New Policy', ('option') : 'Child moving out of the household'],
		FailureHandling.STOP_ON_FAILURE)
	
	if (line in ['Personal Auto']) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByTextAfter'), [('text') : 'Years', ('value') : '6'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByTextAfter'), [('text') : 'Months', ('value') : '6'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByTextOption'), [('text') : 'Liability only?', ('option') : 'Yes'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Liability Limit', ('option') : '$25,000/$65,000'],
			FailureHandling.STOP_ON_FAILURE)
		
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Save & Close', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
	
}

if (line in ['Businessowners']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText_Middle'), [('text') : 'Business Type', ('option') : businessType],
		FailureHandling.STOP_ON_FAILURE)

}

if (line in ['Businessowners', 'Commercial Auto', 'General Liability', 'Commercial Property', 'Crime', 'Inland Marine', 'Commercial Package', 'Umbrella']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('scroll') : 'middle', ('text') : 'Organization Type', ('option') : organizationType],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Year Business Started', ('value') : '2019'],
		FailureHandling.STOP_ON_FAILURE)
	
	if(ownersAndContractors == 'Yes') {
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Owners and Contractors Named Insured', ('value') : 'AutomationCompany'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Address Line 1', ('value') : address1], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'State', ('option') : state, ('scroll') : 'top'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'City', ('value') : city], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'County', ('value') : county], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Postal Code', ('value') : zipCode], FailureHandling.STOP_ON_FAILURE)
		
		if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 2, FailureHandling.OPTIONAL)) {
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Use Original'], FailureHandling.STOP_ON_FAILURE)
		
		}
	}
}

if (line in ['Businessowners', 'Commercial Auto', 'Commercial Property', 'Crime', 'Inland Marine']) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'NAICS Code', ('value') : nAICSCode],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'SIC Code', ('value') : sICCode, ('scroll') : 'middle'],
		FailureHandling.STOP_ON_FAILURE)
	
	questions_count = WebUI.findWebElements(findTestObject('AgencyPortal/Dynamic/RadioButton/radioCountByOption', [('option') : 'No']), 2).size()
	
	for (i = 1; i <= questions_count; i++) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByOptionIndex'), [('option') : 'No', ('index') : i], FailureHandling.STOP_ON_FAILURE)

	}
	
}

if (line in ['Homeowners']) {
	
	if (autoPay == 'Yes') {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByLabelAndModelText'), [('text') : 'autopay', ('modelText') : 'isAutoPay'], FailureHandling.STOP_ON_FAILURE)
		
	}
	
	if (multiPolicy == 'Yes') {
		
		if (WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByContainsText', [('text') : 'ADD EXISTING POLICY']), 1, FailureHandling.OPTIONAL)) {
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByLabelAndModelText'), [('text') : 'multiPolicyDiscount', ('modelText') : 'multiPolicyDiscount', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)		
		}
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'ADD EXISTING POLICY', ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'addPolicy'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'POLICY TYPE', ('option') : multiPolicyType], FailureHandling.STOP_ON_FAILURE)
		
		if (multiPolicyType in ['Commercial']) {
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'UNDERWRITING COMPANY', ('option') : 'Motorists Mutual Insurance Company'], FailureHandling.STOP_ON_FAILURE)
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'COMPANY NAME', ('value') : 'Automation Test'], FailureHandling.STOP_ON_FAILURE)
		
		}
		
		if (multiPolicyType in ['Personal Auto']) {
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'UNDERWRITING COMPANY', ('option') : 'MICO Insurance Company'], FailureHandling.STOP_ON_FAILURE)
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'FIRST NAME', ('value') : 'Automation Test'], FailureHandling.STOP_ON_FAILURE)
			
			WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'LAST NAME', ('value') : 'Automation Test'], FailureHandling.STOP_ON_FAILURE)
		
		}
		
			
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Save & Close'], FailureHandling.STOP_ON_FAILURE)
	}
	
} 

if (line in ['Homeowners']) {
	
	if (validateIntegration == 'Yes') {
		
		
	}
	
	if (updatePrimaryNameInsured == 'Yes') {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickEditIconByTitle'), [('title') : 'Primary Named Insured'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Home Phone', ('value') : '2015551234'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Save & Close'], FailureHandling.STOP_ON_FAILURE)
		
	}
	
}

if(line in ['Commercial Package']) {
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h5ByText', [('text') : 'Is the Insured involved in any towing operations?']), 1, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByLabelTextOption'), [('text') : 'Is the Insured involved in any towing operations?', ('option') : 'No'], FailureHandling.STOP_ON_FAILURE)
	}
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'NAICS Code']), 2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'NAICS Code', ('value') : nAICSCode],
		FailureHandling.STOP_ON_FAILURE)
	
	}
	
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Input/inputByLabelText', [('text') : 'SIC Code']), 2, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'SIC Code', ('value') : sICCode, ('scroll') : 'middle'],
		FailureHandling.STOP_ON_FAILURE)
	
	}
	
}

if(discount == true) {
	
	if (payInFull == 'Yes') {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByLabelAndModelText'), [('text') : 'PayInFull', ('modelText') : 'paDiscountIndicatorsView.isPayInFull.value'], FailureHandling.STOP_ON_FAILURE)
		
	}
	
	if(paperless) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByLabelAndModelText'), [('text') : 'PayInFull', ('modelText') : 'paDiscountIndicatorsView.isPaperless.value'], FailureHandling.STOP_ON_FAILURE)
	}
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Link/linkByText', [('text') : 'Acknowledge and Continue']), 1, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : 'Acknowledge and Continue'], FailureHandling.STOP_ON_FAILURE)
}

return [acctNum, subNum]