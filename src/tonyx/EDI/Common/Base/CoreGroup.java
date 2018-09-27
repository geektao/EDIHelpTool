package tonyx.EDI.Common.Base;

import tonyx.EDI.Common.ExplicitRule;

public class CoreGroup extends ElementCore{
	private String ediMin = "0";
	private String ediMax;
	private String ediPromoteGroup;
	private String ediGroupChoiceType;//version 8
	private String ediOrderingType;
	private String ediOrderingTag;
	private String ediUsageRelatedFieldName;
	
	private ExplicitRule ediExplicitRule;

	@Override
	public String toString() {
		return this.getEdiName()+" - "+isMandatory()+" - "+this.getEdiMax()+" "+getEdiDescription();
	}
	
	private String isMandatory(){
		if("0".equals(getEdiMin())){
			return "C";
		}
		return "M";
	}
	
	public String getEdiMin() {
		return ediMin;
	}
	public void setEdiMin(String ediMin) {
		this.ediMin = ediMin;
	}
	public String getEdiMax() {
		return ediMax;
	}
	public void setEdiMax(String ediMax) {
		this.ediMax = ediMax;
	}
	public String getEdiPromoteGroup() {
		return ediPromoteGroup;
	}
	public void setEdiPromoteGroup(String ediPromoteGroup) {
		this.ediPromoteGroup = ediPromoteGroup;
	}
	public String getEdiOrderingType() {
		return ediOrderingType;
	}
	public void setEdiOrderingType(String ediOrderingType) {
		this.ediOrderingType = ediOrderingType;
	}
	public String getEdiOrderingTag() {
		return ediOrderingTag;
	}
	public void setEdiOrderingTag(String ediOrderingTag) {
		this.ediOrderingTag = ediOrderingTag;
	}
	public String getEdiUsageRelatedFieldName() {
		return ediUsageRelatedFieldName;
	}
	public void setEdiUsageRelatedFieldName(String ediUsageRelatedFieldName) {
		this.ediUsageRelatedFieldName = ediUsageRelatedFieldName;
	}
	public String getEdiGroupChoiceType() {
		return ediGroupChoiceType;
	}
	public void setEdiGroupChoiceType(String ediGroupChoiceType) {
		this.ediGroupChoiceType = ediGroupChoiceType;
	}
	public ExplicitRule getEdiExplicitRule() {
		return ediExplicitRule;
	}
	public void setEdiExplicitRule(ExplicitRule ediExplicitRule) {
		this.ediExplicitRule = ediExplicitRule;
	}
}
