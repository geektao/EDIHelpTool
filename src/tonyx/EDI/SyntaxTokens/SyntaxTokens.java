package tonyx.EDI.SyntaxTokens;

import java.util.ArrayList;
import java.util.List;

final public class SyntaxTokens {
	private List<Token> ediToken;

	public SyntaxTokens() {
		ediToken = new ArrayList<Token>();
	}

	public List<Token> getEdiToken() {
		return ediToken;
	}

	public void setEdiToken(Token token) {
		ediToken.add(token);
	}
}
