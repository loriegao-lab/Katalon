package encova

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import groovy.transform.CompileStatic
import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository
import com.opencsv.CSVWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.io.FileWriter

public class CSVPlugin {

	@CompileStatic
	@Keyword
	static readCellByPathRowCol(String filePath, int rowIndex, int colIndex) {
		List<String> lines = readFileLines(filePath)
		if (lines == null) return null

		if (lines.size() <= rowIndex) {
			KeywordUtil.markFailed("Row index out of bounds: " + rowIndex)
			return null
		}

		String dataLine = lines.get(rowIndex)
		List<String> fields = Arrays.asList(dataLine.split(',')).collect { it.trim() }

		if (fields.size() <= colIndex) {
			KeywordUtil.markFailed("Column index out of bounds: " + colIndex)
			return null
		}

		return fields.get(colIndex)
	}

	@CompileStatic
	@Keyword
	static readCellByPathRowColName(String filePath, int rowIndex, String colName) {
		List<String> lines = readFileLines(filePath)
		if (lines == null) return null

		if (lines.size() <= rowIndex) {
			KeywordUtil.markFailed("Row index out of bounds: " + rowIndex)
			return null
		}

		String headerLine = lines.get(0)
		List<String> headers = Arrays.asList(headerLine.split(',')).collect { it.trim() }
		int colIndex = headers.indexOf(colName)

		if (colIndex == -1) {
			KeywordUtil.markFailed("Column name not found: " + colName)
			return null
		}

		String dataLine = lines.get(rowIndex)
		List<String> fields = Arrays.asList(dataLine.split(',')).collect { it.trim() }

		if (fields.size() <= colIndex) {
			KeywordUtil.markFailed("Column index out of bounds: " + colIndex)
			return null
		}

		return fields.get(colIndex)
	}

	@CompileStatic
	@Keyword
	static getRowIndexByColNameCellValue(String filePath, String colName, String cellValue) {
		List<String> lines = readFileLines(filePath)
		if (lines == null) return -1

		if (lines.size() <= 1) {
			KeywordUtil.logInfo("The file does not contain enough rows.")
			return -1
		}

		String headerLine = lines.get(0)
		List<String> headers = Arrays.asList(headerLine.split(',')).collect { it.trim() }
		int colIndex = headers.indexOf(colName)

		if (colIndex == -1) {
			KeywordUtil.logInfo("Column name not found: " + colName)
			return -1
		}

		for (int i = 1; i < lines.size(); i++) {
			String dataLine = lines.get(i)
			List<String> fields = Arrays.asList(dataLine.split(',')).collect { it.trim() }

			if (fields.size() > colIndex && fields.get(colIndex) == cellValue) {
				return i
			}
		}

		KeywordUtil.logInfo("Cell value not found: " + cellValue)
		return -1
	}

	@CompileStatic
	@Keyword
	static writeCellByPathRowCol(String filePath, int rowIndex, int colIndex, String newValue) {
		List<String> lines = readFileLines(filePath)
		if (lines == null) return

			// Ensure the file has enough rows
			while (lines.size() <= rowIndex) {
				lines.add("")
			}

		String dataLine = lines.get(rowIndex)
		List<String> fields = Arrays.asList(dataLine.split(',')).collect { it.trim() }

		// Ensure the row has enough columns
		while (fields.size() <= colIndex) {
			fields.add("")
		}

		fields.set(colIndex, newValue)
		lines.set(rowIndex, fields.join(','))

		writeFileLines(filePath, lines)
	}

	//	static final Lock lock = new ReentrantLock();

	@CompileStatic
	@Keyword
	static writeCellByPathRowColName(String filePath, int rowIndex, String colName, String newValue) {

		//		lock.lock();

		//		try {

		List<String> lines = readFileLines(filePath)
		if (lines == null) return

			String headerLine = lines.get(0)
		List<String> headers = Arrays.asList(headerLine.split(',')).collect { it.trim() }
		int colIndex = headers.indexOf(colName)

		if (colIndex == -1) {
			KeywordUtil.markFailed("Column name not found: " + colName)
			return
		}

		// Ensure the file has enough rows
		while (lines.size() <= rowIndex) {
			lines.add("")
		}

		String dataLine = lines.get(rowIndex)
		List<String> fields = Arrays.asList(dataLine.split(',')).collect { it.trim() }

		// Ensure the row has enough columns
		while (fields.size() <= colIndex) {
			fields.add("")
		}

		fields.set(colIndex, newValue)
		lines.set(rowIndex, fields.join(','))

		writeFileLines(filePath, lines)

		//		}	finally {
		//			lock.unlock();
		//		}
	}

	private static List<String> readFileLines(String filePath) {
		File file = new File(filePath)
		if (!file.exists()) {
			KeywordUtil.markFailed("File does not exist: " + filePath)
			return null
		}

		return Files.readAllLines(Paths.get(filePath))
	}

	//	private static final Lock lock = new ReentrantLock();

	private static void writeFileLines(String filePath, List<String> lines) {
		//	    lock.lock();
		//	    try {
		File file = new File(filePath);
		file.withWriter { writer ->
			lines.each { line ->
				writer.writeLine(line);
			}
		}
		//	    } finally {
		//	        lock.unlock();
		//	    }
	}
	
	def static exportTextToCSV(String result, String center) {

		String[] lines = result.split("\\r?\\n")
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
		
		String filePath = "D:\\MessageQueue\\"+center + timestamp + ".csv"
		
		CSVWriter writer = null
		
		writer = new CSVWriter(new FileWriter(filePath))
		
		String[] data = [result]
		
		String[] header = ['Line']
		writer.writeNext(header)
		
			// Process each line separately
			for (String line : lines) {
				// Split each line by commas
				String[] cells = line.split(",\\s*")
				// Write the split line into the CSV file
				writer.writeNext(cells)
			}
		
		writer.close()
		
		WebUI.comment("CSV file created successfully at: " + filePath)
	}
	
}
