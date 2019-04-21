package fileOperation

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration

public class WriteExcel {
	static final String SFilelocation = RunConfiguration.getProjectDir()+'\\Data Files\\'
	static final String SFileName = 'Default.xlsx'
	static final String SSheetName = "APIData"

	@Keyword
	def void writeAPIData(String tcName,String columnName,String value) {
		writeExcel(tcName, columnName, value, SFilelocation, SFileName, SSheetName)
	}

	def void writeExcel(String tcName,String columnName,String value, String FileLocation, String FileName, String SheetName) {
		FileInputStream file = new FileInputStream (new File(FileLocation+FileName))
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(SheetName);

		int finalRow = rowNumber(sheet, tcName)
		int finalCol = colNumber(sheet, columnName)

		Cell cell = sheet.getRow(finalRow).getCell(finalCol);
		cell.setCellValue(value);

		file.close();

		FileOutputStream outFile =new FileOutputStream(new File(FileLocation+"\\"+FileName));
		workbook.write(outFile);
		outFile.close();
	}

	def int rowNumber(XSSFSheet sheet,String tcName) {
		int finalRow = 0
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i = 1; i < rowCount+1; i++) {
			if(sheet.getRow(i).getCell(0).getStringCellValue() == tcName) {
				finalRow = i
				break
			}
		}
		return finalRow
	}

	def int colNumber(XSSFSheet sheet,String colName) {
		int finalCol = 0
		for (int i = 1; i < sheet.getRow(0).getLastCellNum(); i++) {
			if(sheet.getRow(0).getCell(i).getStringCellValue() == colName) {
				finalCol = i
				break
			}
		}
		return finalCol
	}
}
