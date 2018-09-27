package tonyx.EDI.DBCSTokens;

import java.util.ArrayList;
import java.util.List;

final public class Token {
	private String ediCode;
	private List<LeadByte> ediLeadByte;

	public Token() {
		ediLeadByte = new ArrayList<LeadByte>();
	}

	public String getEdiCode() {
		return ediCode;
	}

	public void setEdiCode(String ediCode) {
		this.ediCode = ediCode;
	}

	public List<LeadByte> getEdiLeadByte() {
		return ediLeadByte;
	}

	public void setEdiLeadByte(LeadByte ediLeadByte) {
		this.ediLeadByte.add(ediLeadByte);
	}
}
