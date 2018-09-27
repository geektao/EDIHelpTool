package tonyx.Tools.Converter;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.EDI.Common.PosSyntax.Field;
import tonyx.EDI.Common.PosSyntax.Group;
import tonyx.EDI.Common.PosSyntax.PosRecord;
import tonyx.Tools.EDIHelp.Config.ReadProperties;

final public class PosSyntaxToPosSyntax  implements SyntaxConverter{
	public MapTreeNode Coverter(MapTreeNode source) {
		MapTreeNode destination = new MapTreeNode(source.getUserObject());
		destination.setActive(true);
		String sourceType = source.getNodeType();

		if ("PosRecord".equals(sourceType)) {
			destination.setNodeType("PosRecord");
			PosRecord pr = ((PosRecord) source.getDataObj()).clone();
			// set TempName
			pr.setEdiName(ReadProperties.getProperty("Prefix")
					+ pr.getEdiName());

			pr.setEdiChildCount("0");
			pr.setEdiMin("0");
			pr.setEdiUsageRelatedFieldName(null);
			pr.setEdiExplicitRule(null);

			destination.setDataObj(pr);
			destination.setUserObject(pr.toString());
			return destination;
		} else if ("Field".equals(sourceType)) {
			destination.setNodeType("Field");
			Field field = ((Field) source.getDataObj()).clone();

			field.setEdiName(ReadProperties.getProperty("Prefix")
					+ field.getEdiName());

			field.setEdiExplicitRule(null);
			field.setEdiImplicitRuleDef(null);
			field.setEdiConditionalRuleDef(null);

			destination.setDataObj(field);
			destination.setUserObject(field.toString());
			return destination;
		} else if ("Group".equals(sourceType)) {
			destination.setNodeType("Group");
			Group group = ((Group) source.getDataObj()).clone();

			// set TempName
			group.setEdiName(ReadProperties.getProperty("Prefix")
					+ group.getEdiName());
			destination.setUserObject(group.toString());

			group.setEdiExplicitRule(null);
			group.setEdiChildCount("0");
			group.setEdiMin("0");

			destination.setDataObj(group);
			return destination;
		}
		return null;
	}
}
