package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private String ediDataSourceName;
	private String ediTableName;
	private List<Column> ediColumn;

	public Table() {
		ediColumn = new ArrayList<Column>();
	}

	public String getEdiDataSourceName() {
		return ediDataSourceName;
	}

	public void setEdiDataSourceName(String ediDataSourceName) {
		this.ediDataSourceName = ediDataSourceName;
	}

	public String getEdiTableName() {
		return ediTableName;
	}

	public void setEdiTableName(String ediTableName) {
		this.ediTableName = ediTableName;
	}

	public List<Column> getEdiColumn() {
		return ediColumn;
	}

	public void setEdiColumn(Column ediColumn) {
		this.ediColumn.add(ediColumn);
	}
}
