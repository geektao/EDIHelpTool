package tonyx.EDI.Common.SwiftSyntax;

public class SwiftSyntax {
	private String ediCharacterEncoding;
	private String ediMessageType;
	private String ediMarketPracticeID;
	private Group ediGroup;

	public String getEdiCharacterEncoding() {
		return ediCharacterEncoding;
	}

	public void setEdiCharacterEncoding(String ediCharacterEncoding) {
		this.ediCharacterEncoding = ediCharacterEncoding;
	}

	public String getEdiMessageType() {
		return ediMessageType;
	}

	public void setEdiMessageType(String ediMessageType) {
		this.ediMessageType = ediMessageType;
	}

	public String getEdiMarketPracticeID() {
		return ediMarketPracticeID;
	}

	public void setEdiMarketPracticeID(String ediMarketPracticeID) {
		this.ediMarketPracticeID = ediMarketPracticeID;
	}

	public Group getEdiGroup() {
		return ediGroup;
	}

	public void setEdiGroup(Group ediGroup) {
		this.ediGroup = ediGroup;
	}
}
