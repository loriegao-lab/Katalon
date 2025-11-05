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
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern

if (!(phPortalLogin)) {
	
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Start A Claim'], FailureHandling.STOP_ON_FAILURE)
	
} else {
	
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : claimBtnText], FailureHandling.STOP_ON_FAILURE)
}

'Start A Claim Screen'
lossDate = GW.getPolicyDate(lossDate)

formatLossDate = WebUI.callTestCase(findTestCase('Common_Portal/General/ConvertStringToDateFormat'), [('originalDateString') : lossDate], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByContainsText'), [('text') : 'Date of Loss', ('value') : formatLossDate, ('wait') : true],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Next', ('wait') : true], FailureHandling.STOP_ON_FAILURE)

if(WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Div/divByContainsClass', [('text') : 'alert-warning']), 5, FailureHandling.OPTIONAL)) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Next', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
	
}

WebUI.delay(3);

if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Start a Claim']), FailureHandling.OPTIONAL)) {
	
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Next'], FailureHandling.STOP_ON_FAILURE)
}

if (line in ['Personal Auto']) {
	
    'Basic Claim Info Screen'
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Reported by', ('option') : 'LeighAnn Dietz',('scroll'):true], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Relation to insured'
            , ('option') : 'Injured worker'], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickCheckboxByTextAfter'), [('text') : vin], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByContainsText', [('text') : 'Possible Duplicate Claims found']),
		1, FailureHandling.OPTIONAL)) {
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
	}
	
	
	if (editVehichlesAndDamages) {
		WebUI.callTestCase(findTestCase('Common_Portal/LOB/PA/EditVehichlesAndDamages'), [:], FailureHandling.STOP_ON_FAILURE)
	}
	
	if (addPropertyDamage) {
		WebUI.callTestCase(findTestCase('Common_Portal/LOB/PA/AddPropertyDamage'), [('state'):state,('city'):city], FailureHandling.STOP_ON_FAILURE)
	}
	
WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimLossDetailsScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),FailureHandling.STOP_ON_FAILURE)	
	
}

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByContainsText', [('text') : 'Possible Duplicate Claims found']), 
    1, FailureHandling.OPTIONAL)) {
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
}

if (line in ['Businessowners']) {
    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimBasicClaimInfoScreen'), [('lossType') : lossType], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimIncidentDetailsScreen'), [('line') : 'Businessowners', ('lossType') : lossType], 
        FailureHandling.STOP_ON_FAILURE)

    if (lossType == 'Property') {
        WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimPropertyInfoScreen'), [('line'):line], FailureHandling.STOP_ON_FAILURE)
		
		//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()', ('wait') : true], FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('addInjury') : true, ('addProperties') : addProperties, ('addContent') : true, ('addVehicles') : true, ('addOfficial') : true, ('line'): line], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [('line'):line], FailureHandling.STOP_ON_FAILURE)

	if(attachDocuments == true) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/AttachDocuments'), [:], FailureHandling.STOP_ON_FAILURE)
		
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReviewSubmitScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
	'Submit Success'
	if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),
		FailureHandling.STOP_ON_FAILURE)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/CheckClaimAfterSubmission'), [('line') : 'Businessowners'], FailureHandling.STOP_ON_FAILURE)
		
	}
}

if (line in ['General Liability']) {
    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimBasicClaimInfoScreen'), [('lossType') : 'Property'], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimIncidentDetailsScreen'), [('line') : 'General Liability'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('addInjury') : true, ('addProperties') : true, ('addContent') : true, ('addVehicles') : true, ('addOfficial') : true, ('line') : line], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReviewSubmitScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
	'Submit Success'
	if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),
		FailureHandling.STOP_ON_FAILURE)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/CheckClaimAfterSubmission'), [('line') : 'General Liability'], FailureHandling.STOP_ON_FAILURE)
		
	}
}


if (line in ['Commercial Auto']) {
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimBasicClaimInfoScreen'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimVehicleScreen'), [('line') : 'Commercial Auto'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimLocationScreen'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('addInjury') : true, ('addProperties') : true, ('addOfficial') : true], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [('line'): 'Commercial Auto'], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReviewSubmitScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
	'Submit Success'
	if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),
		FailureHandling.STOP_ON_FAILURE)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/CheckClaimAfterSubmission'), [('line') : 'Commercial Auto'], FailureHandling.STOP_ON_FAILURE)
		
	}
}

if (line in ['Commercial Property']) {
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimBasicClaimInfoScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimIncidentDetailsScreen'), [('line') : 'Commercial Property'],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimPropertyInfoScreen'), [('line') : 'Commercial Property'], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('addInjury') : true, ('addContent') : true, ('addVehicles') : true, ('addOfficial') : true], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReviewSubmitScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
	'Submit Success'
	if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),
		FailureHandling.STOP_ON_FAILURE)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/CheckClaimAfterSubmission'), [('line') : 'Commercial Property'], FailureHandling.STOP_ON_FAILURE)
		
	}
}

