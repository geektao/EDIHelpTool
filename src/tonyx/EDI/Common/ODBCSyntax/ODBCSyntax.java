package tonyx.EDI.Common.ODBCSyntax;

public class ODBCSyntax {
	private DataSources ediDataSources;
	private Group ediGroup;

	public DataSources getEdiDataSources() {
		return ediDataSources;
	}

	public void setEdiDataSources(DataSources ediDataSources) {
		this.ediDataSources = ediDataSources;
	}

	public Group getEdiGroup() {
		return ediGroup;
	}

	public void setEdiGroup(Group ediGroup) {
		this.ediGroup = ediGroup;
	}
}
