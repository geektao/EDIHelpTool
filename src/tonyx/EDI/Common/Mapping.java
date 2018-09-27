package tonyx.EDI.Common;

import java.util.ArrayList;
import java.util.List;

final public class Mapping {
	private String ediMapFrom;
	private List<String> ediToFieldID;

	public Mapping() {
		ediToFieldID = new ArrayList<String>();
	}

	public String getEdiMapFrom() {
		return ediMapFrom;
	}

	public void setEdiMapFrom(String ediMapFrom) {
		this.ediMapFrom = ediMapFrom;
	}

	public void setEdiToFieldID(String ediToFieldID) {
		this.ediToFieldID.add(ediToFieldID);
	}

	public List<String> getEdiToFieldID() {
		return ediToFieldID;
	}
}
