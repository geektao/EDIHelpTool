package tonyx.EDI.Common;

final public class ConditionalRuleDef {
	private String ediRelationCode;
	private String ediRelationIndex;
	private SubjectElement ediSubjectElement;

	public String getEdiRelationCode() {
		return ediRelationCode;
	}

	public void setEdiRelationCode(String ediRelationCode) {
		this.ediRelationCode = ediRelationCode;
	}

	public String getEdiRelationIndex() {
		return ediRelationIndex;
	}

	public void setEdiRelationIndex(String ediRelationIndex) {
		this.ediRelationIndex = ediRelationIndex;
	}

	public SubjectElement getEdiSubjectElement() {
		return ediSubjectElement;
	}

	public void setEdiSubjectElement(SubjectElement ediSubjectElement) {
		this.ediSubjectElement = ediSubjectElement;
	}
}
