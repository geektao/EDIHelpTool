package tonyx.EDI.Common.PosSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreGroup;

final public class Group extends CoreGroup implements ChildListOperate, Cloneable {
	// store group,PosRecord
	private List<Object> childList;

	public Group() {
		childList = new ArrayList<Object>();
	}

	public List<Object> getChildList() {
		return childList;
	}

	public void setEdiGroup(Group group) {
		childList.add(group);
	}

	public void setEdiPosRecord(PosRecord posRecord) {
		childList.add(posRecord);
	}

	@Override
	public Group clone() {
		Group group = null;
		try {
			group = (Group) super.clone();
			group.childList = new ArrayList<Object>();
			group.setEdiExplicitRule(null);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return group;
	}
}
