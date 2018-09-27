package tonyx.Component.Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel {
	private Workbook workbook = new HSSFWorkbook();
	private Sheet activeSheet;

	public Excel() {

	}

	public void addRow(int index, String[] values) {
		if (activeSheet != null)
			addRow(activeSheet, index, values);
	}

	public void addRow(Sheet sheet, int index, String[] values) {
		Row row = sheet.getRow(index);
		if (row == null) {
			row = sheet.createRow(index);
		}
		Cell cell;
		for (int i = 0; i < values.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(values[i]);
		}
	}

	// public void

	public Sheet createSheet() {
		return workbook.createSheet();
	}

	public Sheet createSheet(String sheetName) {
		return workbook.createSheet(sheetName);
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public Sheet getActiveSheet() {
		return activeSheet;
	}

	public void setActiveSheet(Sheet activeSheet) {
		this.activeSheet = activeSheet;
	}
}
