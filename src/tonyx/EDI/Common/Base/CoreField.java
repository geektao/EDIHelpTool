package tonyx.EDI.Common.Base;

import tonyx.EDI.Common.ImplicitRuleDef;
import tonyx.EDI.Common.StoreLimit;

public class CoreField extends ElementCore {
	private String ediMandatory;
	private String ediNotUsed;
	private String ediFieldNumber;
	private String ediStoreGroup;
	private String ediStoreField;
	private String ediBusinessName;
	private StoreLimit ediStoreLimit;
	private String ediLink;
	private String ediExplicitRule;
	private ImplicitRuleDef ediImplicitRuleDef;
	
	public String getEdiMandatory() {
		return ediMandatory;
	}
	public void setEdiMandatory(String ediMandatory) {
		this.ediMandatory = ediMandatory;
	}
	public String getEdiNotUsed() {
		return ediNotUsed;
	}
	public void setEdiNotUsed(String ediNotUsed) {
		this.ediNotUsed = ediNotUsed;
	}
	public String getEdiFieldNumber() {
		return ediFieldNumber;
	}
	public void setEdiFieldNumber(String ediFieldNumber) {
		this.ediFieldNumber = ediFieldNumber;
	}
	public String getEdiStoreGroup() {
		return ediStoreGroup;
	}
	public void setEdiStoreGroup(String ediStoreGroup) {
		this.ediStoreGroup = ediStoreGroup;
	}
	public String getEdiStoreField() {
		return ediStoreField;
	}
	public void setEdiStoreField(String ediStoreField) {
		this.ediStoreField = ediStoreField;
	}
	public String getEdiBusinessName() {
		return ediBusinessName;
	}
	public void setEdiBusinessName(String ediBusinessName) {
		this.ediBusinessName = ediBusinessName;
	}
	public StoreLimit getEdiStoreLimit() {
		return ediStoreLimit;
	}
	public void setEdiStoreLimit(StoreLimit ediStoreLimit) {
		this.ediStoreLimit = ediStoreLimit;
	}
	public String getEdiLink() {
		return ediLink;
	}
	public void setEdiLink(String ediLink) {
		this.ediLink = ediLink;
	}
	public String getEdiExplicitRule() {
		return ediExplicitRule;
	}
	public void setEdiExplicitRule(String ediExplicitRule) {
		this.ediExplicitRule = ediExplicitRule;
	}
	public ImplicitRuleDef getEdiImplicitRuleDef() {
		return ediImplicitRuleDef;
	}
	public void setEdiImplicitRuleDef(ImplicitRuleDef ediImplicitRuleDef) {
		this.ediImplicitRuleDef = ediImplicitRuleDef;
	}
}
