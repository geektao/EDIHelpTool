package tonyx.EDI.Common.ODBCSyntax;

import tonyx.EDI.Common.Base.CoreField;

public class Field extends CoreField {
	private String ediNullsAllowed;
	private String ediBlockQueryID;
	private String ediColumnNumber;
	private String ediColumnKey;
	private String ediColumnNameID;
	private String ediStatementRecord;
	private String ediTable;
	private String ediInputColumn;
	private String ediOutputColumn;
	private String ediFieldType;

	public String getEdiNullsAllowed() {
		return ediNullsAllowed;
	}

	public void setEdiNullsAllowed(String ediNullsAllowed) {
		this.ediNullsAllowed = ediNullsAllowed;
	}

	public String getEdiBlockQueryID() {
		return ediBlockQueryID;
	}

	public void setEdiBlockQueryID(String ediBlockQueryID) {
		this.ediBlockQueryID = ediBlockQueryID;
	}

	public String getEdiColumnNumber() {
		return ediColumnNumber;
	}

	public void setEdiColumnNumber(String ediColumnNumber) {
		this.ediColumnNumber = ediColumnNumber;
	}

	public String getEdiColumnKey() {
		return ediColumnKey;
	}

	public void setEdiColumnKey(String ediColumnKey) {
		this.ediColumnKey = ediColumnKey;
	}

	public String getEdiColumnNameID() {
		return ediColumnNameID;
	}

	public void setEdiColumnNameID(String ediColumnNameID) {
		this.ediColumnNameID = ediColumnNameID;
	}

	public String getEdiStatementRecord() {
		return ediStatementRecord;
	}

	public void setEdiStatementRecord(String ediStatementRecord) {
		this.ediStatementRecord = ediStatementRecord;
	}

	public String getEdiTable() {
		return ediTable;
	}

	public void setEdiTable(String ediTable) {
		this.ediTable = ediTable;
	}

	public String getEdiInputColumn() {
		return ediInputColumn;
	}

	public void setEdiInputColumn(String ediInputColumn) {
		this.ediInputColumn = ediInputColumn;
	}

	public String getEdiOutputColumn() {
		return ediOutputColumn;
	}

	public void setEdiOutputColumn(String ediOutputColumn) {
		this.ediOutputColumn = ediOutputColumn;
	}

	public String getEdiFieldType() {
		return ediFieldType;
	}

	public void setEdiFieldType(String ediFieldType) {
		this.ediFieldType = ediFieldType;
	}
}
