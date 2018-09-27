package tonyx.EDI.Common.VarDelimSyntax;

public class VarDelimSyntax {
	private String ediFieldDelimiter;
	private String ediQuoteCharacter;
	private String ediQuoteHandling;
	private String ediIncludeColumnNames;
	private String ediCharacterEncoding;
	private String ediRepeatSuppressionCharUsed;
	private String ediRepeatSuppressionChar;
	private Group ediGroup;

	public String getEdiFieldDelimiter() {
		return ediFieldDelimiter;
	}

	public void setEdiFieldDelimiter(String ediFieldDelimiter) {
		this.ediFieldDelimiter = ediFieldDelimiter;
	}

	public String getEdiQuoteCharacter() {
		return ediQuoteCharacter;
	}

	public void setEdiQuoteCharacter(String ediQuoteCharacter) {
		this.ediQuoteCharacter = ediQuoteCharacter;
	}

	public String getEdiQuoteHandling() {
		return ediQuoteHandling;
	}

	public void setEdiQuoteHandling(String ediQuoteHandling) {
		this.ediQuoteHandling = ediQuoteHandling;
	}

	public String getEdiIncludeColumnNames() {
		return ediIncludeColumnNames;
	}

	public void setEdiIncludeColumnNames(String ediIncludeColumnNames) {
		this.ediIncludeColumnNames = ediIncludeColumnNames;
	}

	public String getEdiCharacterEncoding() {
		return ediCharacterEncoding;
	}

	public void setEdiCharacterEncoding(String ediCharacterEncoding) {
		this.ediCharacterEncoding = ediCharacterEncoding;
	}

	public String getEdiRepeatSuppressionCharUsed() {
		return ediRepeatSuppressionCharUsed;
	}

	public void setEdiRepeatSuppressionCharUsed(
			String ediRepeatSuppressionCharUsed) {
		this.ediRepeatSuppressionCharUsed = ediRepeatSuppressionCharUsed;
	}

	public String getEdiRepeatSuppressionChar() {
		return ediRepeatSuppressionChar;
	}

	public void setEdiRepeatSuppressionChar(String ediRepeatSuppressionChar) {
		this.ediRepeatSuppressionChar = ediRepeatSuppressionChar;
	}

	public Group getEdiGroup() {
		return ediGroup;
	}

	public void setEdiGroup(Group ediGroup) {
		this.ediGroup = ediGroup;
	}
}
