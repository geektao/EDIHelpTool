package tonyx.EDI.Common;

final public class KeyField implements Cloneable {
	private String ediKeyFieldID;
	private String ediType;
	private String ediData;
	private String ediMatchOnNoMatch;

	@Override
	public KeyField clone() {
		KeyField kf = null;
		try {
			kf = (KeyField) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return kf;
	}

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
