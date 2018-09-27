package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

public class Query {
	private String ediDataSource;
	private String ediSQL;
	private String ediType;
	private String ediStoredProcedure;
	private List<Column> ediColumn;

	public Query() {
		ediColumn = new ArrayList<Column>();
	}

	public List<Column> getEdiColumn() {
		return ediColumn;
	}

	public void setEdiColumn(Column ediColumn) {
		this.ediColumn.add(ediColumn);
	}

	public String getEdiDataSource() {
		return ediDataSource;
	}

	public void setEdiDataSource(String ediDataSource) {
		this.ediDataSource = ediDataSource;
	}

	public String getEdiSQL() {
		return ediSQL;
	}

	public void setEdiSQL(String ediSQL) {
		this.ediSQL = ediSQL;
	}

	public String getEdiType() {
		return ediType;
	}

	public void setEdiType(String ediType) {
		this.ediType = ediType;
	}

	public String getEdiStoredProcedure() {
		return ediStoredProcedure;
	}

	public void setEdiStoredProcedure(String ediStoredProcedure) {
		this.ediStoredProcedure = ediStoredProcedure;
	}
}
