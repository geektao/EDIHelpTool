package tonyx.EDI.Common.SwiftSyntax;

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

	public void setEdiGroup(Group group) {
		this.childList.add(group);
	}

	public void setEdiSwiftRecord(SwiftRecord swiftRecord) {
		childList.add(swiftRecord);
	}
}
