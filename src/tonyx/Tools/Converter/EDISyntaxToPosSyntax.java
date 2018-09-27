package tonyx.Tools.Converter;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.EDI.Common.EDISyntax.Segment;
import tonyx.EDI.Common.PosSyntax.PosRecord;
import tonyx.Tools.EDIHelp.Config.ReadProperties;

final public class EDISyntaxToPosSyntax  implements SyntaxConverter{

	public MapTreeNode Coverter(MapTreeNode source) {
		MapTreeNode destination = new MapTreeNode(source.getUserObject());
		destination.setActive(true);
		String sourceType = source.getNodeType();

		if ("Segment".equals(sourceType)) {
			destination.setNodeType("PosRecord");
			Segment seg = (Segment) source.getDataObj();
			PosRecord pr = new PosRecord();
			pr.setEdiName(seg.getEdiName());
			// core
			pr.setEdiName(ReadProperties.getProperty("Prefix")
					+ pr.getEdiName());
			pr.setEdiDescription(seg.getEdiDescription());
			pr.setEdiActive("1");
			pr.setEdiChildCount("0");
			pr.setEdiNote(seg.getEdiNote());
			// coreRec
			pr.setEdiMax(seg.getEdiMax());
			pr.setEdiLoopCtl(seg.getEdiLoopCtl());
			pr.setEdiGroupChoiceType(seg.getEdiGroupChoiceType());
			pr.setEdiOrderingTag(seg.getEdiOrderingTag());
			pr.setEdiOrderingType(seg.getEdiOrderingType());
			pr.setEdiUsageRelatedFieldName(null);
			// pos
			tonyx.EDI.Common.EDISyntax.BlockSig oBs = seg.getEdiBlockSig();
			tonyx.EDI.Common.PosSyntax.BlockSig nBs = new tonyx.EDI.Common.PosSyntax.BlockSig();
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

			pr.setEdiBlockSig(nBs);
			pr.setEdiExplicitRule(null);
			pr.setEdiKeyFields(null);
			pr.setEdiTagLength("0");

			destination.setDataObj(pr);
			destination.setUserObject(pr.toString());
			return destination;
		} else if ("Composite".equals(sourceType)) {
			return null;
		} else if ("Field".equals(sourceType)) {
			destination.setNodeType("Field");
			tonyx.EDI.Common.PosSyntax.Field field = new tonyx.EDI.Common.PosSyntax.Field();
			tonyx.EDI.Common.EDISyntax.Field oldfield = (tonyx.EDI.Common.EDISyntax.Field) source
					.getDataObj();

			// core
			field.setEdiName(ReadProperties.getProperty("Prefix")
					+ oldfield.getEdiName());
			field.setEdiDescription(oldfield.getEdiDescription());
			field.setEdiActive("1");
			field.setEdiChildCount("0");
			field.setEdiNote(oldfield.getEdiNote());

			// coreField
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
			// pos
			field.setEdiConditionalRuleDef(null);
			field.setEdiStartPos("0");
			field.setEdiLength(oldfield.getEdiStoreLimit().getEdiMaxLen());
			field.setEdiJustify("left");
			field.setEdiPadChar("SP");
			field.setEdiPadHighByte("0");
			field.setEdiBinary("0");

			destination.setDataObj(field);
			destination.setUserObject(field.toString());
			return destination;
		} else if ("Group".equals(sourceType)) {
			destination.setNodeType("Group");
			tonyx.EDI.Common.EDISyntax.Group oldgroup = (tonyx.EDI.Common.EDISyntax.Group) source
					.getDataObj();
			tonyx.EDI.Common.PosSyntax.Group group = new tonyx.EDI.Common.PosSyntax.Group();
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

			destination.setUserObject(group.toString());
			destination.setDataObj(group);
			return destination;
		}
		return null;
	}
}
