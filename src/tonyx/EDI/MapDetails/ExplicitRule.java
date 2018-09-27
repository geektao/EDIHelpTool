package tonyx.EDI.MapDetails;

final public class ExplicitRule {
	private String ediPreSessionRule;
	private String ediPostSessionRule;

	public String getEdiPreSessionRule() {
		return ediPreSessionRule;
	}

	public void setEdiPreSessionRule(String ediPreSessionRule) {
		this.ediPreSessionRule = ediPreSessionRule;
	}

	public String getEdiPostSessionRule() {
		return ediPostSessionRule;
	}

	public void setEdiPostSessionRule(String ediPostSessionRule) {
		this.ediPostSessionRule = ediPostSessionRule;
	}
}
