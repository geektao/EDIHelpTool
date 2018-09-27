package tonyx.EDI.Common.XMLSyntax;

import tonyx.EDI.Common.Base.CoreField;

final public class Field extends CoreField implements Cloneable {
	private String ediFieldType;
	private String ediAttrType;
	private String ediAttrBehavior;
	private String ediEntityType;
	private String ediGeneralEntity;
	private String ediParsedEntity;
	private String ediDefault;
	private String ediTag;
	private String ediNamespace;
	private String ediUseParentNamespace;
	private String ediPublicID;
	private String ediSystemLiteral;
	private String ediValue;

	@Override
	public String toString() {
		String rvalue = isMandatory() + " - "
				+ getEdiStoreLimit().getEdiDataType() + " "
				+ getEdiStoreLimit().getEdiMaxLen();
		if ("ATTRIBUTE".equals(ediFieldType)) {
			return this.getEdiName() + " - " + rvalue;
		}
		return rvalue;
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
			field.setEdiLink(null);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return field;
	}

	public String getEdiFieldType() {
		return ediFieldType;
	}

	public void setEdiFieldType(String ediFieldType) {
		this.ediFieldType = ediFieldType;
	}

	public String getEdiAttrType() {
		return ediAttrType;
	}

	public void setEdiAttrType(String ediAttrType) {
		this.ediAttrType = ediAttrType;
	}

	public String getEdiAttrBehavior() {
		return ediAttrBehavior;
	}

	public void setEdiAttrBehavior(String ediAttrBehavior) {
		this.ediAttrBehavior = ediAttrBehavior;
	}

	public String getEdiEntityType() {
		return ediEntityType;
	}

	public void setEdiEntityType(String ediEntityType) {
		this.ediEntityType = ediEntityType;
	}

	public String getEdiGeneralEntity() {
		return ediGeneralEntity;
	}

	public void setEdiGeneralEntity(String ediGeneralEntity) {
		this.ediGeneralEntity = ediGeneralEntity;
	}

	public String getEdiParsedEntity() {
		return ediParsedEntity;
	}

	public void setEdiParsedEntity(String ediParsedEntity) {
		this.ediParsedEntity = ediParsedEntity;
	}

	public String getEdiDefault() {
		return ediDefault;
	}

	public void setEdiDefault(String ediDefault) {
		this.ediDefault = ediDefault;
	}

	public String getEdiTag() {
		return ediTag;
	}

	public void setEdiTag(String ediTag) {
		this.ediTag = ediTag;
	}

	public String getEdiNamespace() {
		return ediNamespace;
	}

	public void setEdiNamespace(String ediNamespace) {
		this.ediNamespace = ediNamespace;
	}

	public String getEdiUseParentNamespace() {
		return ediUseParentNamespace;
	}

	public void setEdiUseParentNamespace(String ediUseParentNamespace) {
		this.ediUseParentNamespace = ediUseParentNamespace;
	}

	public String getEdiPublicID() {
		return ediPublicID;
	}

	public void setEdiPublicID(String ediPublicID) {
		this.ediPublicID = ediPublicID;
	}

	public String getEdiSystemLiteral() {
		return ediSystemLiteral;
	}

	public void setEdiSystemLiteral(String ediSystemLiteral) {
		this.ediSystemLiteral = ediSystemLiteral;
	}

	public String getEdiValue() {
		return ediValue;
	}

	public void setEdiValue(String ediValue) {
		this.ediValue = ediValue;
	}
}
