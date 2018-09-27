package tonyx.EDI.Common;

final public class UseCode {
	private String ediTableID;
	private String ediDestinationFieldID;
	private String ediMember;

	public String getEdiTableID() {
		return ediTableID;
	}

	public void setEdiTableID(String ediTableID) {
		this.ediTableID = ediTableID;
	}

	public String getEdiDestinationFieldID() {
		return ediDestinationFieldID;
	}

	public void setEdiDestinationFieldID(String ediDestinationFieldID) {
		this.ediDestinationFieldID = ediDestinationFieldID;
	}

	public String getEdiMember() {
		return ediMember;
	}

	public void setEdiMember(String ediMember) {
		this.ediMember = ediMember;
	}
}