package encova

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.Duration

import java.time.LocalDate
import java.time.DayOfWeek
import org.openqa.selenium.By as By

class GW {

	/**
	 *  Get FEIN number format XX-XXXXXXX
	 * @return
	 */
	def static getFEIN(){

		return new Date().format('MM-ddHHmmss')[(0..-2)]
	}

	/**
	 *  Get today number format XX-XXXXXXX
	 * @return
	 */
	def static getTody(){

		return new Date().format('MM-ddHH')[(0..-2)]
	}

	/**
	 *  Get FEIN number format XXXXXXX
	 * @return
	 */
	def static getOHLicenseNum(){

		def OHLicenseNum = new Date().format('MMddHHmmssSSS')[(0..-2)]

		return OHLicenseNum[6..11]
	}

	/**
	 *  Get SSN number format XXX-XX-XXXX
	 * 
	 */

	def static getSSN(){

		def SSN = new Date().format('MMddHHmmss')[(0..-2)]


		return SSN[0..2] + "-" + SSN[3..4] + "-" + SSN[5..8]
	}


	/**
	 *  Get a time stamp format 20190617_012235
	 * 
	 */
	def static getDateTime(){

		return new Date().format('YYYYMMdd_HHmmss')
	}

	/**
	 *  Get current date in format 06172019
	 * 
	 */

	def static getDate(){

		return new Date().format('MMddyyyy')
	}

	/**
	 *  Get current local date in format 06172019
	 *
	 */

	def static getLocalDate(){

		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddyyyy"))
	}

	/**
	 *  Get a date before or after current date 
	 *  getDate(10)
	 *  getDate(-30)
	 * 
	 */

	def static getDate(int shiftDate){

		//KeywordUtil.logInfo("-----------------now date is: " + new Date() + " " + (new Date() + shiftDate))
		Date date = new Date() + shiftDate

		//KeywordUtil.logInfo("----------------- shift date: " + date)

		String date2 = date.format('MMddyyyy')

		//KeywordUtil.logInfo("----------------- formated date: " + date2)

		return date2
	}


	/**
	 *  Get a date before or after current date with format 'MM/dd/YYYY'
	 *  getDatewithformat(10)
	 *  getDatewithformat(-30)
	 *
	 */

	def static getDatewithformat(int shiftDate){
		Date date = new Date() + shiftDate
		return date.format('MM/dd/yyyy')
	}

	/**
	 *  Get a date format from 'MMddYYYY' to 'MM/dd/YYYY'
	 *  formattedDate(06182024)
	 *  
	 *
	 */

	def static formattedDate(String dateStr){

		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy")

		Date date = sdf.parse(dateStr)

		SimpleDateFormat newSdf = new SimpleDateFormat("MM/dd/yyyy")

		String formattedDate = newSdf.format(date)

		return formattedDate
	}


	/**
	 *  Get a date before or after current date with format 'YYYY-MM-dd'
	 *  getDatewithformat(10)
	 *  getDatewithformat(-30)
	 *
	 */
	def static getDatewithformat2(String shiftDate){
		if (shiftDate && shiftDate.length() < 8){
			Date date = new Date() + shiftDate.toInteger()
			return date.format('YYYY-MM-dd')
		}
		else{
			return shiftDate
		}
	}





	/**
	 *  Get a date before or after by given date
	 *  getDate(10)
	 *  getDate(-30)
	 *
	 */
	def static getDate(String oldDate, int shiftDate){
		//oldDate = '06/27/2019'
		Date date = Date.parse( 'MM/dd/yyyy', oldDate ) + shiftDate

		return date.format( 'MMddyyyy' )
	}

	def static getDate2(String oldDate, int shiftDate){
		//oldDate = '06272019'
		Date date = Date.parse( 'MMddyyyy', oldDate ) + shiftDate

		return date.format( 'MMddyyyy' )
	}

	/**
	 *  Get a date to calculate with shift days
	 *  
	 *  	getPolicyDate(10)
	 *  	getPolicyDate(-30)
	 *
	 *	or return what given
	 *
	 *		getPolicyDate('MMddYYYY')
	 */

