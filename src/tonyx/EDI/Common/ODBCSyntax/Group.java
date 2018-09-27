package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreGroup;

public class Group extends CoreGroup implements ChildListOperate{
	private List<Object> childList;

	public Group() {
		childList = new ArrayList<Object>();
	}

	public List<Object> getChildList() {
		return childList;
	}

	public void setChildList(List<Object> childList) {
		this.childList = childList;
	}

	public void setEdiGroup(Group group) {
		childList.add(group);
	}
	
	public void setEdiODBCInputRecord(ODBCInputRecord odbcInputRecord){
		childList.add(odbcInputRecord);
	}
	
	public void setEdiODBCOutputRecord(ODBCOutputRecord odbcOutputRecord){
		childList.add(odbcOutputRecord);
	}
	
	public void setEdiODBCStatement(ODBCStatement odbcStatement){
		childList.add(odbcStatement);
	}
	
	public void setEdiODBCCursor(ODBCCursor odbcCursor){
		childList.add(odbcCursor);
	}
}
