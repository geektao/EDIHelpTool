package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

public class DataSources {
	private List<DataSource> ediDataSource;

	public DataSources() {
		ediDataSource = new ArrayList<DataSource>();
	}

	public List<DataSource> getEdiDataSource() {
		return ediDataSource;
	}

	public void setEdiDataSource(DataSource ediDataSource) {
		this.ediDataSource.add(ediDataSource);
	}
}
