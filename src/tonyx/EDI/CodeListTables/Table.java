package tonyx.EDI.CodeListTables;

import java.util.ArrayList;
import java.util.List;

final public class Table {
	private String ediTableID;
	private String ediTableDescription;
	private List<Entry> ediEntry;

	public Table() {
		ediEntry = new ArrayList<Entry>();
	}

	public String getEdiTableID() {
		return ediTableID;
	}

	public void setEdiTableID(String ediTableID) {
		this.ediTableID = ediTableID;
	}

	public String getEdiTableDescription() {
		return ediTableDescription;
	}

	public void setEdiTableDescription(String ediTableDescription) {
		this.ediTableDescription = ediTableDescription;
	}

	public List<Entry> getEdiEntry() {
		return ediEntry;
	}

	public void setEdiEntry(Entry entry) {
		this.ediEntry.add(entry);
	}
}
