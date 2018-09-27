package tonyx.EDI.Common.SPEC2000Syntax;

import tonyx.EDI.Common.ConditionalRuleDef;
import tonyx.EDI.Common.Base.CoreField;

public class Field extends CoreField implements Cloneable {
	private ConditionalRuleDef ediConditionalRuleDef;
	private String ediElement;
	private String ediElementOpt;
	private String ediSubElement;
	private String ediSubElementOpt;
	private String ediMinUsage;
	private String ediMaxUsage;
	private String ediBinary;
	private String ediTreatAsRepeat;
	private String ediAlwaysOutputDelimiter;

	@Override
	public String toString() {
		return this.getEdiName() + " - " + isMandatory() + " - "
				+ getEdiStoreLimit().getEdiDataType() + " "
				+ getEdiStoreLimit().getEdiMaxLen() + " " + getEdiDescription();
	}

	private String isMandatory() {
		if ("0".equals(getEdiMinUsage())) {
			return "C";
		}
		return "M";
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

	public String getEdiElement() {
		return ediElement;
	}

	public void setEdiElement(String ediElement) {
		this.ediElement = ediElement;
	}

	public String getEdiElementOpt() {
		return ediElementOpt;
	}

	public void setEdiElementOpt(String ediElementOpt) {
		this.ediElementOpt = ediElementOpt;
	}

	public String getEdiSubElement() {
		return ediSubElement;
	}

	public void setEdiSubElement(String ediSubElement) {
		this.ediSubElement = ediSubElement;
	}

	public String getEdiSubElementOpt() {
		return ediSubElementOpt;
	}

	public void setEdiSubElementOpt(String ediSubElementOpt) {
		this.ediSubElementOpt = ediSubElementOpt;
	}

	public String getEdiMinUsage() {
		return ediMinUsage;
	}

	public void setEdiMinUsage(String ediMinUsage) {
		this.ediMinUsage = ediMinUsage;
	}

	public String getEdiMaxUsage() {
		return ediMaxUsage;
	}

	public void setEdiMaxUsage(String ediMaxUsage) {
		this.ediMaxUsage = ediMaxUsage;
	}

	public String getEdiTreatAsRepeat() {
		return ediTreatAsRepeat;
	}

	public void setEdiTreatAsRepeat(String ediTreatAsRepeat) {
		this.ediTreatAsRepeat = ediTreatAsRepeat;
	}

	public String getEdiAlwaysOutputDelimiter() {
		return ediAlwaysOutputDelimiter;
	}

	public void setEdiAlwaysOutputDelimiter(String ediAlwaysOutputDelimiter) {
		this.ediAlwaysOutputDelimiter = ediAlwaysOutputDelimiter;
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
