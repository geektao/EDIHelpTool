package tonyx.EDI.DBCSTokens;

final public class LeadByte {
	private String ediLeadByteID;
	private String ediTrailBytes;

	public String getEdiLeadByteID() {
		return ediLeadByteID;
	}

	public void setEdiLeadByteID(String ediLeadByteID) {
		this.ediLeadByteID = ediLeadByteID;
	}

	public String getEdiTrailBytes() {
		return ediTrailBytes;
	}

	public void setEdiTrailBytes(String ediTrailBytes) {
		this.ediTrailBytes = ediTrailBytes;
	}
}
