package tonyx.EDI.Common;

import java.util.ArrayList;
import java.util.List;

final public class UseSelect {
	private String ediTableName;
	private String ediSubTableNameConstantID;
	private String ediMember;
	private List<Mapping> ediMapping;

	public UseSelect() {
		ediMapping = new ArrayList<Mapping>();
	}

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

	public String getEdiMember() {
		return ediMember;
	}

	public void setEdiMember(String ediMember) {
		this.ediMember = ediMember;
	}

	public void setEdiMapping(Mapping ediMapping) {
		this.ediMapping.add(ediMapping);
	}

	public List<Mapping> getEdiMapping() {
		return ediMapping;
	}
}
