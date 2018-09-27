package tonyx.EDI.MapDetails;

final public class Flags {
	private String ediSystemTemplate;
	private String ediUseBigDecimal;
	private String ediInitializeExtendedRuleVariables;
	private String ediErrorForNotUsed;
	// v8
	private String ediSuspendGroupProcessing;

	private String ediSWIFTValidation;
	private String ediUseConfigurableTrimming;
	private String ediCompatibleRuleExecution;
	private String ediKeepTrailingZeroes;

	public String getEdiSystemTemplate() {
		return ediSystemTemplate;
	}

	public void setEdiSystemTemplate(String ediSystemTemplate) {
		this.ediSystemTemplate = ediSystemTemplate;
	}

	public String getEdiUseBigDecimal() {
		return ediUseBigDecimal;
	}

	public void setEdiUseBigDecimal(String ediUseBigDecimal) {
		this.ediUseBigDecimal = ediUseBigDecimal;
	}

	public String getEdiInitializeExtendedRuleVariables() {
		return ediInitializeExtendedRuleVariables;
	}

	public void setEdiInitializeExtendedRuleVariables(
			String ediInitializeExtendedRuleVariables) {
		this.ediInitializeExtendedRuleVariables = ediInitializeExtendedRuleVariables;
	}

	public String getEdiErrorForNotUsed() {
		return ediErrorForNotUsed;
	}

	public void setEdiErrorForNotUsed(String ediErrorForNotUsed) {
		this.ediErrorForNotUsed = ediErrorForNotUsed;
	}

	public String getEdiSWIFTValidation() {
		return ediSWIFTValidation;
	}

	public void setEdiSWIFTValidation(String ediSWIFTValidation) {
		this.ediSWIFTValidation = ediSWIFTValidation;
	}

	public String getEdiUseConfigurableTrimming() {
		return ediUseConfigurableTrimming;
	}

	public void setEdiUseConfigurableTrimming(String ediUseConfigurableTrimming) {
		this.ediUseConfigurableTrimming = ediUseConfigurableTrimming;
	}

	public String getEdiCompatibleRuleExecution() {
		return ediCompatibleRuleExecution;
	}

	public void setEdiCompatibleRuleExecution(String ediCompatibleRuleExecution) {
		this.ediCompatibleRuleExecution = ediCompatibleRuleExecution;
	}

	public String getEdiKeepTrailingZeroes() {
		return ediKeepTrailingZeroes;
	}

	public void setEdiKeepTrailingZeroes(String ediKeepTrailingZeroes) {
		this.ediKeepTrailingZeroes = ediKeepTrailingZeroes;
	}

	public String getEdiSuspendGroupProcessing() {
		return ediSuspendGroupProcessing;
	}

	public void setEdiSuspendGroupProcessing(String ediSuspendGroupProcessing) {
		this.ediSuspendGroupProcessing = ediSuspendGroupProcessing;
	}
}
