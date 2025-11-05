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

WebUI.callTestCase(findTestCase('Common_Portal/General/LoginPortal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : 'Start a quote '], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickLinkByText'), [('text') : 'Create a new one.'], FailureHandling.STOP_ON_FAILURE)

if (validateAcctType == true) {
    // ALM Test Case: AP.A.01_Config_S4_IN_PL_TC002
    WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Account Type']), 1, 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/RadioButton/radioByText', [('text') : 'Commercial']), 
        1, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/RadioButton/radioByText', [('text') : 'Personal']), 
        1, FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByText'), [('text') : 'Personal'], FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Basic Account Information']), 
        1, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Primary Named Insured']), 
        1, FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByText'), [('text') : 'Commercial'], FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Basic Account Information']), 
        1, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('AgencyPortal/Dynamic/Heading/h3ByText', [('text') : 'Primary Named Insured']), 
        1, FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickRadioByText'), [('text') : 'Personal'], FailureHandling.STOP_ON_FAILURE)

if (validateAcctDetailsSections == true) {
    // ALM Test Case: E2E_AP_HO_TS001_TC001
    WebUI.callTestCase(findTestCase('Common_Portal/General/ValidateAcctDetailsSections'), [:], FailureHandling.STOP_ON_FAILURE)
}

if (validateAcctDetailsColumns == true) {
    // ALM Test Case: AP.A.01_Config_S4_IN_PL_TC001
    arrangement = WebUI.callTestCase(findTestCase('Common_Portal/LOB/HO/ValidateNewAccountDetailsScreenColumns'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyEqual(arrangement[0], true, FailureHandling.STOP_ON_FAILURE)

    println((('Current Window size: height > ' + WebUI.getViewportHeight(FailureHandling.STOP_ON_FAILURE)) + ', widght > ') + 
        WebUI.getViewportWidth(FailureHandling.STOP_ON_FAILURE))

    WebUI.setViewPortSize(375, 667, FailureHandling.STOP_ON_FAILURE)

    arrangement = WebUI.callTestCase(findTestCase('Common_Portal/LOB/HO/ValidateNewAccountDetailsScreenColumns'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyEqual(arrangement[1], true, FailureHandling.STOP_ON_FAILURE)
}

String firstNameUpdate = firstName + state

String firstNameUpdateUpper = firstNameUpdate.toUpperCase()

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'First Name', ('value') : firstNameUpdateUpper], 
    FailureHandling.STOP_ON_FAILURE)

if (lastName.contains('Test')) {
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Last Name', ('value') : (lastName + 
            '_') + GW.getFEIN()], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Last Name', ('value') : lastName], 
        FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Date Of Birth', ('value') : DOB], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Marital Status', ('option') : maritalStatus,('scroll'):'top'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Preferred Contact Method'
        , ('option') : communicationPreference, ('scroll') : 'middle'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Home Phone', ('value') : homePhone], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Address Line 1', ('value') : address1], 
    FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Email Address', ('value') : emailAddress], 
//    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'State', ('option') : state
        , ('scroll') : 'top'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'City', ('value') : city], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'County', ('value') : county], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common_Portal/Actions/InputTextBoxValueByText'), [('text') : 'Postal Code', ('value') : zipCode], 
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Use Original']), 2, 
    FailureHandling.OPTIONAL)) {
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Use Original'], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common_Portal/Actions/SelectDropDownOptionByText'), [('text') : 'Producer Code', ('option') : producerCode
        , ('scroll') : 'top'], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Save & Close'], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Save & Close']))

if (WebUI.verifyElementPresent(findTestObject('AgencyPortal/Dynamic/Button/btnByText', [('text') : 'Okay']), 2, FailureHandling.OPTIONAL)) {
    WebUI.callTestCase(findTestCase('Common_Portal/Actions/ClickBtnByText'), [('text') : 'Okay'], FailureHandling.STOP_ON_FAILURE)
}