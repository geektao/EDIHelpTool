package tonyx.EDI.Common.ODBCSyntax;

public class KeyField {
	private String ediKeyFieldID;
	private String ediType;
	private String ediData;
	private String ediMatchOnNoMatch;

	public String getEdiKeyFieldID() {
		return ediKeyFieldID;
	}

	public void setEdiKeyFieldID(String ediKeyFieldID) {
		this.ediKeyFieldID = ediKeyFieldID;
	}

	public String getEdiType() {
		return ediType;
	}

	public void setEdiType(String ediType) {
		this.ediType = ediType;
	}

	public String getEdiData() {
		return ediData;
	}

	public void setEdiData(String ediData) {
		this.ediData = ediData;
	}

	public String getEdiMatchOnNoMatch() {
		return ediMatchOnNoMatch;
	}

	public void setEdiMatchOnNoMatch(String ediMatchOnNoMatch) {
		this.ediMatchOnNoMatch = ediMatchOnNoMatch;
	}
}
