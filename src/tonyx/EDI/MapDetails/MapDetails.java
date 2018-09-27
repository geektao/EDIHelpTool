package tonyx.EDI.MapDetails;

final public class MapDetails {
	private VersionControl ediVersionControl;
	private Summary ediSummary;
	private Flags ediFlags;
	private EDIAssociations_IN ediEDIAssociations_IN;
	private EDIAssociations_OUT ediEDIAssociations_OUT;
	private ExplicitRule ediExplicitRule;

	public VersionControl getEdiVersionControl() {
		return ediVersionControl;
	}

	public void setEdiVersionControl(VersionControl ediVersionControl) {
		this.ediVersionControl = ediVersionControl;
	}

	public Summary getEdiSummary() {
		return ediSummary;
	}

	public void setEdiSummary(Summary ediSummary) {
		this.ediSummary = ediSummary;
	}

	public Flags getEdiFlags() {
		return ediFlags;
	}

	public void setEdiFlags(Flags ediFlags) {
		this.ediFlags = ediFlags;
	}

	public ExplicitRule getEdiExplicitRule() {
		return ediExplicitRule;
	}

	public void setEdiExplicitRule(ExplicitRule ediExplicitRule) {
		this.ediExplicitRule = ediExplicitRule;
	}

	public EDIAssociations_IN getEdiEDIAssociations_IN() {
		return ediEDIAssociations_IN;
	}

	public void setEdiEDIAssociations_IN(
			EDIAssociations_IN ediEDIAssociations_IN) {
		this.ediEDIAssociations_IN = ediEDIAssociations_IN;
	}

	public EDIAssociations_OUT getEdiEDIAssociations_OUT() {
		return ediEDIAssociations_OUT;
	}

	public void setEdiEDIAssociations_OUT(
			EDIAssociations_OUT ediEDIAssociations_OUT) {
		this.ediEDIAssociations_OUT = ediEDIAssociations_OUT;
	}
}
