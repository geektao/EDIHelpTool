package tonyx.EDI.Common.Base;

public class CoreRec extends ElementCore {
	private String ediMin = "0";
	private String ediMax;
	private String ediLoopCtl;//Possible values are: normal, start, end, and repeat.  Repeat is only available for some syntaxes
	private String ediGroupChoiceType;
	private String ediOrderingType;
	private String ediOrderingTag;
	private String ediUsageRelatedFieldName;
	
	@Override
	public String toString() {
		return this.getEdiName() + " - " + isMandatory() + " - " + getEdiMax()
				+ " " + " " + getEdiDescription();
	}

	private String isMandatory() {
		if ("0".equals(getEdiMin())) {
			return "C";
		}
		return "M";
	}

	public String getEdiMax() {
		return ediMax;
	}

	public void setEdiMax(String ediMax) {
		this.ediMax = ediMax;
	}

	public String getEdiMin() {
		return ediMin;
	}

	public void setEdiMin(String ediMin) {
		this.ediMin = ediMin;
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

	public String getEdiLoopCtl() {
		return ediLoopCtl;
	}

	public void setEdiLoopCtl(String ediLoopCtl) {
		this.ediLoopCtl = ediLoopCtl;
	}

	public String getEdiGroupChoiceType() {
		return ediGroupChoiceType;
	}

	public void setEdiGroupChoiceType(String ediGroupChoiceType) {
		this.ediGroupChoiceType = ediGroupChoiceType;
	}
}
