package tonyx.EDI.Common.CIISyntax;

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
	
	public void setEdiGroup(Group group){
		childList.add(group);
	}
}