if (line in ['Commercial Package']) {
	
	
	if(underlyingLine == 'Commercial Auto Line') {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Line of Business', ('option') : underlyingLine], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimBasicClaimInfoScreen'), [('lossType'): 'NoLossType', ('line') : underlyingLine, ('index') : index], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimVehicleScreen'), [('line') : 'Commercial Auto'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimLocationScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('line') : 'Commercial Auto', ('addInjury') : true, ('vehicleText') : ' vehicle', ('addProperties') : true, ('addOfficial') : true], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [('line') : 'Commercial Auto'], FailureHandling.STOP_ON_FAILURE)
	}
	
	if(underlyingLine == 'Crime Line') {
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Line of Business', ('option') : underlyingLine], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByJSNgClickText'), [('text') : 'nextMain()'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimIncidentDetailsScreen'), [('line') : 'Crime'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('addInjury') : true, ('vehicleText') : ' vehicle', ('addProperties') : true, ('addOfficial') : true], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [('line') : 'Crime'], FailureHandling.STOP_ON_FAILURE)
	}
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReviewSubmitScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
	'Submit Success'
	if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),
		FailureHandling.STOP_ON_FAILURE)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/CheckClaimAfterSubmission'), [('line') : 'Commercial Package'], FailureHandling.STOP_ON_FAILURE)
		
	}
}


if (line in ['Crime']) {
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimBasicClaimInfoScreen'), [('lossType'): 'NoLossType'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimIncidentDetailsScreen'), [('line') : 'Crime'],
		FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('line'): line, ('addInjury') : true, ('addProperties') : true, ('addContent') : true, ('addVehicles') : true, ('addOfficial') : true], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [('line') : line], FailureHandling.STOP_ON_FAILURE)
	
	if (attachDoc == 'true') {
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Attach Documents'], FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickSpanByText'), [('text') : 'Browse'], FailureHandling.STOP_ON_FAILURE)
		
		fullPath = GW.getFileFullPath('\\Data Files\\test\\portalTestDoc.pdf')
		WebUI.uploadFile(findTestObject('AgencyPortal/Dynamic/Input/inputByType',[('type') : 'file']), fullPath)
		WebUI.delay(5)
		WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Uploaded Documents']), FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByContainsText'), [('text') : 'Done'], FailureHandling.STOP_ON_FAILURE)
	}

	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReviewSubmitScreen'), [:], FailureHandling.STOP_ON_FAILURE)
	
	'Submit Success'
	if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),
		FailureHandling.STOP_ON_FAILURE)) {
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/CheckClaimAfterSubmission'), [('line') : 'Crime'], FailureHandling.STOP_ON_FAILURE)
		
	}
}
	
if (line in ['Inland Marine']) {
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimBasicClaimInfoScreen'), [('lossType'): 'NoLossType'], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimIncidentDetailsScreen'), [('line') : 'Inland Marine'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('line'): line, ('addInjury') : true, ('addProperties') : true, ('addContent') : true, ('addVehicles') : true, ('addOfficial') : true], FailureHandling.STOP_ON_FAILURE)
	
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [('line') : line], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReviewSubmitScreen'), [:], FailureHandling.STOP_ON_FAILURE)
		
		'Submit Success'
		if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),
			FailureHandling.STOP_ON_FAILURE)) {
			
			WebUI.callTestCase(findTestCase('Common_Portal/General/CheckClaimAfterSubmission'), [('line') : 'Inland Marine'], FailureHandling.STOP_ON_FAILURE)
			
		}
	}
	
if (line in ['Commercial Umbrella']) {
			WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimBasicClaimInfoScreen'), [('lossType'): 'NoLossType'], FailureHandling.STOP_ON_FAILURE)
			
			WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimIncidentDetailsScreen'), [('line') : 'Commercial Umbrella'],
				FailureHandling.STOP_ON_FAILURE)
			
			WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimAdditionalInfoScreen'), [('line'): 'Commercial Umbrella', ('addInjury') : true, ('addProperties') : true, ('addContent') : true, ('addVehicles') : true, ('addOfficial') : true], FailureHandling.STOP_ON_FAILURE)
		
			WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReportedByScreen'), [('line') : 'Commercial Umbrella'], FailureHandling.STOP_ON_FAILURE)
			
			WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimReviewSubmitScreen'), [:], FailureHandling.STOP_ON_FAILURE)
			
			'Submit Success'
			if (WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),
				FailureHandling.STOP_ON_FAILURE)) {
				
				WebUI.callTestCase(findTestCase('Common_Portal/General/CheckClaimAfterSubmission'), [('line') : 'Commercial Umbrella'], FailureHandling.STOP_ON_FAILURE)
				
			}
	}

if (line in ['Homeowners']) {
	
	'Basic Claim Info Screen'
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Category'
		, ('option') : 'Contents Only'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Reported by', ('option') : 'LeighAnn Dietz',('scroll'):true],
		FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Relation to insured'
			, ('option') : 'Injured worker'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
	
	if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Span/spanByContainsText', [('text') : 'Possible Duplicate Claims found']),
		1, FailureHandling.OPTIONAL)) {
		WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickNextBtn'), [:], FailureHandling.STOP_ON_FAILURE)
	}
	WebUI.callTestCase(findTestCase('Common_Portal/General/ClaimLossDetailsScreen'), [('line'): 'Homeowners', ('claimAdditionalInfo'): 'true'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementVisible(findTestObject('AgencyPortal/Dynamic/Heading/h1ByText', [('text') : 'Your claim has been submitted.']),FailureHandling.STOP_ON_FAILURE)

}

claimString = WebUI.getText(findTestObject('AgencyPortal/Dynamic/Div/divByContainsText', [('text') : 'Claim']), FailureHandling.STOP_ON_FAILURE)

// Use a regular expression to extract the text inside parentheses
def spliter = claimString =~ /(\d{3}-\d{2}-\d{6})/
String claimNumber = spliter ? spliter[0][0] : ""

return claimNumber
