package tonyx.EDI.SyntaxTokens;

import java.util.ArrayList;
import java.util.List;

final public class Token {
	private String ediCode;
	private List<Range> ediRange;
	private List<String> ediChar;

	public Token() {
		ediRange = new ArrayList<Range>();
		ediChar = new ArrayList<String>();
	}

	public String getEdiCode() {
		return ediCode;
	}

	public void setEdiCode(String ediCode) {
		this.ediCode = ediCode;
	}

	public List<Range> getEdiRange() {
		return ediRange;
	}

	public void setEdiRange(Range range) {
		this.ediRange.add(range);
	}

	public void setEdiChar(String ediChar) {
		this.ediChar.add(ediChar);
	}

	public List<String> getEdiChar() {
		return ediChar;
	}
}
