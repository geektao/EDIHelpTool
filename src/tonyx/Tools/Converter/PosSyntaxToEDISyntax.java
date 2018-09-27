package tonyx.Tools.Converter;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.EDI.Common.EDISyntax.Segment;
import tonyx.EDI.Common.PosSyntax.PosRecord;
import tonyx.Tools.EDIHelp.Config.ReadProperties;

final public class PosSyntaxToEDISyntax  implements SyntaxConverter{
	public MapTreeNode Coverter(MapTreeNode source) {
		MapTreeNode destination = new MapTreeNode(source.getUserObject());
		destination.setActive(true);
		String sourceType = source.getNodeType();

		if ("PosRecord".equals(sourceType)) {
			destination.setNodeType("Segment");
			Segment seg = new Segment();
			PosRecord pos = ((PosRecord) source.getDataObj());
			// core
			seg.setEdiName(ReadProperties.getProperty("Prefix")
					+ pos.getEdiName());
			seg.setEdiDescription(pos.getEdiDescription());
			seg.setEdiActive("1");
			seg.setEdiChildCount("0");
			seg.setEdiNote(pos.getEdiNote());
			// coreRec
			seg.setEdiMax(pos.getEdiMax());
			seg.setEdiLoopCtl(pos.getEdiLoopCtl());
			seg.setEdiGroupChoiceType(pos.getEdiGroupChoiceType());
			seg.setEdiOrderingTag(pos.getEdiOrderingTag());
			seg.setEdiOrderingType(pos.getEdiOrderingType());
			seg.setEdiUsageRelatedFieldName(null);

			// seg
			tonyx.EDI.Common.PosSyntax.BlockSig oBs = pos.getEdiBlockSig();
			tonyx.EDI.Common.EDISyntax.BlockSig nBs = new tonyx.EDI.Common.EDISyntax.BlockSig();
			for (int i = 0; i < 2; i++) {
				oBs.setIndex(i);
				nBs.setIndex(i);

				if (i == 0)
					nBs.setEdiTag("$$$");
				else
					nBs.setEdiTag(oBs.getEdiTag());

				nBs.setEdiTagPos(oBs.getEdiTagPos());
				nBs.setEdiKeyFieldID(oBs.getEdiKeyFieldID());
				nBs.setEdiKeyFieldData(oBs.getEdiKeyFieldData());
				nBs.setEdiKeyFieldAction(oBs.getEdiKeyFieldAction());
			}

			seg.setEdiBlockSig(nBs);
			seg.setEdiWildCard("no");
			seg.setEdiBinary("no");
			seg.setEdiFloat("no");
			seg.setEdiExplicitRule(null);
			seg.setEdiKeyFields(null);

			destination.setDataObj(seg);
			destination.setUserObject(seg.toString());
			return destination;
		} else if ("Field".equals(sourceType)) {
			destination.setNodeType("Field");
			tonyx.EDI.Common.PosSyntax.Field oldfield = (tonyx.EDI.Common.PosSyntax.Field) source
					.getDataObj();
			tonyx.EDI.Common.EDISyntax.Field field = new tonyx.EDI.Common.EDISyntax.Field();
			// core
			field.setEdiName(ReadProperties.getProperty("Prefix")
					+ oldfield.getEdiName());
			field.setEdiDescription(oldfield.getEdiDescription());
			field.setEdiActive("1");
			field.setEdiChildCount("0");
			field.setEdiNote(oldfield.getEdiNote());
			// corefield
			field.setEdiMandatory("no");
			field.setEdiNotUsed(oldfield.getEdiNotUsed());
			field.setEdiFieldNumber(oldfield.getEdiFieldNumber());
			field.setEdiStoreGroup(oldfield.getEdiStoreGroup());
			field.setEdiStoreField(oldfield.getEdiStoreField());
			field.setEdiBusinessName(oldfield.getEdiBusinessName());
			field.setEdiStoreLimit(oldfield.getEdiStoreLimit().clone());
			field.setEdiLink(null);
			field.setEdiExplicitRule(null);
			field.setEdiImplicitRuleDef(null);
			// seg
			field.setEdiElement("0");
			field.setEdiElementOpt("0");
			field.setEdiSubElement("0");
			field.setEdiSubElementOpt("0");
			field.setEdiMinUsage("0");
			field.setEdiMaxUsage("1");
			field.setEdiTreatAsRepeat("no");
			field.setEdiAlwaysOutputDelimiter("no");
			field.setEdiBinary(oldfield.getEdiBinary());

			destination.setUserObject(field.toString());
			destination.setDataObj(field);
			return destination;
		} else if ("Group".equals(sourceType)) {
			destination.setNodeType("Group");
			tonyx.EDI.Common.PosSyntax.Group oldgroup = (tonyx.EDI.Common.PosSyntax.Group) source
					.getDataObj();
			tonyx.EDI.Common.EDISyntax.Group group = new tonyx.EDI.Common.EDISyntax.Group();
			// core
			group.setEdiName(ReadProperties.getProperty("Prefix")
					+ oldgroup.getEdiName());
			group.setEdiDescription(oldgroup.getEdiDescription());
			group.setEdiActive("1");
			group.setEdiChildCount("0");
			group.setEdiNote(oldgroup.getEdiNote());
			// coreGroup
			group.setEdiMin("0");
			group.setEdiMax(oldgroup.getEdiMax());
			group.setEdiPromoteGroup(oldgroup.getEdiPromoteGroup());
			group.setEdiGroupChoiceType(oldgroup.getEdiGroupChoiceType());
			group.setEdiOrderingType(oldgroup.getEdiOrderingType());
			group.setEdiOrderingTag(oldgroup.getEdiOrderingTag());
			group.setEdiExplicitRule(null);
			return destination;
		}
		return null;
	}
}
