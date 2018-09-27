package tonyx.EDI.Common.ODBCSyntax;

import tonyx.EDI.Common.Base.ElementCore;

public class ODBCStatement extends ElementCore{
	private Query ediQuery;

	public Query getEdiQuery() {
		return ediQuery;
	}

	public void setEdiQuery(Query ediQuery) {
		this.ediQuery = ediQuery;
	}
}
