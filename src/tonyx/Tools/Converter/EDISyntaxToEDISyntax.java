package tonyx.Tools.Converter;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.EDI.Common.EDISyntax.Composite;
import tonyx.EDI.Common.EDISyntax.Field;
import tonyx.EDI.Common.EDISyntax.Group;
import tonyx.EDI.Common.EDISyntax.Segment;
import tonyx.Tools.EDIHelp.Config.ReadProperties;

final public class EDISyntaxToEDISyntax implements SyntaxConverter{
	public MapTreeNode Coverter(MapTreeNode source) {
		MapTreeNode destination = new MapTreeNode(source.getUserObject());
		destination.setActive(true);

		String sourceType = source.getNodeType();

		if ("Segment".equals(sourceType)) {
			destination.setNodeType("Segment");
			Segment seg = ((Segment) source.getDataObj()).clone();
			//
			seg.setEdiName(ReadProperties.getProperty("Prefix")
					+ seg.getEdiName());
			destination.setUserObject(seg.toString());

			seg.setEdiChildCount("0");
			seg.setEdiMin("0");
			seg.setEdiUsageRelatedFieldName(null);

			destination.setDataObj(seg);
			return destination;
		} else if ("Composite".equals(sourceType)) {
			destination.setNodeType("Composite");
			Composite cp = ((Composite) source.getDataObj()).clone();
			//
			cp.setEdiName(ReadProperties.getProperty("Prefix")
					+ cp.getEdiName());
			destination.setUserObject(cp.toString());

			cp.setEdiMandatory("no");
			cp.setEdiMinUsage("0");
			destination.setDataObj(cp);
			return destination;
		} else if ("Field".equals(sourceType)) {
			destination.setNodeType("Field");
			Field field = ((Field) source.getDataObj()).clone();
			//
			field.setEdiName(ReadProperties.getProperty("Prefix")
					+ field.getEdiName());
			destination.setUserObject(field.toString());

			// field.setEdiExplicitRule(null);
			field.setEdiImplicitRuleDef(null);
			// field.setEdiConditionalRuleDef(null);

			destination.setDataObj(field);
			return destination;
		} else if ("Group".equals(sourceType)) {
			destination.setNodeType("Group");
			Group group = ((Group) source.getDataObj()).clone();
			//
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
