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

if (scroll == 'middle') {
	
	WebUI.executeJavaScript("var element = arguments[0];" +
		"var elementRect = element.getBoundingClientRect();" +
		"var absoluteElementTop = elementRect.top + window.pageYOffset;" +
		"var middle = absoluteElementTop - (window.innerHeight / 2);" +
		"window.scrollTo(0, middle);", Arrays.asList(WebUI.findWebElement(findTestObject('AgencyPortal/Dynamic/Icon/removeIconByContainsText', [('text') : text]))))

} else if (scroll == 'top'){
	
	WebUI.scrollToElement(findTestObject('AgencyPortal/Dynamic/Icon/removeIconByContainsText', [('text') : text]), 1)
	
}

WebUI.click(findTestObject('AgencyPortal/Dynamic/Icon/removeIconByContainsText', [('text') : text]))

if (wait) {
	
	WebUI.callTestCase(findTestCase('Common_Portal/Actions/WaitPageRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
	
}

