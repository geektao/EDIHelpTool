package tonyx.Tools.Converter;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.EDI.Common.XMLSyntax.Field;
import tonyx.EDI.Common.XMLSyntax.XMLElementGroup;
import tonyx.EDI.Common.XMLSyntax.XMLParticleGroup;
import tonyx.EDI.Common.XMLSyntax.XMLRecord;
import tonyx.Tools.EDIHelp.Config.ReadProperties;

final public class XMLSyntaxToXMLSyntax  implements SyntaxConverter{
	public MapTreeNode Coverter(MapTreeNode source) {
		MapTreeNode destination = new MapTreeNode(source.getUserObject());
		destination.setActive(true);
		String sourceType = source.getNodeType();

		if ("Field".equals(sourceType)) {
			destination.setNodeType("Field");

			Field field = ((Field) source.getDataObj()).clone();
			field.setEdiName(ReadProperties.getProperty("Prefix")
					+ field.getEdiName());
			field.setEdiActive("1");
			field.setEdiChildCount("0");
			field.setEdiExplicitRule(null);
			field.setEdiMandatory("no");
			field.setEdiImplicitRuleDef(null);
			field.setEdiLink(null);

			destination.setDataObj(field);
			destination.setUserObject(field.toString());
			return destination;
		} else if ("XMLRecord".equals(sourceType)) {
			destination.setNodeType("XMLRecord");
			XMLRecord xr = ((XMLRecord) source.getDataObj()).clone();
			xr.setEdiName(ReadProperties.getProperty("Prefix")
					+ xr.getEdiName());
			xr.setEdiActive("1");
			xr.setEdiChildCount("0");
			xr.setEdiMin("0");
			xr.setEdiExplicitRule(null);
			xr.setEdiKeyFields(null);

			destination.setDataObj(xr);
			destination.setUserObject(xr.toString());
			return destination;
		} else if ("XMLParticleGroup".equals(sourceType)) {
			destination.setNodeType("XMLParticleGroup");
			XMLParticleGroup xpg = ((XMLParticleGroup) source.getDataObj())
					.clone();
			xpg.setEdiName(ReadProperties.getProperty("Prefix")
					+ xpg.getEdiName());
			xpg.setEdiActive("1");
			xpg.setEdiChildCount("0");
			xpg.setEdiMin("0");
			xpg.setEdiExplicitRule(null);

			destination.setDataObj(xpg);
			destination.setUserObject(xpg.toString());
			return destination;
		} else if ("XMLElementGroup".equals(sourceType)) {
			destination.setNodeType("XMLElementGroup");
			XMLElementGroup xeg = ((XMLElementGroup) source.getDataObj())
					.clone();
			xeg.setEdiName(ReadProperties.getProperty("Prefix")
					+ xeg.getEdiName());
			xeg.setEdiActive("1");
			xeg.setEdiChildCount("0");
			xeg.setEdiMin("0");
			xeg.setEdiExplicitRule(null);

			destination.setDataObj(xeg);
			destination.setUserObject(xeg.toString());
			return destination;
		}

		return null;
	}
}
