package tonyx.EDI.Common.PosSyntax;

import tonyx.EDI.Common.ConditionalRuleDef;
import tonyx.EDI.Common.Base.CoreField;

final public class Field extends CoreField implements Cloneable {
	private ConditionalRuleDef ediConditionalRuleDef;
	private String ediStartPos;
	private String ediLength;
	private String ediJustify;
	private String ediPadChar;
	private String ediPadHighByte;
	private String ediBinary;

	@Override
	public String toString() {
		return this.getEdiName() + " - " + isMandatory() + " - "
				+ getEdiStoreLimit().getEdiDataType() + " "
				+ getEdiStoreLimit().getEdiMaxLen() + " " + getEdiDescription();
	}

	private String isMandatory() {
		if ("yes".equals(getEdiMandatory())) {
			return "M";
		}
		return "C";
	}

	@Override
	public Field clone() {
		Field field = null;
		try {
			field = (Field) super.clone();
			field.setEdiStoreLimit(field.getEdiStoreLimit().clone());
			field.setEdiExplicitRule(null);
			field.setEdiImplicitRuleDef(null);
			field.setEdiConditionalRuleDef(null);
			field.setEdiLink(null);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return field;
	}

	public String getEdiStartPos() {
		return ediStartPos;
	}

	public void setEdiStartPos(String ediStartPos) {
		this.ediStartPos = ediStartPos;
	}

	public String getEdiLength() {
		return ediLength;
	}

	public void setEdiLength(String ediLength) {
		this.ediLength = ediLength;
	}

	public String getEdiJustify() {
		return ediJustify;
	}

	public void setEdiJustify(String ediJustify) {
		this.ediJustify = ediJustify;
	}

	public String getEdiPadChar() {
		return ediPadChar;
	}

	public void setEdiPadChar(String ediPadChar) {
		this.ediPadChar = ediPadChar;
	}

	public String getEdiPadHighByte() {
		return ediPadHighByte;
	}

	public void setEdiPadHighByte(String ediPadHighByte) {
		this.ediPadHighByte = ediPadHighByte;
	}

	public String getEdiBinary() {
		return ediBinary;
	}

	public void setEdiBinary(String ediBinary) {
		this.ediBinary = ediBinary;
	}

	public ConditionalRuleDef getEdiConditionalRuleDef() {
		return ediConditionalRuleDef;
	}

	public void setEdiConditionalRuleDef(
			ConditionalRuleDef ediConditionalRuleDef) {
		this.ediConditionalRuleDef = ediConditionalRuleDef;
	}
}