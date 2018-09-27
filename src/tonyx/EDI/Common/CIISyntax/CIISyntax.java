package tonyx.EDI.Common.CIISyntax;

public class CIISyntax {
	private String ediDividingMode;
	private String ediNonTransparentMode;
	private String ediAlwaysOutputLoopRepeat;
	private String ediCharset8Bit;
	private String ediCharset16Bit;
	private Group ediGroup;

	public String getEdiDividingMode() {
		return ediDividingMode;
	}

	public void setEdiDividingMode(String ediDividingMode) {
		this.ediDividingMode = ediDividingMode;
	}

	public String getEdiNonTransparentMode() {
		return ediNonTransparentMode;
	}

	public void setEdiNonTransparentMode(String ediNonTransparentMode) {
		this.ediNonTransparentMode = ediNonTransparentMode;
	}

	public String getEdiAlwaysOutputLoopRepeat() {
		return ediAlwaysOutputLoopRepeat;
	}

	public void setEdiAlwaysOutputLoopRepeat(String ediAlwaysOutputLoopRepeat) {
		this.ediAlwaysOutputLoopRepeat = ediAlwaysOutputLoopRepeat;
	}

	public String getEdiCharset8Bit() {
		return ediCharset8Bit;
	}

	public void setEdiCharset8Bit(String ediCharset8Bit) {
		this.ediCharset8Bit = ediCharset8Bit;
	}

	public String getEdiCharset16Bit() {
		return ediCharset16Bit;
	}

	public void setEdiCharset16Bit(String ediCharset16Bit) {
		this.ediCharset16Bit = ediCharset16Bit;
	}

	public Group getEdiGroup() {
		return ediGroup;
	}

	public void setEdiGroup(Group ediGroup) {
		this.ediGroup = ediGroup;
	}
}