	def static getPolicyDate(date){

		if (date && date.length() < 8){

			if(date.isInteger()){
				//KeywordUtil.logInfo("-----------------Passed in date is: " + date + " " + date.getClass())
				//KeywordUtil.logInfo("-----------------integer date is: " + date.toInteger() + " " + date.toInteger().getClass())
//				date = getDate(date.toInteger())
				date = getUSDate(date.toInteger())
				//KeywordUtil.logInfo("-----------------Retruned calculated date is: " + date)
				return date
			}
			else{

				KeywordUtil.markFailedAndStop("!!!!!!!!!! Policy Info: incorrect date format. Please correct to MMddYYYY or an give by an integer like 10 or -5.  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1")
			}
		}
		else{
			return date
		}
	}

	@Keyword
	def static jsClick(to){

		//		WebElement element = WebUiCommonHelper.findWebElement(to,30)
		//
		//		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))


		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, 20)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}

	def static boolean checkLeapYear(int year) {

		def result = false

		if (year%4 == 0) {
			if (year%100 != 0) {
				result = true
			} else if (year%400 == 0) {
				result = true
			}
		}

		return result
	}

	def static getUSDate(int shiftdate){

		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York")).plusDays(shiftdate)

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy")

		String formattedDate = now.format(formatter)

		return formattedDate
	}

	def static getUSDateFormat2(int shiftdate){

		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York")).plusDays(shiftdate)

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd")

		String formattedDate = now.format(formatter)

		return formattedDate
	}


	def static getUSDateFormat3(int shiftdate){

		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York")).plusDays(shiftdate)

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY.MM.dd")

		String formattedDate = now.format(formatter)

		return formattedDate
	}

	def static getUSDateTime(int shiftdate) {

		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York")).plusDays(shiftdate)

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss")

		String formattedDateTime = now.format(formatter)

		return formattedDateTime
	}

	def static getUSDateTime2(int shiftdate) {

		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York")).plusDays(shiftdate)

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a")

		String formattedDateTime = now.format(formatter)

		return formattedDateTime
	}

	def static getUSDatewithformat(int shiftDate){

		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York")).plusDays(shiftDate)

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

		String formattedDateTime = now.format(formatter)

		return formattedDateTime
	}

	def static getCurrentUSDatewithformat() {
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"))
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")
		String formattedDateTime = now.format(formatter)
		return formattedDateTime
	}

	def static getSecondsDifference(String dateTime1, String dateTime2) {
		// Create DateTimeFormatter for parsing the input strings
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

		// Parse the input strings to LocalDateTime objects
		LocalDateTime dt1 = LocalDateTime.parse(dateTime1, formatter);
		LocalDateTime dt2 = LocalDateTime.parse(dateTime2, formatter);

		// Calculate the duration between the two LocalDateTime objects
		Duration duration = Duration.between(dt1, dt2);

		// Return the duration in seconds
		return duration.getSeconds();
	}

	def static getTableRowNum(TableObject, valueToFind) {

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement table = WebUiCommonHelper.findWebElement(TableObject, 30)

		// get all rows for table
		List<WebElement> rows = table.findElements(By.tagName('tr'))

		// for each all rows
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i)
			// get all cells
			List<WebElement> cells = row.findElements(By.tagName('td'))

			// for each all cells
			for (WebElement cell : cells) {
				// check value
				if (cell.getText().equals(valueToFind)) {
					println("Value found in row: " + (i + 1))
					return i
				}
			}
		}
	}

	//get the project root directory
	def static getFileFullPath(filePath) {

		String projectDir = System.getProperty('user.dir')
		println("Project Directory: " + projectDir)

		String fullPath = projectDir + filePath
		println("Full File Path: " + fullPath)

		return fullPath
	}

	// getMarkerString
	def static getMarkerString (fullString, marker) {

		int markerIndex = fullString.indexOf(marker)

		// if found marker
		if (markerIndex != -1) {

			int startIndex = markerIndex + marker.length()

			String resultString = fullString.substring(startIndex)
			println("Full File Path: " + resultString)
			return resultString
		}
	}

	def static calculateBusinessDate(String startDateStr, int businessDays, List<String> holidayStrs) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
		LocalDate startDate = LocalDate.parse(startDateStr, formatter)

		List<LocalDate> holidays = holidayStrs.collect { dateStr -> LocalDate.parse(dateStr, formatter) }

		LocalDate resultDate = startDate
		int daysAdded = 0

		while (daysAdded < businessDays) {
			resultDate = resultDate.plusDays(1)
			DayOfWeek dayOfWeek = resultDate.getDayOfWeek()

			if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY && !holidays.contains(resultDate)) {
				daysAdded++
			}
		}

		return resultDate
	}
}