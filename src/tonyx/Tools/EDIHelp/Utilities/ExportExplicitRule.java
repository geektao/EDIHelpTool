package tonyx.Tools.EDIHelp.Utilities;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.Tools.EDIHelp.Config.ReadProperties;
import tonyx.Tools.Utilities.CreateFile;
import tonyx.Tools.Utilities.PropertyName;
import tonyx.Tools.Utilities.Reflect;
import tonyx.Tools.Utilities.Rule;

public class ExportExplicitRule {
	private List<Rule> rules;
	private Sheet sheet;
	private Workbook wb;

	public ExportExplicitRule() {
		rules = new ArrayList<Rule>();

		wb = new HSSFWorkbook();
		// CreationHelper createHelper = wb.getCreationHelper();
		sheet = wb.createSheet("Rules");

		Row row = sheet.createRow((short) 0);
		
		Cell cell = row.createCell(0);
		cell.setCellValue("Feild Name");
		// cell = row.createCell(1);
		// cell.setCellValue("Rule");

		// Or do it on one line.
		row.createCell(1).setCellValue("Rule");
		// row.createCell(2).setCellValue(
		// createHelper.createRichTextString("This is a string"));
		// row.createCell(3).setCellValue(true);
		// searchRule();
		
	}

	public void searchRule(MapTreeNode node) {
		Rule rule = new Rule();
		StringBuffer rulebufBuffer = new StringBuffer();
		String nodeType = node.getNodeType();
		Object dataObj = node.getDataObj();
		String fileName = (String) Reflect.invokeGetMethod(dataObj.getClass(), dataObj,
				PropertyName.getGetterName("Name"));
		Object data = null;

		if ("Group".equals(nodeType) || "Segment".equals(nodeType)
				|| "PosRecord".equals(nodeType)
				|| "XMLElementGroup".equals(nodeType)
				|| "XMLParticleGroup".equals(nodeType)
				|| "XMLRecord".equals(nodeType)) {
			data = Reflect.invokeGetMethod(dataObj.getClass(), dataObj,
					PropertyName.getGetterName("ExplicitRule"));
			if (data != null) {
				Object temp = Reflect.invokeGetMethod(data.getClass(), data,
						PropertyName.getGetterName("OnBegin"));
				if (temp != null) {
					rulebufBuffer.append("OnBegin:\n"+temp.toString());
//					System.out.println(temp.toString());
				}

				temp = Reflect.invokeGetMethod(data.getClass(), data,
						PropertyName.getGetterName("OnEnd"));
				if (temp != null) {
					rulebufBuffer.append("OnEnd:\n"+temp.toString());
//					System.out.println(temp.toString());
				}
				if(rulebufBuffer.length() > 0){
					rule.setFieldName(fileName);
					rule.setRules(rulebufBuffer.toString());
					rules.add(rule);
				}
				
			}
		} else if ("Field".equals(nodeType)) {
			data = Reflect.invokeGetMethod(dataObj.getClass(), dataObj,
					PropertyName.getGetterName("ExplicitRule"));
			if (data != null && !"".equals(data)) {
				rulebufBuffer.append(data.toString());
//				System.out.println(data);
			}
			
			
			if(rulebufBuffer.length() > 0){
				rule.setFieldName(fileName);
				rule.setRules(rulebufBuffer.toString());
				rules.add(rule);
			}
		}

		int count = node.getChildCount();
		for (int i = 0; i < count; i++) {
			MapTreeNode subNode = (MapTreeNode) node.getChildAt(i);
			if (subNode.isActive()) {
				searchRule(subNode);
			}
		}
	}
	
	public void addRuleToXLS(){
		int i = 1;
		for(Rule rule:rules){
			Row row = sheet.createRow((short) i);
			row.createCell(0).setCellValue(rule.getFieldName());
			row.createCell(1).setCellValue(rule.getRules());
			i++;
		}
		CreateFile.createXLSFile(wb, ReadProperties.getProperty("ExportFolderPath"), "test");
	}
}
