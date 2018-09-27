package tonyx.EDI.Common;

final public class UseUpdate {
	private String ediTableName;
	private String ediSubTableNameConstantID;
	private String ediMapFrom;

	public String getEdiTableName() {
		return ediTableName;
	}

	public void setEdiTableName(String ediTableName) {
		this.ediTableName = ediTableName;
	}

	public String getEdiSubTableNameConstantID() {
		return ediSubTableNameConstantID;
	}

	public void setEdiSubTableNameConstantID(String ediSubTableNameConstantID) {
		this.ediSubTableNameConstantID = ediSubTableNameConstantID;
	}

	public String getEdiMapFrom() {
		return ediMapFrom;
	}

	public void setEdiMapFrom(String ediMapFrom) {
		this.ediMapFrom = ediMapFrom;
	}
}
