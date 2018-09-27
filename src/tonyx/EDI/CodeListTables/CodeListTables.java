package tonyx.EDI.CodeListTables;

import java.util.ArrayList;
import java.util.List;

final public class CodeListTables {
	private List<Table> ediTable;

	public CodeListTables() {
		ediTable = new ArrayList<Table>();
	}

	public List<Table> getEdiTable() {
		return ediTable;
	}

	public void setEdiTable(Table table) {
		this.ediTable.add(table);
	}
}
