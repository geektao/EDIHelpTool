package tonyx.Tools.EDIHelp.Utilities;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class GenerateSpec {
	Map<String, CellStyle> styles;
	private static final String[] issueLogTitles = { "No", "Issue Description",
			"Additional Information", "Question Date", "Questioner",
			"Solution Description", "answerer", "Response Date" };
	private static final String[] revisionHistoryTitle = { "Version", "Date",
			"Author", "Approved By", "Comments" };
	private static final String[] mappingDestTitles = { "Segment\n/Position",
			"Element", "Description", "Looping", "M/C" };
	private static final String[] mappingSrcTitles = { "Segment\n/Position",
			"Element", "Mapping Logic", "Remark"};

	public void RevisionHistorySheet(HSSFWorkbook wbk) {
		HSSFSheet sheet = wbk.createSheet("Revision History");
		createRevisionHistoryHead(wbk, sheet);

		HSSFRow row;
		HSSFCell cell;
		CellStyle style = styles.get("RevisionHistoryBody");
		for (int i = 0; i < 10; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < 5; j++) {
				cell = row.createCell(j);
				cell.setCellStyle(style);
			}
		}
	}

	private void createRevisionHistoryHead(HSSFWorkbook wb, HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);

		CellStyle style = styles.get("RevisionHistoryHeader");
		HSSFCell cell;
		for (int i = 0; i < revisionHistoryTitle.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(revisionHistoryTitle[i]);
			cell.setCellStyle(style);
		}
	}

	public void mappingSheet(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.createSheet("mapping");
		Row titleRow;
		Cell titleCell;
		Row headerRow;
		Cell blackCell;

		// Dest
		titleRow = sheet.createRow(0);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Destination:");
		titleCell.setCellStyle(styles.get("MappingDestTitle"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$E$1"));
				for (int i = 1; i < mappingDestTitles.length; i++) {
			titleCell = titleRow.createCell(i);
			titleCell.setCellStyle(styles.get("MappingDestTitle"));
		}
				
		blackCell = titleRow.createCell(mappingDestTitles.length);
		blackCell.setCellStyle(styles.get("MappingBlack"));
		
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("Source:");
		titleCell.setCellStyle(styles.get("MappingSrcTitle"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$G$1:$J$1"));
		int startindex = mappingDestTitles.length + 1;
		for (int i = startindex+1; i < startindex + mappingSrcTitles.length; i++) {
			titleCell = titleRow.createCell(i);
			titleCell.setCellStyle(styles.get("MappingSrcTitle"));
		}

		headerRow = sheet.createRow(1);
		headerRow.setHeightInPoints(40);
		Cell headerCell;
		for (int i = 0; i < mappingDestTitles.length; i++) {
			headerCell = headerRow.createCell(i);
			headerCell.setCellValue(mappingDestTitles[i]);
			headerCell.setCellStyle(styles.get("MappingDestHeader"));
		}

		blackCell = headerRow.createCell(mappingDestTitles.length);
		blackCell.setCellStyle(styles.get("MappingBlack"));

		startindex = mappingDestTitles.length + 1;
		for (int i = 0; i < mappingSrcTitles.length; i++) {
			headerCell = headerRow.createCell(startindex+i);
			headerCell.setCellValue(mappingSrcTitles[i]);
			headerCell.setCellStyle(styles.get("MappingSrcTitle"));
		}

		// Source

	}

	public void issueLogSheet(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.createSheet("Issue Log");

		// title
		Row titleRow = sheet.createRow(0);
		titleRow.setHeightInPoints(45);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Issue Log");
		titleCell.setCellStyle(styles.get("IssueLogTitle"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$H$1"));
		for (int i = 1; i < issueLogTitles.length; i++) {
			titleCell = titleRow.createCell(i);
			titleCell.setCellStyle(styles.get("IssueLogTitle"));
		}

		// header
		Row headerRow = sheet.createRow(1);
		headerRow.setHeightInPoints(40);
		Cell headerCell;
		for (int i = 0; i < issueLogTitles.length; i++) {
			headerCell = headerRow.createCell(i);
			headerCell.setCellValue(issueLogTitles[i]);
			headerCell.setCellStyle(styles.get("IssueLogHeader"));
		}

		// body
		Row bodyRow;
		Cell bodyCell;
		CellStyle style = styles.get("IssueLogBody");
		for (int i = 2; i < 10; i++) {
			bodyRow = sheet.createRow(i);
			for (int j = 0; j < issueLogTitles.length; j++) {
				bodyCell = bodyRow.createCell(j);
				bodyCell.setCellStyle(style);
			}
		}
	}

	public void createStyles(Workbook wb) {
		styles = new HashMap<String, CellStyle>();
		CellStyle style;

		// history
		style = wb.createCellStyle();
		Font rhfont = wb.createFont();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setFont(rhfont);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("RevisionHistoryHeader", style);

		style = wb.createCellStyle();
		Font rhbfont = wb.createFont();
		rhbfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setFont(rhbfont);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styles.put("RevisionHistoryBody", style);

		// mapping
		style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("MappingDestTitle", style);

		style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("MappingSrcTitle", style);

		style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("MappingDestHeader", style);

		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("MappingBlack", style);

		style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("MappingBody_Group", style);

		style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("MappingBody_Segment", style);

		style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setDataFormat(wb.createDataFormat().getFormat("@"));
		styles.put("MappingBody_field", style);

		// Issue Log
		style = wb.createCellStyle();
		Font iltfont = wb.createFont();
		rhbfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setFont(iltfont);
		style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("IssueLogTitle", style);

		style = wb.createCellStyle();
		Font ilhfont = wb.createFont();
		rhbfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setFont(ilhfont);
		style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("IssueLogHeader", style);

		style = wb.createCellStyle();
		Font ilbfont = wb.createFont();
		rhbfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		style.setFont(ilbfont);
		style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("IssueLogBody", style);

	}
}