package tonyx.EDI.Common.XMLSyntax;

import java.io.Serializable;

final public class NameSpacePrefix implements Serializable {
	private static final long serialVersionUID = -6979852583115400592L;
	private String ediPrefix;
	private String ediURI;

	public String getEdiPrefix() {
		return ediPrefix;
	}

	public void setEdiPrefix(String ediPrefix) {
		this.ediPrefix = ediPrefix;
	}

	public String getEdiURI() {
		return ediURI;
	}

	public void setEdiURI(String ediURI) {
		this.ediURI = ediURI;
	}
}
