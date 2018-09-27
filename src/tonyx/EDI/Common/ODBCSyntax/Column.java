package tonyx.EDI.Common.ODBCSyntax;

import tonyx.EDI.Common.StoreLimit;

final public class Column {
	private String ediName;
	private String ediSQLType;
	private String ediPrecision;
	private String ediScale;
	private String ediNullability;
	private StoreLimit ediStoreLimit;

	public String getEdiName() {
		return ediName;
	}

	public void setEdiName(String ediName) {
		this.ediName = ediName;
	}

	public String getEdiSQLType() {
		return ediSQLType;
	}

	public void setEdiSQLType(String ediSQLType) {
		this.ediSQLType = ediSQLType;
	}

	public String getEdiPrecision() {
		return ediPrecision;
	}

	public void setEdiPrecision(String ediPrecision) {
		this.ediPrecision = ediPrecision;
	}

	public String getEdiScale() {
		return ediScale;
	}

	public void setEdiScale(String ediScale) {
		this.ediScale = ediScale;
	}

	public String getEdiNullability() {
		return ediNullability;
	}

	public void setEdiNullability(String ediNullability) {
		this.ediNullability = ediNullability;
	}

	public StoreLimit getEdiStoreLimit() {
		return ediStoreLimit;
	}

	public void setEdiStoreLimit(StoreLimit ediStoreLimit) {
		this.ediStoreLimit = ediStoreLimit;
	}
}
