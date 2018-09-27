package tonyx.EDI.DBCSTokens;

import java.util.ArrayList;
import java.util.List;

final public class DBCSTokens {
	private String ediCodePageID;
	private List<Token> ediToken;

	public DBCSTokens() {
		ediToken = new ArrayList<Token>();
	}

	public String getEdiCodePageID() {
		return ediCodePageID;
	}

	public void setEdiCodePageID(String ediCodePageID) {
		this.ediCodePageID = ediCodePageID;
	}

	public List<Token> getEdiToken() {
		return ediToken;
	}

	public void setEdiToken(Token ediToken) {
		this.ediToken.add(ediToken);
	}
}
