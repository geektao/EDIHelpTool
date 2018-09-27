package tonyx.EDI.Common;

import java.util.ArrayList;
import java.util.List;

final public class SubjectElement {
	private List<String> ediFieldID;

	public SubjectElement() {
		ediFieldID = new ArrayList<String>();
	}

	public List<String> getEdiFieldID() {
		return ediFieldID;
	}

	public void setEdiFieldID(String ediFieldID) {
		this.ediFieldID.add(ediFieldID);
	}
}
