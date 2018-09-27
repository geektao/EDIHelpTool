package tonyx.EDI.Common.SwiftSyntax;

import tonyx.EDI.Common.ConditionalRuleDef;
import tonyx.EDI.Common.Base.CoreField;

public class Field extends CoreField {
	private String ediStartDelimiter;
	private String ediEndDelimiter;
	private String ediPadLeadingZero;
	private ConditionalRuleDef ediConditionalRuleDef;
	private String ediMinUsage;
	private String ediMaxUsage;

	public String getEdiStartDelimiter() {
		return ediStartDelimiter;
	}

	public void setEdiStartDelimiter(String ediStartDelimiter) {
		this.ediStartDelimiter = ediStartDelimiter;
	}

	public String getEdiEndDelimiter() {
		return ediEndDelimiter;
	}

	public void setEdiEndDelimiter(String ediEndDelimiter) {
		this.ediEndDelimiter = ediEndDelimiter;
	}

	public String getEdiPadLeadingZero() {
		return ediPadLeadingZero;
	}

	public void setEdiPadLeadingZero(String ediPadLeadingZero) {
		this.ediPadLeadingZero = ediPadLeadingZero;
	}

	public ConditionalRuleDef getEdiConditionalRuleDef() {
		return ediConditionalRuleDef;
	}

	public void setEdiConditionalRuleDef(
			ConditionalRuleDef ediConditionalRuleDef) {
		this.ediConditionalRuleDef = ediConditionalRuleDef;
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
}
