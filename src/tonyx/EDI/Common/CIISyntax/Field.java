package tonyx.EDI.Common.CIISyntax;

import tonyx.EDI.Common.Base.CoreField;

public class Field extends CoreField {
	private String ediBinary;
	private String ediCharacterset;

	public String getEdiBinary() {
		return ediBinary;
	}
	public void setEdiBinary(String ediBinary) {
		this.ediBinary = ediBinary;
	}
	public String getEdiCharacterset() {
		return ediCharacterset;
	}
	public void setEdiCharacterset(String ediCharacterset) {
		this.ediCharacterset = ediCharacterset;
	}
}
