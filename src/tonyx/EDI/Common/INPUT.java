package tonyx.EDI.Common;

import tonyx.EDI.Common.EDISyntax.CHIPSSyntax;
import tonyx.EDI.Common.EDISyntax.EDISyntax;
import tonyx.EDI.Common.EDISyntax.FEDWIRESyntax;
import tonyx.EDI.Common.PosSyntax.PosSyntax;
import tonyx.EDI.Common.XMLSyntax.XMLSyntax;

final public class INPUT {
	private EDISyntax ediEDISyntax;
	private XMLSyntax ediXMLSyntax;
	private PosSyntax ediPosSyntax;
	private CHIPSSyntax ediCHIPSSyntax;
	private FEDWIRESyntax ediFEDWIRESyntax;

	public Object getActiveSgntax() {
		if (ediEDISyntax != null) {
			return ediEDISyntax;
		} else if (ediXMLSyntax != null) {
			return ediXMLSyntax;
		} else if (ediPosSyntax != null) {
			return ediPosSyntax;
		} else if (ediCHIPSSyntax != null) {
			return ediCHIPSSyntax;
		} else if (ediFEDWIRESyntax != null) {
			return ediFEDWIRESyntax;
		}
		return null;
	}

	public EDISyntax getEdiEDISyntax() {
		return ediEDISyntax;
	}

	public void setEdiEDISyntax(EDISyntax ediEDISyntax) {
		this.ediEDISyntax = ediEDISyntax;
	}

	public XMLSyntax getEdiXMLSyntax() {
		return ediXMLSyntax;
	}

	public void setEdiXMLSyntax(XMLSyntax ediXMLSyntax) {
		this.ediXMLSyntax = ediXMLSyntax;
	}

	public PosSyntax getEdiPosSyntax() {
		return ediPosSyntax;
	}

	public void setEdiPosSyntax(PosSyntax ediPosSyntax) {
		this.ediPosSyntax = ediPosSyntax;
	}

	public CHIPSSyntax getEdiCHIPSSyntax() {
		return ediCHIPSSyntax;
	}

	public void setEdiCHIPSSyntax(CHIPSSyntax ediCHIPSSyntax) {
		this.ediCHIPSSyntax = ediCHIPSSyntax;
	}

	public FEDWIRESyntax getEdiFEDWIRESyntax() {
		return ediFEDWIRESyntax;
	}

	public void setEdiFEDWIRESyntax(FEDWIRESyntax ediFEDWIRESyntax) {
		this.ediFEDWIRESyntax = ediFEDWIRESyntax;
	}
}
