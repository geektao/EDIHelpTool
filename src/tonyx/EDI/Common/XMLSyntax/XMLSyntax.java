package tonyx.EDI.Common.XMLSyntax;

final public class XMLSyntax {
	private String ediOutputFormat;
	private String ediSystemID;
	private String ediPublicID;
	private String ediOutputHeader;
	private String ediJavaEncoding;
	private String ediUseCharEntityRef;
	private String ediUseDecimalPointChar;
	private String ediDecimalPointChar;
	private String ediEnableNamespaces;
	private String ediAllowEmptyMandatorySequences;
	private String ediTrimPCData;

	private XMLElementGroup ediXMLElementGroup;

	public String getEdiOutputFormat() {
		return ediOutputFormat;
	}

	public void setEdiOutputFormat(String ediOutputFormat) {
		this.ediOutputFormat = ediOutputFormat;
	}

	public String getEdiOutputHeader() {
		return ediOutputHeader;
	}

	public void setEdiOutputHeader(String ediOutputHeader) {
		this.ediOutputHeader = ediOutputHeader;
	}

	public String getEdiUseCharEntityRef() {
		return ediUseCharEntityRef;
	}

	public void setEdiUseCharEntityRef(String ediUseCharEntityRef) {
		this.ediUseCharEntityRef = ediUseCharEntityRef;
	}

	public String getEdiUseDecimalPointChar() {
		return ediUseDecimalPointChar;
	}

	public void setEdiUseDecimalPointChar(String ediUseDecimalPointChar) {
		this.ediUseDecimalPointChar = ediUseDecimalPointChar;
	}

	public String getEdiDecimalPointChar() {
		return ediDecimalPointChar;
	}

	public void setEdiDecimalPointChar(String ediDecimalPointChar) {
		this.ediDecimalPointChar = ediDecimalPointChar;
	}

	public String getEdiEnableNamespaces() {
		return ediEnableNamespaces;
	}

	public void setEdiEnableNamespaces(String ediEnableNamespaces) {
		this.ediEnableNamespaces = ediEnableNamespaces;
	}

	public String getEdiAllowEmptyMandatorySequences() {
		return ediAllowEmptyMandatorySequences;
	}

	public void setEdiAllowEmptyMandatorySequences(
			String ediAllowEmptyMandatorySequences) {
		this.ediAllowEmptyMandatorySequences = ediAllowEmptyMandatorySequences;
	}

	public String getEdiTrimPCData() {
		return ediTrimPCData;
	}

	public void setEdiTrimPCData(String ediTrimPCData) {
		this.ediTrimPCData = ediTrimPCData;
	}

	// -----------------------------------------------
	public XMLElementGroup getEdiGroup() {
		return ediXMLElementGroup;
	}

	public XMLElementGroup getEdiXMLElementGroup() {
		return ediXMLElementGroup;
	}

	// -------------------------------------------------

	public void setEdiXMLElementGroup(XMLElementGroup ediXMLElementGroup) {
		this.ediXMLElementGroup = ediXMLElementGroup;
	}

	public String getEdiSystemID() {
		return ediSystemID;
	}

	public void setEdiSystemID(String ediSystemID) {
		this.ediSystemID = ediSystemID;
	}

	public String getEdiPublicID() {
		return ediPublicID;
	}

	public void setEdiPublicID(String ediPublicID) {
		this.ediPublicID = ediPublicID;
	}

	public String getEdiJavaEncoding() {
		return ediJavaEncoding;
	}

	public void setEdiJavaEncoding(String ediJavaEncoding) {
		this.ediJavaEncoding = ediJavaEncoding;
	}
}
