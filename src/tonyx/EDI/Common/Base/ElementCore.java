package tonyx.EDI.Common.Base;

public abstract class ElementCore {
	private String ediID = "1";
	private String ediName;
	private String ediDescription;
	private String ediActive;
	private String ediChildCount;
	private String ediNote;
	
	@Override
	public String toString() {
		return "";
	}
	
	public String getEdiID() {
		return ediID;
	}
	public void setEdiID(String ediID) {
		this.ediID = ediID;
	}
	public String getEdiName() {
		return ediName;
	}
	public void setEdiName(String ediName) {
		this.ediName = ediName;
	}
	public String getEdiDescription() {
		return ediDescription;
	}
	public void setEdiDescription(String ediDescription) {
		this.ediDescription = ediDescription;
	}
	public String getEdiActive() {
		return ediActive;
	}
	public void setEdiActive(String ediActive) {
		this.ediActive = ediActive;
	}
	public String getEdiChildCount() {
		return ediChildCount;
	}
	public void setEdiChildCount(String ediChildCount) {
		this.ediChildCount = ediChildCount;
	}
	public String getEdiNote() {
		return ediNote;
	}
	public void setEdiNote(String ediNote) {
		this.ediNote = ediNote;
	}
}
